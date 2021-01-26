package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.TipoSituacaoServico;
import com.basis.sge.sge.servico.dto.TipoSituacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-situacao")
@RequiredArgsConstructor
public class TipoSituacaoRecurso {
    private final TipoSituacaoServico tipoSituacaoServico;

    @GetMapping
    public ResponseEntity<List<TipoSituacaoDTO>> listar(){
        return ResponseEntity.ok(tipoSituacaoServico.lista());
    }
}
