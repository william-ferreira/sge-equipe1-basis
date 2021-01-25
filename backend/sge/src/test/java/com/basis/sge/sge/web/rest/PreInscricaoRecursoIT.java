package com.basis.sge.sge.web.rest;

import com.basis.sge.sge.builder.PreinscricaoBuilder;
import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.repositorio.EventoRepositorio;
import com.basis.sge.sge.repositorio.PreInscricaoRepositorio;
import com.basis.sge.sge.repositorio.UsuarioRepositorio;
import com.basis.sge.sge.servico.EventoServico;
import com.basis.sge.sge.servico.UsuarioServico;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import com.basis.sge.sge.servico.mapper.PreInscricaoMapper;
import com.basis.sge.sge.servico.mapper.UsuarioMapper;
import com.basis.sge.sge.util.IntTestComum;
import com.basis.sge.sge.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class PreInscricaoRecursoIT extends IntTestComum {

    @Autowired
    private PreinscricaoBuilder preinscricaoBuilder = new PreinscricaoBuilder();
    @Autowired
    private PreInscricaoMapper preInscricaoMapper;
    @Autowired
    private PreInscricaoRepositorio preInscricaoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private EventoRepositorio eventoRepositorio;
    @Autowired
    private UsuarioServico usuarioServico;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private EventoServico eventoServico;
    @Autowired
    private EventoMapper eventoMapper;

    @BeforeEach
    public void inicializar() {
        preInscricaoRepositorio.deleteAll();
    }

    @Test
    public void listarTest() throws Exception {
        preinscricaoBuilder.construirEntidade();

        getMockMvc().perform(get("/api/inscricoes"))
                .andExpect(status().isOk());
    }

    @Test
    public void salvarTest() throws Exception {
        PreInscricao preInscricao = preinscricaoBuilder.construirEntidade();

        usuarioServico.salvar(usuarioMapper.toDto(preInscricao.getUsuario()));
        eventoServico.salvar(eventoMapper.toDto(preInscricao.getEvento()));

//        eventoRepositorio.save(preInscricao.getEvento());

        getMockMvc().perform(post("/api/inscricoes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(preInscricaoMapper.toDto(preInscricao))))
                .andExpect(status().isCreated());

    }

    @Test
    public void deletarTest() throws Exception {
        PreInscricao preInscricao = preinscricaoBuilder.construir();
        usuarioRepositorio.save(preInscricao.getUsuario());
        eventoRepositorio.save(preInscricao.getEvento());

        getMockMvc().perform(delete("/api/inscricoes/" + preInscricao.getId())).andExpect(status().isOk());

    }

    @Test
    public void deletarVazioTest() throws Exception {
        getMockMvc().perform(delete("/api/inscricoes/" + 100)).andExpect(status().isBadRequest());

    }

    @Test
    public void idInexistenteTest() throws Exception {
        getMockMvc().perform(get("/api/inscricoes/100"))
                .andExpect(status().isBadRequest());

    }









}
