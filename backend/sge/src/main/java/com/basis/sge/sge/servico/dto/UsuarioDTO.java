package com.basis.sge.sge.servico.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter

public class UsuarioDTO implements Serializable {
    @NotNull
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String email;
    @NotNull
    private String telefone;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String chaveUsuario;

}
