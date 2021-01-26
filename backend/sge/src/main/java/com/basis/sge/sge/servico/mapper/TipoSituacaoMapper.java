package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.TipoSituacao;
import com.basis.sge.sge.servico.dto.TipoSituacaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TipoSituacaoMapper extends EntityMapper<TipoSituacaoDTO, TipoSituacao> {
}