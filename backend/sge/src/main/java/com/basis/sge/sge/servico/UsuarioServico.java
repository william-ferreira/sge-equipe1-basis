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
    //private final RegraNegocioException exception;

    public List<UsuarioDTO> listar() {
        List usuarios = usuarioRepositorio.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario usuarioBuscado = usuarioRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário não encontrado."));
        return usuarioMapper.toDto(usuarioBuscado);
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuarioSalvo = usuarioRepositorio.save(usuarioMapper.toEntity(usuarioDTO));
        usuarioSalvo.setChaveUsuario(UUID.randomUUID().toString());
        return usuarioMapper.toDto(usuarioSalvo);
    }

    public UsuarioDTO editar(UsuarioDTO usuarioDTO) {
        Usuario usuarioEditado = usuarioRepositorio.save(usuarioMapper.toEntity(usuarioDTO));
        return usuarioMapper.toDto(usuarioEditado);
    }

    public void remover(Integer id) {
        usuarioRepositorio.deleteById(id);
    }

}
