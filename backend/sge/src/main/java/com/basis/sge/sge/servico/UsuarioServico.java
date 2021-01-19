package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.repositorio.UsuarioRepositorio;
import com.basis.sge.sge.servico.dto.EmailDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.UsuarioMapper;
import com.basis.sge.sge.utils.EmailUtils;
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
    private final EmailUtils emailUtils;


    public List<UsuarioDTO> listar() {
        return usuarioMapper.toDto(usuarioRepositorio.findAll());
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario user = buscar(id);
        return usuarioMapper.toDto(user);
    }

    public Usuario buscar(Integer id){
        return usuarioRepositorio.findById(id)
                .orElseThrow(()-> new RegraNegocioException("Id do usuário não encontrado"));
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario user = usuarioMapper.toEntity(usuarioDTO);
        user.setChaveUsuario(UUID.randomUUID().toString());
        usuarioRepositorio.save(user);

        String mensagem = "Email de testes";

        emailUtils.enviarEmail(user.getEmail(), mensagem, "Cadastro do Usuário");
        return usuarioMapper.toDto(user);
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO){
        Usuario userSalvo = buscar(usuarioDTO.getId());
        Usuario user = usuarioMapper.toEntity(usuarioDTO);
        user.setChaveUsuario(userSalvo.getChaveUsuario());
        usuarioRepositorio.save(user);
        return usuarioMapper.toDto(user);
    }

    public void deletar(Integer id){
        usuarioRepositorio.deleteById(id);
    }
}
