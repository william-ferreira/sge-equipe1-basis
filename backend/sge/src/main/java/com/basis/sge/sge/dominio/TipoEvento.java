package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tipo_evento")
@Getter
@Setter
public class TipoEvento implements Serializable {
    @Id
    private Integer id;

    @Column(name="descricao")
    private String descricao;
}
