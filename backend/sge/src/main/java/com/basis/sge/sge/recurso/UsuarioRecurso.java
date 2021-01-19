package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.UsuarioServico;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.basis.sge.sge.servico.dto.UsuarioDTO;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {

    private final UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> list = usuarioServico.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterPorID(@PathVariable Integer id) {
        UsuarioDTO entidadeDTO = usuarioServico.obterPorId(id);
        return ResponseEntity.ok(entidadeDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO entidadeDTO) {
        UsuarioDTO entidade = usuarioServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO entidadeDTO) {
        UsuarioDTO entidade = usuarioServico.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        usuarioServico.remover(id);
        return ResponseEntity.ok().build();
    }

}
