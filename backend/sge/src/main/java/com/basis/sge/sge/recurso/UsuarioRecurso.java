package com.basis.sge.sge.recurso;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.basis.sge.sge.servico.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioRecurso {

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List list = new ArrayList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{/id}")
    public ResponseEntity<UsuarioDTO> obterPorID(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        return null;
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO usuarioDTO) {
        return null;
    }

    @DeleteMapping("{/id}")
    public void remover(@PathVariable Integer id) {
        //return ResponseEntity.ok().build();
    }

}
