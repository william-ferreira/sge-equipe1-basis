package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.servico.dto.EventoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EventoPertuntaMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento>{

    @Override
    @Mapping(source = "idTipoEvento", target = "idTipoEvento.id")
    Evento toEntity(EventoDTO eventoDTO);

    @Override
    @Mapping(source = "idTipoEvento.id", target = "idTipoEvento")
    EventoDTO toDto(Evento evento);
}
