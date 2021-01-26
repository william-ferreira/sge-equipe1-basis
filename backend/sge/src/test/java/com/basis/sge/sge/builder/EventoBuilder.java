package com.basis.sge.sge.builder;

import com.basis.sge.sge.dominio.*;
import com.basis.sge.sge.repositorio.TipoEventoRepositorio;
import com.basis.sge.sge.servico.EventoServico;
import com.basis.sge.sge.servico.dto.EventoDTO;
import com.basis.sge.sge.servico.dto.TipoEventoDTO;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EventoBuilder extends ConstrutorDeEntidade<Evento>{

    @Autowired
    private EventoServico eventoServico;

    @Autowired
    private EventoMapper eventoMapper;

    @Autowired
    private UsuarioBuilder usuarioBuilder;

    @Override
    public Evento construirEntidade() throws ParseException {
        TipoEvento tpEvento = new TipoEvento();
        tpEvento.setId(1);
        tpEvento.setDescricao("Treinamento");

        List<EventoPergunta> perguntas = new ArrayList<>();

        Evento evento = new Evento();
        evento.setTitulo("Curso de capacitação da Basis");
        evento.setDataInicio(LocalDateTime.now());
        evento.setDataTermino(LocalDateTime.now());
        evento.setDescricao("curso da empresa Basis para ensinar quais são as ferramentas utilizadas no mercado de trabalho");
        evento.setQuantVagas(20);
        evento.setValor(0.0);
        evento.setLocalEvento("Unifacisa");
        evento.setTipoInscricao(true);
        evento.setTipoEvento(tpEvento);
        evento.setPergunta(perguntas);

        return evento;
    }

    @Override
    protected Evento persistir(Evento entidade) {
        EventoDTO eventoDTO = eventoServico.salvar(eventoMapper.toDto(entidade));

        return eventoMapper.toEntity(eventoDTO);
    }

    @Override
    public Collection<Evento> obterTodos() {
        return eventoMapper.toEntity(eventoServico.listar());
    }

    @Override
    protected Evento obterPorId(Integer id) {
        return eventoMapper.toEntity(eventoServico.obterPorId(id));
    }

}