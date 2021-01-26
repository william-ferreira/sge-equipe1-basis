package com.basis.sge.sge.web.rest;

import com.basis.sge.sge.builder.PerguntaBuilder;
import com.basis.sge.sge.dominio.Pergunta;
import com.basis.sge.sge.repositorio.PerguntaRepositorio;
import com.basis.sge.sge.servico.mapper.PerguntaMapper;
import com.basis.sge.sge.util.IntTestComum;
import com.basis.sge.sge.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class PerguntaRecursoIT extends IntTestComum {

    @Autowired
    private PerguntaBuilder perguntaBuilder;

    @Autowired
    private PerguntaMapper perguntaMapper;

    @Autowired
    private PerguntaRepositorio perguntaRepositorio;

    @BeforeEach
    public void inicializar() {
        perguntaRepositorio.deleteAll();
    }

    @Test
    public void listarTest() throws Exception {
        perguntaBuilder.construir();
        getMockMvc().perform(get("/api/perguntas"))
                .andExpect(status().isOk());
    }

    @Test
    public void salvarTest() throws Exception {
        Pergunta pergunta = perguntaBuilder.construirEntidade();
        getMockMvc().perform(post("/api/perguntas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perguntaMapper.toDto(pergunta))))
                .andExpect(status().isCreated());
    }

    @Test
    public void editarTest() throws Exception {
        Pergunta pergunta = perguntaBuilder.construir();
        pergunta.setTitulo("Novo titulo");

        getMockMvc().perform(put("/api/perguntas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perguntaMapper.toDto(pergunta))))
                .andExpect(status().isOk());

    }

    @Test
    public void removerTest() throws Exception {
        Pergunta pergunta = perguntaBuilder.construir();
        String id = pergunta.getId().toString();

        getMockMvc().perform(delete("/api/perguntas/".concat(id)))
                .andExpect(status().isOk());
    }
}



