package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InscricaoChaveUsuarioDTO implements Serializable {

    private Integer idInscricao;
    private String chaveUsuario;
}
