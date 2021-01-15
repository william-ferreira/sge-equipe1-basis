package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.servico.dto.EventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento>{
}
