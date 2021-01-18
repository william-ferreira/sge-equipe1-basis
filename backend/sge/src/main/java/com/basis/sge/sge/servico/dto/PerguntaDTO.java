package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PerguntaDTO implements Serializable {

    private int id;
    private String titulo;
    private boolean obrigatoriedade;
}
