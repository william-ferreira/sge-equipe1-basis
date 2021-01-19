
package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pre_inscricao")
@Getter
@Setter
public class PreInscricao implements Serializable {

    // TODO: Ajustar nome da sequence
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_pre_inscricao")
    @SequenceGenerator(name = "sq_id_pre_inscricao", allocationSize = 1, sequenceName = "sq_id_pre_inscricao")
    @Column(name = "id_pre_inscricao")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_situacao")
    private TipoSituacao tipoSituacao;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "preInscricao")
    private List<InscricaoResposta> respostas;
}
