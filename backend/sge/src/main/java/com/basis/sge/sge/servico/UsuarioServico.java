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

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServico {
    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> listar() {
        return usuarioMapper.toDto(usuarioRepositorio.findAll());
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario user = usuarioRepositorio.findById(id)
                .orElseThrow(()-> new RegraNegocioException("Id do usuário não encontrado"));
        return null;
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        usuarioRepositorio.save(usuarioMapper.toEntity(usuarioDTO));
        return usuarioDTO;
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO){
        usuarioRepositorio.save(usuarioMapper.toEntity(usuarioDTO));
        return usuarioDTO;
    }

    public void deletar(Integer id){
        usuarioRepositorio.deleteById(id);
    }
}
