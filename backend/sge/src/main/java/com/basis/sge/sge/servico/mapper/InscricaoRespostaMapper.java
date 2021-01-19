package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.servico.dto.InscricaoRespostaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface InscricaoRespostaMapper extends EntityMapper<InscricaoRespostaDTO, InscricaoResposta>{
}