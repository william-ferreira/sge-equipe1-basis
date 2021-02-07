package com.basis.sge.sge.repositorio;

import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.servico.dto.DetalhesInscricaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PreInscricaoRepositorio extends JpaRepository<PreInscricao, Integer> {


    @Modifying
    @Query(value = "select * from pre_inscricao pi where pi.id_tipo_situacao = 1 and pi.id_evento = ?",
            nativeQuery = true)
    List<PreInscricao> findAllByEventoId(Integer id_evento);

    List<PreInscricao> findAllByUsuarioId(Integer id);

    List<PreInscricao> deleteAllByEventoId(Integer id_evento);

}