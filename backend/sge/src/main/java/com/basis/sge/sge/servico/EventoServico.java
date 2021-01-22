package com.basis.sge.sge.servico;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.PreInscricao;
import com.basis.sge.sge.repositorio.EventoRepositorio;
import com.basis.sge.sge.servico.dto.EventoDTO;
import com.basis.sge.sge.servico.dto.PreInscricaoDTO;
import com.basis.sge.sge.servico.dto.UsuarioDTO;
import com.basis.sge.sge.servico.exception.RegraNegocioException;
import com.basis.sge.sge.servico.mapper.EventoMapper;
import com.basis.sge.sge.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoServico {

    private final EventoRepositorio eventoRepositorio;
    private final EventoMapper eventoMapper;

    private final PreInscricaoServico preInscricaoServico;
    private final UsuarioServico usuarioServico;
    private final EmailUtil emailUtil;

    public List<EventoDTO> listar() {
        List<Evento> eventos = eventoRepositorio.findAll();
        return eventoMapper.toDto(eventos);
    }

    public EventoDTO obterPorId(Integer id) {
        Evento evento = buscar(id);
        return eventoMapper.toDto(evento);
    }

    public EventoDTO salvar(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        eventoRepositorio.save(evento);
        return eventoMapper.toDto(evento);
    }

    public EventoDTO editar(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        eventoRepositorio.save(evento);

        enviarEmailAlteracaoEvento(evento);

        return eventoMapper.toDto(evento);
    }

    public void remover(Integer id) {
        Evento evento = buscar(id);
        eventoRepositorio.delete(evento);
    }

    private Evento buscar(Integer id) {
        return eventoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Evento não encontrado."));
    }

    private void enviarEmailAlteracaoEvento(Evento evento) {
        List<PreInscricaoDTO> preInscritos = preInscricaoServico.listar();

        for (PreInscricaoDTO preInscricao : preInscritos) {
            if (evento.getId().equals(preInscricao.getIdEvento())) {
                UsuarioDTO usuario = usuarioServico.obterPorId(preInscricao.getIdUsuario());

                String corpoEmail = "O evento com o titulo:".concat(evento.getTitulo()).concat(" foi alterado.");

                emailUtil.enviarEmail(usuario.getEmail(), corpoEmail, "Alteração no evento");
            }
        }
    }
}
