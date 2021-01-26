package com.basis.sge.sge.builder;

import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.servico.UsuarioServico;
import com.basis.sge.sge.servico.dto.UsuarioDTO;
import com.basis.sge.sge.servico.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class UsuarioBuilder extends ConstrutorDeEntidade<Usuario> {

    @Autowired
    private UsuarioServico usuarioServico;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public Usuario construirEntidade() throws ParseException {

        Usuario usuario = new Usuario();
        usuario.setCpf("00000000000");
        usuario.setDataNascimento(LocalDate.now());
        usuario.setEmail("email@gmail.com");
        usuario.setNome("Usuario");
        usuario.setTelefone("12345678912345");

        return usuario;
    }

    @Override
    protected Usuario persistir(Usuario entidade) {
        UsuarioDTO usuarioDTO = usuarioServico.salvar(usuarioMapper.toDto(entidade));
        return usuarioMapper.toEntity(usuarioDTO);
    }

    @Override
    protected Collection<Usuario> obterTodos() {
        return usuarioMapper.toEntity(usuarioServico.listar());
    }

    @Override
    protected Usuario obterPorId(Integer id) {
        return usuarioMapper.toEntity(usuarioServico.obterPorId(id));
    }

}
