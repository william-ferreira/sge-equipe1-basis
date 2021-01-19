package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.repositorio.EventoRepositorio;
import com.basis.sge.sge.servico.dto.EventoDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoServico {

    private final EventoRepositorio eventoRepositorio;
    private final EventoMapper eventoMapper;

    public List<EventoDTO> listar() {
        List<Evento> eventos = eventoRepositorio.findAll();
        return eventoMapper.toDto(eventos);
    }

    public EventoDTO obterPorId(Integer id){
        Evento evento = buscar(id);
        return eventoMapper.toDto(evento);
    }

    public EventoDTO salvar(EventoDTO eventoDTO){
        Evento evento = eventoMapper.toEntity(eventoDTO);
        eventoRepositorio.save(evento);
        return  eventoMapper.toDto(evento);
    }

    public EventoDTO editar(EventoDTO eventoDTO){
        Evento evento = eventoMapper.toEntity(eventoDTO);
        eventoRepositorio.save(evento);
        return  eventoMapper.toDto(evento);
    }

    public void remover(Integer id){
        Evento evento = buscar(id);
        eventoRepositorio.delete(evento);
    }

    private Evento buscar(Integer id) {
        return eventoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Evento não encontrado."));
    }
}
