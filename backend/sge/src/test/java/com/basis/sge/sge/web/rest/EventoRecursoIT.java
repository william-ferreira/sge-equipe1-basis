package com.basis.sge.sge.web.rest;

import com.basis.sge.sge.builder.EventoBuilder;
import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.repositorio.EventoRepositorio;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import com.basis.sge.sge.util.IntTestComum;
import com.basis.sge.sge.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class EventoRecursoIT extends IntTestComum {

    @Autowired
    private EventoBuilder eventoBuilder;

    @Autowired
    private EventoMapper eventoMapper;

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @BeforeEach
    public void inicializar(){
        eventoRepositorio.deleteAll();
    }

    //Tests of expected status is ok
    @Test
    public void listarTest() throws Exception{
        Evento evento = eventoBuilder.construir();
        getMockMvc().perform(get("/api/eventos")).andExpect(status().isOk());
    }
    @Test
    public void obterPorId() throws Exception{
        Evento evento = eventoBuilder.construir();
        getMockMvc().perform(get("/api/eventos/"+evento.getId()))
                .andExpect(status().isOk());

    }

    @Test
    public void editarTest() throws Exception {

        Evento evento = eventoBuilder.construir();
        evento.setTitulo("Alterando titulo");

        getMockMvc().perform(put( "/api/eventos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(eventoMapper.toDto(evento))))
                .andExpect(status().isOk());
    }

    @Test
    public void salvarTest() throws Exception{
        Evento evento = eventoBuilder.construir();

        getMockMvc().perform(post("/api/eventos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(eventoMapper.toDto(evento))))
                .andExpect(status().isCreated());
    }

    @Test
    public void removerTest() throws Exception{
        Evento evento = eventoBuilder.construir();
        getMockMvc().perform(delete("/api/eventos/" + evento.getId()))
                .andExpect(status().isOk());
    }
//------------------------------------------------------------------------------------------------
    //Tests of expected status is bad request
    @Test
    public void listarTestBR() throws Exception{
        getMockMvc().perform(get("/api/eventos")).andExpect(status().isBadRequest());
    }

    @Test
    public void obterPorIdTestBR() throws Exception{
        Evento evento = eventoBuilder.construir();
        evento.setId(null);
        getMockMvc().perform(get("/api/eventos/"+evento.getId()))
                .andExpect(status().isBadRequest());

    }
    @Test
    public void editarTestBR() throws Exception{
        Evento evento = eventoBuilder.construir();
        evento.setTitulo(null);

        getMockMvc().perform(put( "/api/eventos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(eventoMapper.toDto(evento))))
                .andExpect(status().isBadRequest());

    }
    @Test
    public void salvarTestBR() throws Exception{
        Evento evento = null;

        getMockMvc().perform(post("/api/eventos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(eventoMapper.toDto(evento))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void removerTestBR() throws Exception{
        Evento evento = eventoBuilder.construir();
        evento.setId(null);

        getMockMvc().perform(delete("/api/eventos/"+evento.getId()))
                .andExpect(status().isBadRequest());
    }

}
