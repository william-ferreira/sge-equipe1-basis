package com.basis.sge.sge.builder;

import com.basis.sge.sge.dominio.Pergunta;
import com.basis.sge.sge.servico.PerguntaServico;
import com.basis.sge.sge.servico.dto.PerguntaDTO;
import com.basis.sge.sge.servico.mapper.PerguntaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Component
public class PerguntaBuilder extends ConstrutorDeEntidade<Pergunta> {

    @Autowired
    private PerguntaServico perguntaServico;

    @Autowired
    private PerguntaMapper perguntaMapper;

    @Override
    public Pergunta construirEntidade() throws ParseException {

        Pergunta pergunta = new Pergunta();
        pergunta.setTitulo("Nome");
        pergunta.setObrigatoriedade(true);

        return pergunta;
    }

    @Override
    protected Pergunta persistir(Pergunta entidade) {
        PerguntaDTO perguntaDTO = perguntaServico.salvar(perguntaMapper.toDto(entidade));
        return perguntaMapper.toEntity(perguntaDTO);
    }

    @Override
    protected Collection<Pergunta> obterTodos() {
        List<PerguntaDTO> perguntas = perguntaServico.listar();
        return perguntaMapper.toEntity(perguntas);
    }

    @Override
    protected Pergunta obterPorId(Integer id) {
        PerguntaDTO pergunta = perguntaServico.obterPorId(id);
        return perguntaMapper.toEntity(pergunta);
    }
}
