package servico.dto;
import com.basis.sge.sge.dominio.PreInscricao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreInscricaoDTO {
    private Integer idPreInscricao;
    private Integer idUsuario;
    private Integer idEvento;
    private Integer idTipoSituacao;
}
