package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.TipoEvento;
import com.basis.sge.sge.servico.dto.TipoEventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TipoEventoMapper extends EntityMapper<TipoEventoDTO, TipoEvento> {
}
