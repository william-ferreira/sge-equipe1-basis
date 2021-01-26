package com.basis.sge.sge.repositorio;

import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.dominio.InscricaoRespostaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRespostaRepositorio extends JpaRepository<InscricaoResposta, InscricaoRespostaId> {

}