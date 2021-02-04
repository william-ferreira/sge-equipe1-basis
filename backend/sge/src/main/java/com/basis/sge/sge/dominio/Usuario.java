package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
    @SequenceGenerator(name = "sq_usuario", allocationSize = 1, sequenceName = "sq_usuario")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "chave_usuario")
    private String chave;



}
