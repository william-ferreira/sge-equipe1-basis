package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class DetalhesInscricaoDTO {
    private Integer idInscricao;
    private String nomeEvento;
    private String tipoSituacao;
    private String email;
    private String nomeUsuario;
}
