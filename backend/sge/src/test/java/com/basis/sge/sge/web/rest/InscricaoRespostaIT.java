package com.basis.sge.sge.web.rest;

import com.basis.sge.sge.builder.InscricaoRespostaBuilder;
import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.repositorio.InscricaoRespostaRepositorio;
import com.basis.sge.sge.servico.mapper.InscricaoRespostaMapper;
import com.basis.sge.sge.util.IntTestComum;
import com.basis.sge.sge.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class InscricaoRespostaIT extends IntTestComum {

    @Autowired
    private InscricaoRespostaBuilder inscricaoRespostaBuilder;

    @Autowired
    private InscricaoRespostaMapper inscricaoRespostaMapper;

    @Autowired
    private InscricaoRespostaRepositorio inscricaoRespostaRepositorio;

    @BeforeEach
    public void inicializar() {
        inscricaoRespostaRepositorio.deleteAll();
    }

    @Test
    public void listarTest() throws Exception {
        inscricaoRespostaBuilder.construir();
        getMockMvc().perform(get("/api/perguntas"))
                .andExpect(status().isOk());
    }

    @Test
    public void salvarTest() throws Exception {
        InscricaoResposta inscricaoResposta = inscricaoRespostaBuilder.construirEntidade();
        getMockMvc().perform(post("/api/perguntas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(inscricaoRespostaMapper.toDto(inscricaoResposta))))
                .andExpect(status().isOk());
    }
}
