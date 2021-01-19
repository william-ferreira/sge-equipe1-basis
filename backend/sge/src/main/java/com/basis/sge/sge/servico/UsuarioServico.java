package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.repositorio.UsuarioRepositorio;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.UsuarioMapper;
import com.sun.xml.bind.v2.TODO;
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
    private String chave;

    public List<UsuarioDTO> listar() {
        return usuarioMapper.toDto(usuarioRepositorio.findAll());
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario user = usuarioRepositorio.findById(id)
                .orElseThrow(()-> new RegraNegocioException("Id do usuário não encontrado"));
        return usuarioMapper.toDto(user);
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario user = usuarioRepositorio.save(usuarioMapper.toEntity(usuarioDTO));
        user.setChaveUsuario(UUID.randomUUID().toString());
        chave = user.getChaveUsuario();
        return usuarioMapper.toDto(user);
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO){
        Usuario user = usuarioRepositorio.save(usuarioMapper.toEntity(usuarioDTO));
        user.setChaveUsuario(chave);
        return usuarioMapper.toDto(user);
    }

    public void deletar(Integer id){
        usuarioRepositorio.deleteById(id);
    }
}
