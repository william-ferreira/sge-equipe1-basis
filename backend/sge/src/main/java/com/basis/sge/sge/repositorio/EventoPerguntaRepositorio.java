package com.basis.sge.sge.repositorio;

import com.basis.sge.sge.dominio.EventoPergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoPerguntaRepositorio extends JpaRepository<EventoPergunta, Integer> {

    List<EventoPergunta> findAllByEventoId(Integer eventoId);
}
