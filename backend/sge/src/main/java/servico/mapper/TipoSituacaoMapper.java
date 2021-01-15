package servico.mapper;

import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.dominio.TipoSituacao;
import org.mapstruct.Mapper;
import servico.dto.PreInscricaoDTO;
import servico.dto.TipoSituacaoDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TipoSituacaoMapper extends EntityMapper <TipoSituacaoDTO, TipoSituacao>{
}
