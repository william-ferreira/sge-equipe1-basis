package repositorio;

import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.dominio.TipoSituacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSituacaoRepositorio extends JpaRepository<TipoSituacao, Integer> {
}
