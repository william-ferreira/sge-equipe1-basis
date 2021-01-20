package com.basis.sge.sge.servico.mapper;

import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InscricaoRespostaMapper.class})
public interface PreInscricaoMapper extends EntityMapper<PreInscricaoDTO, PreInscricao> {

    @Override
    @Mapping(source = "idUsuario", target = "usuario.id")
    @Mapping(source = "idTipoSituacao", target = "tipoSituacao.id")
    @Mapping(source = "idEvento", target = "evento.id")
    PreInscricao toEntity(PreInscricaoDTO preInscricaoDTO);

    @Override
    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "evento.id", target = "idEvento")
    @Mapping(source = "tipoSituacao.id", target = "idTipoSituacao")
    PreInscricaoDTO toDto(PreInscricao preInscricao);
}
