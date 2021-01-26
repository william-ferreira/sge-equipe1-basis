package com.basis.sge.sge.web.rest;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.basis.sge.sge.builder.UsuarioBuilder;
import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.repositorio.UsuarioRepositorio;
import com.basis.sge.sge.servico.UsuarioServico;
import com.basis.sge.sge.servico.dto.UsuarioDTO;
import com.basis.sge.sge.servico.mapper.UsuarioMapper;
import com.basis.sge.sge.util.IntTestComum;
import com.basis.sge.sge.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class UsuarioRecursoIT extends IntTestComum {

    @Autowired
    private UsuarioBuilder usuarioBuilder;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UsuarioServico usuarioServico;

    @BeforeEach
    public void inicializar() {
        usuarioRepositorio.deleteAll();
    }

    @Test
    public void listarTest() throws Exception {
        usuarioBuilder.construir();
        getMockMvc().perform(get( "/api/usuarios"))
                .andExpect(status().isOk());
    }

    // - - - - POST - - - -

    @Test
    public void salvarTest() throws Exception {

        Usuario usuario = usuarioBuilder.construirEntidade();

        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isCreated());
    }

    // Usuário nulo
    @Test
    public void salvarTest2() throws Exception {

        Usuario usuario = null;

        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void salvarTest3() throws Exception { // Salvar usuarios repetidos

        Usuario usuario = usuarioBuilder.construir(); // Salvo no DB
        Usuario usuarioRepetido = usuarioBuilder.construirEntidade();

        // Tentando salvar usuário repetido
        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuarioRepetido))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void salvarTest4() throws Exception { // Salvar usuario com email igual

        Usuario usuario = usuarioBuilder.construirEntidade(); // Salvo no DB
        usuario.setCpf("111111111"); // setando CPF diferente do builder
        persistir(usuario);
        Usuario usuarioEmailRepetido = usuarioBuilder.construirEntidade();

        // Tentando salvar usuário repetido
        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuarioEmailRepetido))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void salvarTest5() throws Exception { // Salvar usuario com CPF igual

        Usuario usuario = usuarioBuilder.construirEntidade(); // Salvo no DB
        usuario.setEmail("outro@gmail.com"); // setando email diferente do builder
        persistir(usuario);
        Usuario usuarioEmailRepetido = usuarioBuilder.construirEntidade();

        // Tentando salvar usuário repetido
        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuarioEmailRepetido))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void salvarTest6() throws Exception { // Salvar usuario com CPF e email utilizados anteriormente

        Usuario usuario = usuarioBuilder.construirEntidade(); // Salvo no DB
        usuario.setEmail("outro@gmail.com"); // setando email diferente do builder
        usuario.setCpf("111111111");
        persistir(usuario);
        Usuario usuarioEmailCPFAntigo = usuarioBuilder.construirEntidade();

        // Tentando salvar usuário repetido
        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuarioEmailCPFAntigo))))
                .andExpect(status().isCreated());
    }

    @Test
    public void salvarTest7() throws Exception { // Salvar usuario com CPF invalido

        Usuario usuario = usuarioBuilder.construirEntidade(); // Salvo no DB
        usuario.setCpf("1"); // CPF tamanho inválido

        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void salvarTest8() throws Exception { // Email em formato inválido

        Usuario usuario = usuarioBuilder.construirEntidade(); // Salvo no DB
        usuario.setEmail("testegmail.com"); // Email inválido (sem @)

        getMockMvc().perform(post( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isBadRequest());
    }

    // - - - - PUT - - - -

    @Test
    public void editarTest() throws Exception {

        Usuario usuario = usuarioBuilder.construir();
        usuario.setNome("Alterando usuario");

        getMockMvc().perform(put( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isOk());
    }

    // Editar um usuário nulo
    @Test
    public void editarTest2() throws Exception {

        Usuario usuario = null;

        getMockMvc().perform(put( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isBadRequest());
    }

    // Editar CPF do usuario para um já existente na base de dados
    @Test
    public void editarTest3() throws Exception {

        Usuario usuario = usuarioBuilder.construirEntidade();
        usuario.setCpf("111111111");
        persistir(usuario);
        Usuario usuarioEditado = usuarioBuilder.construirEntidade();
        usuarioEditado.setCpf("111111111");

        getMockMvc().perform(put( "/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuarioEditado))))
                .andExpect(status().isBadRequest());
    }

    // - - - - DELETE - - - -

    @Test
    public void removerTest() throws Exception {

        Usuario usuario = usuarioBuilder.construir();

        getMockMvc().perform(delete("/api/usuarios/" + usuario.getId())).andExpect(status().isOk());
    }

    @Test
    public void removerTest2() throws Exception { //

        Usuario usuario = usuarioBuilder.construir();

        usuario.setCpf("111111111");
        usuario.setEmail("email2@gmail.com");

        usuario = persistir(usuario); // persistindo usuario editado na base de dados

        Usuario usuario2 = usuarioBuilder.construir();

        // Tamanho da lista pós remoção do usuário 1
        getMockMvc().perform(delete("/api/usuarios/" + usuario.getId())).andExpect(status().isOk());
        Assert.assertEquals(usuarioRepositorio.findAll().size(), 1);

        // Tamanho da lista pós remoção do usuário 2
        getMockMvc().perform(delete("/api/usuarios/" + usuario2.getId())).andExpect(status().isOk());
        Assert.assertEquals(usuarioRepositorio.findAll().size(), 0);

    }

    @Test
    public void removerBadRequestTest() throws Exception { // Tentar remover usuario com um ID diferente

        Usuario usuario = usuarioBuilder.construir();

        // somando um id para intencionalmente diferir do id do usuario criado
        getMockMvc().perform(delete("/api/usuarios/" + (usuario.getId()+1))).andExpect(status().isBadRequest());
    }

    @Test
    public void removerBadRequestTest2() throws Exception { // Tentar remover usuario com a tabela vazia
        int id = 1; // id criado apenas para chamar a requisição
        getMockMvc().perform(delete("/api/usuarios/" + id)).andExpect(status().isBadRequest());
    }

    @Test
    public void removerBadRequestTest3() throws Exception { // Tentar remover sem inserir ID
        getMockMvc().perform(delete("/api/usuarios/id")).andExpect(status().isBadRequest());
    }

    private Usuario persistir(Usuario entidade) {
        UsuarioDTO usuarioDTO = usuarioServico.salvar(usuarioMapper.toDto(entidade));
        return usuarioMapper.toEntity(usuarioDTO);
    }
}