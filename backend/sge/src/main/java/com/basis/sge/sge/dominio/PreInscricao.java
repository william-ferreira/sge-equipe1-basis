package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pre_inscricao")
@Getter
@Setter
public class PreInscricao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_pre_inscricao")
    @SequenceGenerator(name = "sq_id_pre_inscricao", allocationSize = 1, sequenceName = "sq_id_pre_inscricao")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario idUsuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEvento")
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    private Evento idEvento;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idTipoSitucao")
    @JoinColumn(name = "id_tipo_situacao",referencedColumnName = "id")
    private TipoSituacao idTipoSituacao;
}
