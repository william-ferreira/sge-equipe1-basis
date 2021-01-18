package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.UsuarioServico;
import com.basis.sge.sge.servico.dto.PerguntaDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.basis.sge.sge.servico.dto.UsuarioDTO;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioRecurso {


    private final UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> usuarios = usuarioServico.listar();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{/id}")
    public ResponseEntity<UsuarioDTO> obterPorID(@PathVariable Integer id) {
        UsuarioDTO usuarioDTO = usuarioServico.obterPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioSalvo = usuarioServico.salvar(usuarioDTO);
        return ResponseEntity.created(new URI("/api/usuario")).body(usuarioSalvo);
    }

    @SneakyThrows
    @PutMapping
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioEditado = usuarioServico.editar(usuarioDTO);
        return ResponseEntity.created(new URI("/api/usuario")).body(usuarioEditado);
    }

    @DeleteMapping("{/id}")
    public void remover(@PathVariable Integer id) {
        usuarioServico.remover(id);
    }

}
