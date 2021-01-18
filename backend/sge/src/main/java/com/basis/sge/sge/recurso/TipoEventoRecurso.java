package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.TipoEventoServico;
import com.basis.sge.sge.servico.dto.TipoEventoDTO;
import com.basis.sge.sge.servico.mapper.TipoEventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-evento")
@RequiredArgsConstructor
public class TipoEventoRecurso {
    private final TipoEventoMapper tipoEventoMapper;
    private final TipoEventoServico tipoEventoServico;

    @GetMapping
    public ResponseEntity<List<TipoEventoDTO>> listar(){
        return ResponseEntity.ok(tipoEventoServico.listar());
    }

}
