package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Integer id;

    @NotNull(message = "Por favor, insira um nome válido.")
    private String nome;

    @NotNull(message = "Por favor, insira um CPF válido.")
    @Size(min = 11, max = 11)
    private String cpf;

    @NotNull(message = "Por favor, insira seu endereço de email.")
    @Email(message = "Formato de email inválido.")
    private String email;

    @Size(min = 10, max = 14, message = "Por favor, insira um número de telefone válido.")
    private String telefone;

    @NotNull(message = "Insira uma data válida.")
    private LocalDate dataNascimento;

}
