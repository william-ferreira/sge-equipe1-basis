package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.InscricaoRespostaServico;
import com.basis.sge.sge.servico.dto.InscricaoRespostaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/respostas")
@RequiredArgsConstructor
public class InscricaoRespostaRecurso {

    private final InscricaoRespostaServico inscricaoRespostaServico;

    @GetMapping
    public ResponseEntity<List<InscricaoRespostaDTO>> listar() {
        List<InscricaoRespostaDTO> inscricaoRespostaDTO = inscricaoRespostaServico.listar();
        return new ResponseEntity<>(inscricaoRespostaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InscricaoRespostaDTO> salvar(@Valid @RequestBody InscricaoRespostaDTO inscricaoRespostaDTO) {
        InscricaoRespostaDTO inscricaoResposta = inscricaoRespostaServico.salvar(inscricaoRespostaDTO);
        return ResponseEntity.ok(inscricaoResposta);
    }
}
