package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "pre_inscricao")
@Getter
@Setter
public class PreInscricao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_pre_inscricao")
    @SequenceGenerator(name = "sq_id_pre_inscricao", allocationSize = 1, sequenceName = "sq_id_pre_inscricao")
    @Column(name="id")
    private Integer id;


    @Column(name = "id_usuario")
    @ManyToOne
    @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_evento")
    @ManyToOne
    @JoinColumn(name = "id_evento",referencedColumnName = "id_evento")
    private Integer idEvento;

    @Column(name = "id_tipo_situacao")
    @ManyToOne
    @JoinColumn(name = "id_tipo_situacao",referencedColumnName = "id_situacao")
    private Integer idTipoSituacao;
}
