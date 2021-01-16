package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.PerguntaServico;
import com.basis.sge.sge.servico.dto.PerguntaDTO;
import com.basis.sge.sge.servico.dto.UsuarioDTO;
import liquibase.pro.packaged.U;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/pergunta")
@RequiredArgsConstructor
public class PerguntaRecurso {

    private final PerguntaServico perguntaServico;

    @GetMapping
    public ResponseEntity<List<PerguntaDTO>> listar() {
        List<PerguntaDTO> perguntas = perguntaServico.listar();
        return ResponseEntity.ok(perguntas);
    }

    @GetMapping("{/id}")
    public ResponseEntity<PerguntaDTO> obterPorId(@PathVariable int id) {
        PerguntaDTO perguntaDTO = perguntaServico.obterPorId(id);
        return ResponseEntity.ok(perguntaDTO);
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<PerguntaDTO> salvar(@RequestBody PerguntaDTO perguntaDTO) {
        PerguntaDTO perguntaDTOAux = perguntaServico.salvar(perguntaDTO);
        return ResponseEntity.created(new URI("/api/pergunta")).body(perguntaDTOAux);
    }

    @PutMapping
    public ResponseEntity<PerguntaDTO> editar(@RequestBody UsuarioDTO usuarioDTO) {

        return null;
    }

    @DeleteMapping("{/id}")
    public void remover() {
    }
}
