package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="tipo_evento")
public class TipoEvento implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;
}
