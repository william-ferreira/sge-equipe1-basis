package com.basis.sge.sge.repositorio;

import com.basis.sge.sge.dominio.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Integer> {

}
