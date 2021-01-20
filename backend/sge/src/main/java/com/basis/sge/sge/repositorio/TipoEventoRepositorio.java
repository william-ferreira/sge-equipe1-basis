package com.basis.sge.sge.repositorio;

import com.basis.sge.sge.dominio.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepositorio extends JpaRepository<TipoEvento, Integer> {
}
