package repositorio;

import com.basis.sge.sge.dominio.PreInscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreInscricaoRepositorio extends JpaRepository<PreInscricao, Integer> {
}
