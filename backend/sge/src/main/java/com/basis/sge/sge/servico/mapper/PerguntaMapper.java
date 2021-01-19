package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.Pergunta;
import com.basis.sge.sge.servico.dto.PerguntaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PerguntaMapper extends EntityMapper<PerguntaDTO, Pergunta>{
}
