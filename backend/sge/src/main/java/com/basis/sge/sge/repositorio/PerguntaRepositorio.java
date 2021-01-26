package com.basis.sge.sge.repositorio;

import com.basis.sge.sge.dominio.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepositorio extends JpaRepository<Pergunta, Integer> {
}
