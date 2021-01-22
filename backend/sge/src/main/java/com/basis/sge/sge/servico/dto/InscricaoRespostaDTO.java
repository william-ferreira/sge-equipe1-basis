package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class InscricaoRespostaDTO implements Serializable {

    @NotEmpty(message = "A resposta não pode ser vazia.")
    private String resposta;

    @NotNull(message = "O id de inscricao não pode ser nulo")
    @NotEmpty(message = "O campo não pode ser vazio")
    private Integer idInscricao;

    @NotNull(message = "O id do evento não pode ser nulo")
    @NotEmpty(message = "O campo não pode ser vazio")
    private Integer idEvento;

    @NotNull(message = "O id da pergunta não pode ser nulo")
    @NotEmpty(message = "O campo não pode ser vazio")
    private Integer idPergunta;
}
