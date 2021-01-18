package com.basis.sge.sge.servico.mapper;


import com.basis.sge.sge.dominio.PreInscricao;

import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PreInscricaoMapper extends EntityMapper<PreInscricaoDTO, PreInscricao> {
}
