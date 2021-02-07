package com.basis.sge.sge.recurso;

import com.basis.sge.sge.servico.PreInscricaoServico;
import com.basis.sge.sge.servico.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("/inscricoes-usuario/{idUsuario}")
    public ResponseEntity<List<PreInscricaoDTO>> obterPorIdUsuario(@PathVariable Integer idUsuario) {
        List<PreInscricaoDTO> list = preInscricaoServico.listarPorIdUsuario(idUsuario);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PreInscricaoDTO> salvar(@RequestBody PreInscricaoDTO entidadeDTO) {
        PreInscricaoDTO entidade = preInscricaoServico.salvar(entidadeDTO);
        return ResponseEntity.status(201).body(entidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        preInscricaoServico.remover(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cancelar-inscricao")
    public ResponseEntity<Void> cancelarInscricao(@RequestBody InscricaoChaveUsuarioDTO inscricaoChaveUsuarioDTO) {
        preInscricaoServico.removerPorChave(inscricaoChaveUsuarioDTO);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/cancelar-inscricao-evento")
    public ResponseEntity<Void> cancelarInscricaoPorId(@RequestBody DetalhesInscricaoDTO detalhesInscricaoDTO) {
        preInscricaoServico.cancelarPorIdEvento(detalhesInscricaoDTO);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/aprovar-inscricao-evento/{idPreinscricao}")
    public ResponseEntity<Void> aprovarInscricaoPorId(@PathVariable(value = "idPreinscricao") Integer idPreinscricao) {
        preInscricaoServico.aprovarPorIdEvento(idPreinscricao);
        return ResponseEntity.ok().build();
    }
    @PatchMapping ("/recusar-inscricao-evento/{idPreinscricao}")
    public ResponseEntity<Void> recusarInscricaoPorId(@PathVariable(value = "idPreinscricao") Integer idPreinscricao) {
        preInscricaoServico.recusarPorIdEvento(idPreinscricao);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<PreInscricaoDTO> editarInscricao(@Valid @RequestBody PreInscricaoDTO preInscricaoDTO){
        PreInscricaoDTO entidade = preInscricaoServico.editar(preInscricaoDTO);
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/detalhes-inscricao/{id}")
    public ResponseEntity<List<DetalhesInscricaoDTO>> obterDetalhes(@PathVariable Integer id) {
        List<DetalhesInscricaoDTO> list = preInscricaoServico.listarDetalhesInscricao(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/inscricoes-usuario/{idUsuario}/listagem")
    public ResponseEntity<List<PreInscricaoListagemDTO>> obterListagemPorIdUsuario(@PathVariable Integer idUsuario) {
        List<PreInscricaoListagemDTO> list = preInscricaoServico.listagemPorIdUsuario(idUsuario);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
