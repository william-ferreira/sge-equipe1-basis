package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.Pergunta;
import com.basis.sge.sge.repositorio.PerguntaRepositorio;
import com.basis.sge.sge.servico.dto.PerguntaDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.PerguntaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PerguntaServico {

    private final PerguntaRepositorio perguntaRepositorio;
    private final PerguntaMapper perguntaMapper;

    public List<PerguntaDTO> listar() {
        List<Pergunta> perguntas = perguntaRepositorio.findAll();
        return perguntaMapper.toDto(perguntas);
    }

    public PerguntaDTO obterPorId(Integer id) {
        Pergunta pergunta = buscar(id);
        return perguntaMapper.toDto(pergunta);
    }

    public PerguntaDTO salvar(PerguntaDTO perguntaDTO) {
        Pergunta pergunta = perguntaMapper.toEntity(perguntaDTO);
        perguntaRepositorio.save(pergunta);
        pergunta.getId();
        return perguntaMapper.toDto(pergunta);
    }

    public PerguntaDTO editar(PerguntaDTO perguntaDTO) {
        Pergunta pergunta = perguntaMapper.toEntity(perguntaDTO);
        perguntaRepositorio.save(pergunta);
        return perguntaMapper.toDto(pergunta);
    }

    public void remover(Integer id) {
        Pergunta pergunta = buscar(id);
        perguntaRepositorio.delete(pergunta);
    }

    private Pergunta buscar(Integer id) {
        return perguntaRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Pergunta não encontrada."));
    }

}
