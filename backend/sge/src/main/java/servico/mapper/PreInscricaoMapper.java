package servico.mapper;
import com.basis.sge.sge.dominio.PreInscricao;
import servico.dto.PreInscricaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreInscricaoMapper extends EntityMapper <PreInscricaoDTO,PreInscricao>{
}
