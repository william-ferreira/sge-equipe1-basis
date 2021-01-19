package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.PerguntaServico;
import com.basis.sge.sge.servico.dto.PerguntaDTO;
import com.basis.sge.sge.servico.dto.UsuarioDTO;
import liquibase.pro.packaged.U;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/perguntas")
@RequiredArgsConstructor
public class PerguntaRecurso {

    private final PerguntaServico perguntaServico;

    @GetMapping
    public ResponseEntity<List<PerguntaDTO>> listar() {
        List<PerguntaDTO> list = perguntaServico.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaDTO> obterPorId(@PathVariable Integer id) {
        PerguntaDTO entidadeDTO = perguntaServico.obterPorId(id);
        return ResponseEntity.ok(entidadeDTO);
    }

    @PostMapping
    public ResponseEntity<PerguntaDTO> salvar(@RequestBody PerguntaDTO entidadeDTO) {
        PerguntaDTO entidade = perguntaServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @PutMapping
    public ResponseEntity<PerguntaDTO> editar(@RequestBody PerguntaDTO entidadeDTO) {
        PerguntaDTO entidade = perguntaServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        perguntaServico.remover(id);
        return ResponseEntity.ok().build();
    }
}
