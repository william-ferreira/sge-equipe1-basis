package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.UsuarioServico;
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

    private final UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List list = usuarioServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{/id}")
    public ResponseEntity<UsuarioDTO> obterPorID(@PathVariable Integer id) {
        UsuarioDTO usuarioDTO = usuarioServico.obterPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioServico.salvar(usuarioDTO);
        return ResponseEntity.ok(usuario);
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
