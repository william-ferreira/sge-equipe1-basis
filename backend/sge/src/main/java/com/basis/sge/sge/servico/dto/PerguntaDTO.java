package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class PerguntaDTO implements Serializable {

    private Integer id;

    @NotNull(message = "O titulo da pergunta nao pode ser nulo")
    @NotEmpty(message = "O titulo da pergunta nao pode ser vazio")
    private String titulo;

    @NotNull
    @NotNull(message = "A obrigatoriedade da pergunta nao pode ser nula")
    private Boolean obrigatoriedade;
}