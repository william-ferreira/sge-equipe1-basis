package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PreInscricaoDTO implements Serializable {
    @NotNull(message = "insira um id de Pré Inscrição válido")
    private Integer id;
    @NotNull(message = "insira um id de Tipo de Situação válida")
    private Integer idTipoSituacao;
    @NotNull(message = "insira um id de Tipo de Usuário válido")
    private Integer idUsuario;
    @NotNull(message = "insira um id de Tipo de Evento válido")
    private Integer idEvento;
    @NotNull(message = "A Lista não pode ser Nula")
    private List<InscricaoRespostaDTO> respostas;
}
