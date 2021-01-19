package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.repositorio.UsuarioRepositorio;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.basis.sge.sge.servico.dto.UsuarioDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario usuario = buscar(id);
        return usuarioMapper.toDto(usuario);
    }

    public Usuario buscar(Integer id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado."));
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(UUID.randomUUID().toString());
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO editar(UsuarioDTO usuarioDTO) {
        Usuario usuarioSalvo = buscar(usuarioDTO.getId());
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(usuarioSalvo.getChave());
        return usuarioMapper.toDto(usuario);
    }

    public void remover(Integer id) {
        Usuario usuario = buscar(id);
        usuarioRepositorio.delete(usuario);
    }

}
