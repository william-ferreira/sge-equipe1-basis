package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.EventoPergunta;
import com.basis.sge.sge.servico.dto.EventoPerguntaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface EventoPerguntaMapper extends EntityMapper<EventoPerguntaDTO, EventoPergunta>{

   @Override
   @Mapping(source = "idEvento", target = "evento.id")
   @Mapping(source = "idPergunta", target = "pergunta.id")

   @Mapping(source = "idEvento", target = "id.eventoId")
   @Mapping(source = "idPergunta", target = "id.perguntaId")
   EventoPergunta toEntity(EventoPerguntaDTO eventoPerguntaDTO);

    @Override
    @Mapping(source = "evento.id", target = "idEvento")
    @Mapping(source = "pergunta.id", target = "idPergunta")
    EventoPerguntaDTO toDto(EventoPergunta eventoPergunta);

}
