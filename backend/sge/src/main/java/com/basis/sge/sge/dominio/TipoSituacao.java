package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tipo_situacao")
@Setter
@Getter
public class TipoSituacao implements Serializable {

    @Id
    private Integer id;

    @Column(name = "descricao")
    private String descricao;
}
