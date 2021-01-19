package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.EventoPergunta;
import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.servico.dto.EventoPerguntaDTO;
import com.basis.sge.sge.servico.dto.InscricaoRespostaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface InscricaoRespostaMapper extends EntityMapper<InscricaoRespostaDTO, InscricaoResposta>{

    @Override
    @Mapping(source = "idInscricao", target = "preInscricao.id")
    @Mapping(source = "idEvento", target = "evento.id")
    @Mapping(source = "idPergunta", target = "pergunta.id")

    @Mapping(source = "idInscricao", target = "id.eventoId")
    @Mapping(source = "idEvento", target = "id.perguntaId")
    @Mapping(source = "idPergunta", target = "id.preInscricaoId")
    InscricaoResposta toEntity(InscricaoRespostaDTO inscricaoRespostaDTO);

    @Override
    @Mapping(source = "preInscricao.id", target = "idInscricao")
    @Mapping(source = "evento.id", target = "idEvento")
    @Mapping(source = "pergunta.id", target = "idPergunta")
    InscricaoRespostaDTO toDto(InscricaoResposta inscricaoResposta);

}
