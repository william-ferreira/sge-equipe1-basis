package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.repositorio.PreInscricaoRepositorio;
import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.PreInscricaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PreInscricaoServico {

    private final PreInscricaoRepositorio inscricaoRepositorio;
    private final PreInscricaoMapper inscricaoMapper;

    public List<PreInscricaoDTO> listar() {
        List<PreInscricao> inscricoes = inscricaoRepositorio.findAll();
        return inscricaoMapper.toDto(inscricoes);
    }

    public PreInscricaoDTO obterPorId(Integer id) {
        PreInscricao inscricao = obter(id);
        return inscricaoMapper.toDto(inscricao);
    }

    private PreInscricao obter(Integer id) {
        return inscricaoRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Inscricão não encontrada"));
    }

    public PreInscricaoDTO salvar(PreInscricaoDTO inscricaoDTO) {
        PreInscricao inscricao = inscricaoMapper.toEntity(inscricaoDTO);
        inscricaoRepositorio.save(inscricao);
        return inscricaoMapper.toDto(inscricao);
    }

    public PreInscricaoDTO editar(PreInscricaoDTO inscricaoDTO) {
        PreInscricao inscricao = inscricaoMapper.toEntity(inscricaoDTO);
        inscricaoRepositorio.save(inscricao);
        return inscricaoMapper.toDto(inscricao);
    }

    public void remover(Integer id) {
        PreInscricao inscricao = obter(id);
        inscricaoRepositorio.delete(inscricao);
    }

}
