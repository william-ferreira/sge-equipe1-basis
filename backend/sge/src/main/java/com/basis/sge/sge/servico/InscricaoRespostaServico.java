package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.InscricaoResposta;
import com.basis.sge.sge.repositorio.InscricaoRespostaRepositorio;
import com.basis.sge.sge.servico.dto.InscricaoRespostaDTO;
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

    public InscricaoRespostaDTO salvar(InscricaoRespostaDTO inscricaoRespostaDTO) {
        InscricaoResposta inscricaoResposta = inscricaoRespostaMapper.toEntity(inscricaoRespostaDTO);
        inscricaoRespostaRepositorio.save(inscricaoResposta);
        return inscricaoRespostaMapper.toDto(inscricaoResposta);
    }
}

