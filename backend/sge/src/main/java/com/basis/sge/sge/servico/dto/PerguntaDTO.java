package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerguntaDTO {

    private int id;
    private String titulo;
    private boolean obrigatoriedade;
}
