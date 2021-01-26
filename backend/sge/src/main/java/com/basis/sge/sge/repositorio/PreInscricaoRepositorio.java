package com.basis.sge.sge.repositorio;

import com.basis.sge.sge.dominio.PreInscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreInscricaoRepositorio extends JpaRepository<PreInscricao, Integer> {

    List<PreInscricao> findAllByEventoId(Integer id_evento);

    List<PreInscricao> findAllByUsuarioId(Integer id);
}