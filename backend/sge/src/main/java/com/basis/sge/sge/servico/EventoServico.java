package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.repositorio.EventoRepositorio;
import com.basis.sge.sge.servico.dto.EventoDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoServico {
    private final EventoMapper eventoMapper;
    private final EventoRepositorio eventoRepositorio;

    public List<EventoDTO> listar() {
        return eventoMapper.toDto(this.eventoRepositorio.findAll());
    }

    public EventoDTO obterPorId(Integer id){
        Evento evento = this.eventoRepositorio.findById(id)
                .orElseThrow(()-> new RegraNegocioException("ID não encontrado"));
        return eventoMapper.toDto(evento);
    }

    public EventoDTO salvar(EventoDTO eventoDTO){
        //verificar tratamento nullpointexception
        try{
            this.eventoRepositorio.save(eventoMapper.toEntity(eventoDTO));
        }catch (NullPointerException e){
            System.out.println("O evento não existe");
        }
        return eventoDTO;
    }

    public EventoDTO atualizar(EventoDTO eventoDTO){
        this.eventoRepositorio.save(eventoMapper.toEntity(eventoDTO));
        return eventoDTO;
    }

    public void deletar(EventoDTO eventoDTO){
        try{
            this.eventoRepositorio.delete(eventoMapper.toEntity(eventoDTO));
        }catch(NullPointerException e){
            System.out.println("O evento não existe");
        }



    }
}
