package com.basis.sge.sge.recurso;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.servico.EventoServico;
import com.basis.sge.sge.servico.dto.EventoDTO;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoRecurso {

    private final EventoServico eventoServico;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listar(){
        List<EventoDTO> list = eventoServico.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> obterPorId(@PathVariable Integer id){
        EventoDTO entidadeDTO = eventoServico.obterPorId(id);
        return ResponseEntity.ok(entidadeDTO);
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@RequestBody EventoDTO entidadeDTO){
        EventoDTO entidade = eventoServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @PutMapping
    public ResponseEntity<EventoDTO> editar(@RequestBody EventoDTO entidadeDTO){
        EventoDTO entidade = eventoServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        eventoServico.remover(id);
        return ResponseEntity.ok().build();
    }
}

