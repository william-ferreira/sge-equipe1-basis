package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.repositorio.PreInscricaoRepositorio;
import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.PreInscricaoMapper;
import com.basis.sge.sge.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PreInscricaoServico {

    private final PreInscricaoRepositorio inscricaoRepositorio;
    private final PreInscricaoMapper inscricaoMapper;
    private final EmailUtil emailUtil;


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
        PreInscricao inscricao = inscricaoMapper.toEntity(inscricaoDTO);
//
//        String mensagem = "Sua Inscrição no evento"
//                +inscricao.getEvento().getTitulo()+"e sua Chave de Inscricão é "
//                +inscricao.getUsuario().getChave()+"Guarde essa chave para o caso de um Cancelamento";
//
//        emailUtil.enviarEmail( inscricao.getEvento().getTitulo(),mensagem,"Incrição Realizada Com Sucesso");

        inscricaoRepositorio.save(inscricao);

        return inscricaoMapper.toDto(inscricao);
    }

    public void remover(Integer id) {
        PreInscricao inscricao = obter(id);
        inscricaoRepositorio.delete(inscricao);
    }

}