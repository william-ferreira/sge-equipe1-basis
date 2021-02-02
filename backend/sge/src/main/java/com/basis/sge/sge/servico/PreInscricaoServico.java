package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.repositorio.EventoRepositorio;
import com.basis.sge.sge.repositorio.PreInscricaoRepositorio;
import com.basis.sge.sge.repositorio.UsuarioRepositorio;
import com.basis.sge.sge.servico.dto.*;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.PreInscricaoMapper;
import com.basis.sge.sge.servico.producer.SgeProducer;
import com.basis.sge.sge.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PreInscricaoServico {

    private final PreInscricaoRepositorio inscricaoRepositorio;
    private final PreInscricaoMapper inscricaoMapper;
    private final EmailUtil emailUtil;
    private final UsuarioServico usuarioServico;
    private final SgeProducer sgeProducer;

    private final UsuarioRepositorio usuarioRepositorio;
    private final EventoRepositorio eventoRepositorio;

    private static final Integer ID_TIPO_SITUACAO_CANCELADO = 4;

    public List<PreInscricaoDTO> listar() {
        List<PreInscricao> inscricoes = inscricaoRepositorio.findAll();
        return inscricaoMapper.toDto(inscricoes);
    }

    public PreInscricaoDTO obterPorId(Integer id) {
        PreInscricao inscricao = obter(id);
        return inscricaoMapper.toDto(inscricao);
    }

    private PreInscricao obter(Integer id) {
        return inscricaoRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Inscricão não encontrada"));
    }

    public PreInscricaoDTO salvar(PreInscricaoDTO inscricaoDTO) {
        validaUsuarioJaInscrito(inscricaoDTO);

        PreInscricao inscricao = inscricaoMapper.toEntity(inscricaoDTO);
        inscricaoRepositorio.save(inscricao);

        Usuario usuario = usuarioRepositorio.findById(inscricao.getUsuario().getId()).orElseThrow(() -> new RegraNegocioException("Usuario invalido!"));
        Evento evento = eventoRepositorio.findById(inscricao.getEvento().getId()).orElseThrow(() -> new RegraNegocioException("Evento invalido!"));

        String mensagem = "Sua Inscrição no evento"
                + evento.getTitulo() +"e sua Chave de Inscricão é "
                + usuario.getChave() +" Guarde essa chave para o caso de um Cancelamento";

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setCopias(new ArrayList<>());
        emailDTO.setAssunto("Cadastro do Usuário");
        emailDTO.setCorpo(mensagem);
        emailDTO.setDestinatario(usuario.getEmail());

        this.sgeProducer.enviarEmail(emailDTO);

        return inscricaoMapper.toDto(inscricao);
    }

    public void remover(Integer id) {
        PreInscricao preInscricao = inscricaoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Num tem"));

        inscricaoRepositorio.deleteById(id);
    }

    public void removerPorChave(InscricaoChaveUsuarioDTO inscricaoChaveUsuarioDTO) {
        UsuarioDTO usuario = usuarioServico.obterPorChave(inscricaoChaveUsuarioDTO.getChaveUsuario());

        PreInscricaoDTO preInscricaoDTO = obterPorId(inscricaoChaveUsuarioDTO.getIdInscricao());
        if (preInscricaoDTO.getIdTipoSituacao().equals(ID_TIPO_SITUACAO_CANCELADO))
            throw new RegraNegocioException("A situação da pré inscrição já está cancelada");

        preInscricaoDTO.setIdTipoSituacao(ID_TIPO_SITUACAO_CANCELADO);

        PreInscricao preInscricao = inscricaoRepositorio.save(inscricaoMapper.toEntity(preInscricaoDTO));

        enviarEmailCancelamento(inscricaoChaveUsuarioDTO, usuario, preInscricaoDTO);

        inscricaoMapper.toDto(preInscricao);
    }

    private void enviarEmailCancelamento(InscricaoChaveUsuarioDTO inscricaoChaveUsuarioDTO, UsuarioDTO usuario, PreInscricaoDTO preInscricaoDTO) {
        PreInscricao preInscricao = inscricaoRepositorio.save(inscricaoMapper.toEntity(preInscricaoDTO));
        String corpoEmail = "A pre inscrição no evento foi cancelada com sucesso";
        String assunto = "Cancelamento de pré inscrição";

        emailUtil.enviarEmail(usuario.getEmail(), corpoEmail, assunto, new ArrayList<>());
    }

    private void validaUsuarioJaInscrito(PreInscricaoDTO inscricaoDTO)  throws RegraNegocioException{
        inscricaoRepositorio.findAll().forEach(preInscricao -> {
            Boolean eventoJaExistente = preInscricao.getEvento().getId().equals(inscricaoDTO.getIdEvento());
            Boolean usuarioJaExistente = preInscricao.getUsuario().getId().equals(inscricaoDTO.getIdUsuario());

            if (eventoJaExistente && usuarioJaExistente)
                throw new RegraNegocioException("Já existe um usuário inscrito nesse evento");
        });
    }

    public List<PreInscricaoDTO> listarPorIdUsuario(Integer idUsuario) {
        List<PreInscricao> inscricoes = inscricaoRepositorio.findAllByUsuarioId(idUsuario);
        return inscricaoMapper.toDto(inscricoes);
    }

    
    public List<DetalhesInscricaoDTO> listarDetalhesInscricao(Integer idUsuario){

        List<DetalhesInscricaoDTO> detalhesPreInscricoes = new ArrayList<>();

        for (PreInscricao inscricao: inscricaoRepositorio.findAllByUsuarioId(idUsuario)) {
            DetalhesInscricaoDTO detalhesInscricao = new DetalhesInscricaoDTO();

            detalhesInscricao.setIdInscricao(inscricao.getId());
            setDetalhesEvento(detalhesInscricao, inscricao);
            setDescricaoSituacao(detalhesInscricao, inscricao);

            detalhesPreInscricoes.add(detalhesInscricao);
        }

        return detalhesPreInscricoes;
    }

    private void setDetalhesEvento(DetalhesInscricaoDTO detalhesInscricao, PreInscricao inscricao) {
        Integer idEvento = inscricao.getEvento().getId();
        Evento evento = eventoRepositorio.findById(idEvento).get();

        detalhesInscricao.setNomeEvento(evento.getTitulo());
    }

    private void setDescricaoSituacao(DetalhesInscricaoDTO detalhesInscricao, PreInscricao inscricao) {
        String descricao = inscricao.getTipoSituacao().getDescricao();
        detalhesInscricao.setTipoSituacao(descricao);
    }

}