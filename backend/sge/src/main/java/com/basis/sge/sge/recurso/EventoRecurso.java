package com.basis.sge.sge.recurso;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.servico.EventoServico;
import com.basis.sge.sge.servico.dto.EventoDTO;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoRecurso {
    private final EventoServico eventoServico;
    private final EventoMapper eventoMapper;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listar(){
        List<EventoDTO> listaEventos = eventoServico.listar();
        return ResponseEntity.ok(listaEventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> obterPorId(@PathVariable Integer id){
        EventoDTO evento = eventoServico.obterPorId(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@RequestBody EventoDTO eventoDTO){
        EventoDTO evento = eventoServico.salvar(eventoDTO);
        return ResponseEntity.ok(evento);
    }

    @PutMapping
    public ResponseEntity<EventoDTO> atualizar(@RequestBody EventoDTO eventoDTO){
        EventoDTO evento = eventoServico.atualizar(eventoDTO);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        eventoServico.deletar(id);
    }
}
