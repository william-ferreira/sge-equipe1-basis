package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PreInscricaoListagemDTO {

    private Integer id;
    private String nome;
    private String email;
    private String idInscricao;

}
