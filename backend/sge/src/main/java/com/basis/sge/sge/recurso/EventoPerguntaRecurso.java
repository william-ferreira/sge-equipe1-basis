package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.EventoPerguntaServico;
import com.basis.sge.sge.servico.dto.EventoPerguntaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/evento-pergunta")
@RequiredArgsConstructor
public class EventoPerguntaRecurso {

    private final EventoPerguntaServico eventoPerguntaServico;

    @GetMapping
    public ResponseEntity<List<EventoPerguntaDTO>> listar() {
        List<EventoPerguntaDTO> list = eventoPerguntaServico.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventoPerguntaDTO> salvar(@RequestBody EventoPerguntaDTO entidadeDTO) {
        EventoPerguntaDTO entidade = eventoPerguntaServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

}
