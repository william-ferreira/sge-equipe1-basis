package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.servico.dto.EventoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento>{

    @Override
    @Mapping(source = "idTipoEvento", target = "tipoEvento.id")
    Evento toEntity(EventoDTO eventoDTO);

    @Override
    @Mapping(source = "tipoEvento.id", target = "idTipoEvento")
    EventoDTO toDto(Evento evento);
}
