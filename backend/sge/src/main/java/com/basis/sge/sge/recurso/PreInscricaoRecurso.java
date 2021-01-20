package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.PreInscricaoServico;
import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inscricoes")
@RequiredArgsConstructor
public class PreInscricaoRecurso {

    private final PreInscricaoServico preInscricaoServico;

    @GetMapping
    public ResponseEntity<List<PreInscricaoDTO>> listar() {
        List<PreInscricaoDTO> list = preInscricaoServico.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreInscricaoDTO> obterPorId(@PathVariable Integer id) {
        PreInscricaoDTO entidadeDTO = preInscricaoServico.obterPorId(id);
        return ResponseEntity.ok(entidadeDTO);
    }

    @PostMapping
    public ResponseEntity<PreInscricaoDTO> salvar(@RequestBody PreInscricaoDTO entidadeDTO) {
        PreInscricaoDTO entidade = preInscricaoServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        preInscricaoServico.remover(id);
        return ResponseEntity.ok().build();
    }

}
