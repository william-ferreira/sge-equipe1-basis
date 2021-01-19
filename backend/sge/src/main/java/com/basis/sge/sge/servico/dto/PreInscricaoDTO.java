package com.basis.sge.sge.servico.dto;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.dominio.TipoSituacao;
import com.basis.sge.sge.dominio.Usuario;

import java.io.Serializable;
import java.util.List;

public class PreInscricaoDTO implements Serializable {

    private Integer id;
    private Integer idUsuario;
    private Integer idEvento;
    private List<InscricaoRespostaDTO> respostas;
}
