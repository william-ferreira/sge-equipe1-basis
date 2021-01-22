package com.basis.sge.sge.builder;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.EventoPergunta;
import com.basis.sge.sge.dominio.EventoPerguntaId;
import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.dominio.InscricaoRespostaId;
import com.basis.sge.sge.dominio.Pergunta;
import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.dominio.TipoEvento;
import com.basis.sge.sge.dominio.TipoSituacao;
import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.servico.InscricaoRespostaServico;
import com.basis.sge.sge.servico.dto.InscricaoRespostaDTO;
import com.basis.sge.sge.servico.dto.PerguntaDTO;
import com.basis.sge.sge.servico.mapper.InscricaoRespostaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class InscricaoRespostaBuilder extends ConstrutorDeEntidade<InscricaoResposta> {

    @Autowired
    private InscricaoRespostaServico inscricaoRespostaServico;

    @Autowired
    private InscricaoRespostaMapper inscricaoRespostaMapper;

    @Override
    public InscricaoResposta construirEntidade() throws ParseException {

        //Criação das Situações do Evento
        TipoSituacao tipoSituacao = new TipoSituacao();
        tipoSituacao.setDescricao("Aprovada");

        //Criação do Tipo do Evento
        TipoEvento tipoEvento = new TipoEvento();
        tipoEvento.setDescricao("Treinamento");

        //Criação do Evento
        Evento evento = new Evento();
        List<EventoPergunta> perguntas = new ArrayList<>();
        evento.setTitulo("Curso de capacitação da Basis");
        evento.setDataInicio(LocalDateTime.now());
        evento.setDataTermino(LocalDateTime.now());
        evento.setDescricao("curso da empresa");
        evento.setQuantVagas(20);
        evento.setValor(0.0);
        evento.setLocalEvento("Unifacisa");
        evento.setTipoInscricao(true);
        evento.setTipoEvento(tipoEvento);
        evento.setPerguntas(perguntas);

        //Criação de Usuário
        Usuario usuario = new Usuario();
        usuario.setCpf("37128105042");
        usuario.setDataNascimento(LocalDate.now());
        usuario.setEmail("teste@gmail.com");
        usuario.setNome("Usuário de teste");
        usuario.setTelefone("999999999");

        //Criação da PreInscricao
        PreInscricao preInscricao = new PreInscricao();
        preInscricao.setEvento(evento);
        preInscricao.setUsuario(usuario);
        preInscricao.setTipoSituacao(tipoSituacao);

        //Criação de Pergunta
        Pergunta pergunta = new Pergunta();
        pergunta.setId(1);
        pergunta.setTitulo("Nome");
        pergunta.setObrigatoriedade(true);

        //Criação de Evento pergunta
        EventoPerguntaId eventoPerguntaId = new EventoPerguntaId();
        eventoPerguntaId.setPerguntaId(1);
        eventoPerguntaId.setEventoId(1);

        //Criação de Inscrição Resposta ID
        InscricaoRespostaId inscricaoRespostaId = new InscricaoRespostaId();
        inscricaoRespostaId.setIdPreInscricao(1);
        inscricaoRespostaId.setIdPergunta(1);
        inscricaoRespostaId.setIdEvento(1);

        //Criação de Inscrição Resposta
        InscricaoResposta inscricaoResposta = new InscricaoResposta();
        inscricaoResposta.setId(inscricaoRespostaId);
        inscricaoResposta.setEvento(evento);
        inscricaoResposta.setPergunta(pergunta);
        inscricaoResposta.setPreInscricao(preInscricao);

        return inscricaoResposta;
    }

    @Override
    protected InscricaoResposta persistir(InscricaoResposta entidade) {
        InscricaoRespostaDTO inscricaoRespostaDTO = inscricaoRespostaServico.salvar(inscricaoRespostaMapper.toDto(entidade));
        return inscricaoRespostaMapper.toEntity(inscricaoRespostaDTO);
    }

    @Override
    protected Collection<InscricaoResposta> obterTodos() {
        List<InscricaoRespostaDTO> inscricaoRespostaDTO = inscricaoRespostaServico.listar();
        return inscricaoRespostaMapper.toEntity(inscricaoRespostaDTO);
    }

    @Override
    protected InscricaoResposta obterPorId(Integer id) {
        return null;
    }
}
