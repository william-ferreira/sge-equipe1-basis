
package com.basis.sge.sge.servico;

import com.basis.sge.sge.repositorio.TipoEventoRepositorio;
import com.basis.sge.sge.servico.dto.TipoEventoDTO;
import com.basis.sge.sge.servico.mapper.TipoEventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoEventoServico {
    private final TipoEventoMapper tipoEventoMapper;
    private final TipoEventoRepositorio tipoEventoRepositorio;

    public List<TipoEventoDTO> listar() {
        return tipoEventoMapper.toDto(tipoEventoRepositorio.findAll());
    }
}
