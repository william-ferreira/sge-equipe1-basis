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
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginRecurso {

    private final UsuarioServico usuarioServico;

    @GetMapping("/{key}")
    public ResponseEntity<UsuarioDTO> obterPorChave(@PathVariable String key) throws URISyntaxException {
        UsuarioDTO entidadeDTO = usuarioServico.obterPorChave(key);
        return ResponseEntity.ok(entidadeDTO);
    }

}
