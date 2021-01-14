package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name = "pergunta")
@Getter
@Setter
public class Pergunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pergunta")
    @SequenceGenerator(name = "sq_pergunta", allocationSize = 1, sequenceName = "sq_pergunta")
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "obrigatoriedade")
    private boolean obrigatoriedade;

    //@ManyToMany()
    //private List<Evento> eventos;
}
