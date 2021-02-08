package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Usuario;
import com.basis.sge.sge.repositorio.UsuarioRepositorio;
import com.basis.sge.sge.servico.dto.EmailDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.UsuarioMapper;
import com.basis.sge.sge.servico.producer.SgeProducer;
import com.basis.sge.sge.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.basis.sge.sge.servico.dto.UsuarioDTO;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;
    private final EmailUtil emailUtil;
    private final SgeProducer sgeProducer;

    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario usuario = buscar(id);
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(UUID.randomUUID().toString());

        // Verifica os campos de CPF e email antes de salvar o usuário no banco
        if (cpfExistente(usuario)) { throw new RegraNegocioException("O número de CPF já está sendo utilizado."); }
        if (emailExistente(usuario)) { throw new RegraNegocioException("O endereço de email já está sendo utilizado."); }

        // TODO: Refatorar envio de email
        String mensagem = "Email de testes";
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setCopias(new ArrayList<>());
        emailDTO.setAssunto("Cadastro do Usuário");
        emailDTO.setCorpo(mensagem);
        emailDTO.setDestinatario(usuario.getEmail());

        this.sgeProducer.enviarEmail(emailDTO);

        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO editar(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getId()==null) { usuarioDTO.setId(0); } // TODO: Refatorar todas as validações de maneira mais eficiente e coesa
        Usuario usuarioSalvo = buscar(usuarioDTO.getId());
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(usuarioSalvo.getChave());

        if (cpfExistente(usuario) && (((usuarioSalvo.getId().intValue())!=(usuario.getId().intValue())))) {
            throw new RuntimeException("O número de CPF já está sendo utilizado."); }
        if (emailExistente(usuario) && (!usuarioSalvo.getId().equals(usuario.getId()))) {
            throw new RegraNegocioException("O endereço de email já está sendo utilizado."); }

        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    public void remover(Integer id) {
        Usuario usuario = buscar(id);
        usuarioRepositorio.delete(usuario);
    }

    public Usuario buscar(Integer id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado."));
    }

    public Boolean idUnico(Usuario usuario) {
        List<Usuario> usuariosNoBanco = usuarioRepositorio.findAll();
        // Percorre usuarios do banco verificando se há algum elemento com o ID de usuario
        for (Usuario u : usuariosNoBanco) {
            if (u.getId()!=null) {
                if (u.getId().intValue() == usuario.getId().intValue()) {
                    return false; // Há um usuário com o mesmo ID na base de dados
                }
            }
        }

        return true; // O ID do usuario é único no banco
    }

    public Boolean cpfExistente(Usuario usuario) {
        List<Usuario> usuariosNoBanco = usuarioRepositorio.findAll();
        // Percorre usuarios do banco verificando se o CPF é unico
        for (Usuario u : usuariosNoBanco) {
            if (u.getCpf().contentEquals(usuario.getCpf())) {
                return true; // O CPF já está sendo utilizado por algum usuário no banco
            }
        }

        return false;
    }

    public Boolean emailExistente(Usuario usuario) {
        List<Usuario> usuariosNoBanco = usuarioRepositorio.findAll();

        for (Usuario u : usuariosNoBanco) {
            if (u.getEmail().contentEquals(usuario.getEmail())) {
                return true; // O email já está sendo utilizado por algum usuário no banco
            }
        }

        return false;
    }

    public UsuarioDTO obterPorChave(String chave) {
        if (isAdmin(chave)) {
            Usuario admin = buscar(1); // Pesquisando por ID 1, encontrará o admin no banco

            return usuarioMapper.toDto(admin);
        } else {
            Usuario usuario = usuarioRepositorio.findByChave(chave);

            if (usuario == null) {
                throw new RegraNegocioException("Não há um usuario com essa chave na base");
            }

            return usuarioMapper.toDto(usuario);
        }
    }

    public Boolean isAdmin(String chave) {
        if (chave.contentEquals("administradorsgebasis")) {
            return true;
        }
        return false;
    }

}
