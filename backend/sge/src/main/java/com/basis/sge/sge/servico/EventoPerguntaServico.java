package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.EventoPergunta;
import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.repositorio.EventoPerguntaRepositorio;
import com.basis.sge.sge.repositorio.PreInscricaoRepositorio;
import com.basis.sge.sge.servico.dto.EventoPerguntaDTO;
import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.EventoPerguntaMapper;
import com.basis.sge.sge.servico.mapper.PreInscricaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoPerguntaServico {

    private final EventoPerguntaRepositorio eventoPerguntaRepositorio;
    private final EventoPerguntaMapper eventoPerguntaMapper;

    public List<EventoPerguntaDTO> listar() {
        List<EventoPergunta> listaEventoPergunta = eventoPerguntaRepositorio.findAll();
        return eventoPerguntaMapper.toDto(listaEventoPergunta);
    }

    public EventoPerguntaDTO salvar(EventoPerguntaDTO eventoPerguntaDTO) {
        EventoPergunta eventoPergunta = eventoPerguntaMapper.toEntity(eventoPerguntaDTO);
        eventoPerguntaRepositorio.save(eventoPergunta);
        return eventoPerguntaMapper.toDto(eventoPergunta);
    }

    public List<EventoPerguntaDTO> listarPorIdEvento(Integer idEvento) {
        List<EventoPergunta> listaEventoPergunta = eventoPerguntaRepositorio.findAllByEventoId(idEvento);
        return eventoPerguntaMapper.toDto(listaEventoPergunta);
    }

}
