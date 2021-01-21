package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.dominio.InscricaoRespostaId;
import com.basis.sge.sge.repositorio.InscricaoRespostaRepositorio;
import com.basis.sge.sge.servico.dto.InscricaoRespostaDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.InscricaoRespostaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InscricaoRespostaServico {

    private final InscricaoRespostaRepositorio inscricaoRespostaRepositorio;
    private final InscricaoRespostaMapper inscricaoRespostaMapper;

    public List<InscricaoRespostaDTO> listar() {
        List<InscricaoResposta> inscricoes = inscricaoRespostaRepositorio.findAll();
        return inscricaoRespostaMapper.toDto(inscricoes);
    }

    public InscricaoRespostaDTO obterPorIds(InscricaoRespostaId inscricaoRespostaId) {
        List<InscricaoResposta> inscricoes = inscricaoRespostaRepositorio.findAll();

        //acho que s resolve  um id.equals(id) implementando o compareTo()
        for (InscricaoResposta inscricaoResposta : inscricoes) {
            if (compararIds(inscricaoResposta.getId(), inscricaoRespostaId))
                return inscricaoRespostaMapper.toDto(inscricaoResposta);
        }

        throw new RegraNegocioException("Não existe uma resposta com esse id!");
    }

    public InscricaoRespostaDTO salvar(InscricaoRespostaDTO inscricaoRespostaDTO) {
        InscricaoResposta inscricaoResposta = inscricaoRespostaMapper.toEntity(inscricaoRespostaDTO);
        inscricaoRespostaRepositorio.save(inscricaoResposta);
        return inscricaoRespostaMapper.toDto(inscricaoResposta);
    }

    private boolean compararIds(InscricaoRespostaId inscricaoRespostaId, InscricaoRespostaId inscricaoRespostaIdAux) {
        if (inscricaoRespostaId.getIdPreInscricao().equals(inscricaoRespostaIdAux.getIdPreInscricao())
                && inscricaoRespostaId.getIdEvento().equals(inscricaoRespostaIdAux.getIdEvento())
                && inscricaoRespostaId.getIdPergunta().equals(inscricaoRespostaIdAux.getIdPergunta())
        )
            return true;
        return false;
    }
}

