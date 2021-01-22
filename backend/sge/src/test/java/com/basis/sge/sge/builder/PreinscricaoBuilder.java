package com.basis.sge.sge.builder;

import com.basis.sge.sge.dominio.*;
import com.basis.sge.sge.repositorio.PreInscricaoRepositorio;
import com.basis.sge.sge.servico.PreInscricaoServico;
import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import com.basis.sge.sge.servico.mapper.PreInscricaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PreinscricaoBuilder extends ConstrutorDeEntidade<PreInscricao> {
    @Autowired
    private PreInscricaoServico preInscricaoServico;

    @Autowired
    private PreInscricaoMapper preInscricaoMapper;

    @Autowired
    private PreInscricaoRepositorio preInscricaoRepositorio;

    @Override
    public PreInscricao construirEntidade() throws ParseException{
        TipoEvento tipoEvento = new TipoEvento();
        PreInscricao preInscricao = new PreInscricao();
        Usuario usuario = new Usuario();
        TipoSituacao tipoSituacao = new TipoSituacao();
        Evento evento = new Evento();
        List<EventoPergunta> perguntas = new ArrayList<>();

        //Criação das Situações do Evento

        tipoSituacao.setDescricao("Aprovada");

        //Criação do Tipo do Evento
        tipoEvento.setId(1);
        tipoEvento.setDescricao("Treinamento");


        //Criação do Evento
        evento.setId(null);
        evento.setTitulo("Curso de capacitação da Basis");
        evento.setDataInicio(LocalDateTime.now());
        evento.setDataTermino(LocalDateTime.now());
        evento.setDescricao("curso da empresa Basis para ensinar quais são as ferramentas utilizadas no mercado de trabalho");
        evento.setQuantVagas(20);
        evento.setValor(0.0);
        evento.setLocalEvento("Unifacisa");
        evento.setTipoInscricao(true);
        evento.setTipoEvento(tipoEvento);
        evento.setPerguntas(perguntas);

        //Criação de Usuário
        usuario.setId(null);
        usuario.setCpf("37128105042");
        usuario.setDataNascimento(LocalDate.now());
        usuario.setEmail("teste@gmail.com");
        usuario.setNome("Usuário de teste");
        usuario.setTelefone("999999999");

        //Criação da PreInscricao

        preInscricao.setEvento(evento);
        preInscricao.setUsuario(usuario);
        preInscricao.setTipoSituacao(tipoSituacao);

        return preInscricao;
    }

    @Override
    protected PreInscricao persistir(PreInscricao entidade) {
        PreInscricaoDTO preInscricaoDTO = preInscricaoServico.salvar(preInscricaoMapper.toDto(entidade));
        return preInscricaoMapper.toEntity(preInscricaoDTO);
    }

    @Override
    protected Collection<PreInscricao> obterTodos(){
        return preInscricaoMapper.toEntity(preInscricaoServico.listar());
    }

    @Override
    protected PreInscricao obterPorId(Integer id) {

        PreInscricao preInscricao = preInscricaoRepositorio.findById(id).orElse(null);

        return preInscricao;
    }

    public void limparBanco(){

        preInscricaoRepositorio.deleteAll();
    }
    public Object converterToDTO(PreInscricao preInscricao){

        return preInscricaoMapper.toDto(preInscricao);
    }

    public PreInscricao criar(PreInscricao preInscricao){

        return preInscricaoRepositorio.save(preInscricao);
    }
}
