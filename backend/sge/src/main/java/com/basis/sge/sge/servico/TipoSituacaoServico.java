package com.basis.sge.sge.servico;

import com.basis.sge.sge.repositorio.TipoSituacaoRepositorio;
import com.basis.sge.sge.servico.dto.TipoSituacaoDTO;
import com.basis.sge.sge.servico.mapper.TipoSituacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class TipoSituacaoServico {
    private final TipoSituacaoMapper tipoEventoMapper;
    private final TipoSituacaoRepositorio tipoSituacaoRepositorio;

    public List<TipoSituacaoDTO> lista(){
        return tipoEventoMapper.toDto(tipoSituacaoRepositorio.findAll());
    }
}
