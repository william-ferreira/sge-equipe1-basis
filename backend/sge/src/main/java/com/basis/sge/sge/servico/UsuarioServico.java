package com.basis.sge.sge.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.basis.sge.sge.servico.dto.UsuarioDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServico {

    public List<UsuarioDTO> listar() {
        return null;
    }

    public UsuarioDTO obterPorId(Integer id) {
        return null;
    }

}
