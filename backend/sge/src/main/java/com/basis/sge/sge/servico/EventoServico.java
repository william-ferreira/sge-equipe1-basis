package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.servico.dto.EventoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoServico {
    private final List<EventoDTO> listaEventos = new ArrayList<>();

    public List<EventoDTO> listar() {
        return this.listaEventos;
    }

    public EventoDTO obterPorId(Integer id){
        return this.listaEventos.get(id);
    }

    public EventoDTO salvar(EventoDTO evento){
        this.listaEventos.add(evento);
        return evento;
    }

    public EventoDTO update(Integer id, EventoDTO eventoDTO){
        this.listaEventos.set(id, eventoDTO);
        return eventoDTO;
    }

    public void deletar(EventoDTO eventoDTO){
        this.listaEventos.remove(eventoDTO);
    }
}
