//package com.basis.sge.sge.servico;
//
//import com.basis.sge.sge.dominio.Pergunta;
//import com.basis.sge.sge.repositorio.PerguntaRepositorio;
//import com.basis.sge.sge.servico.dto.PerguntaDTO;
//import com.basis.sge.sge.servico.mapper.PerguntaMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class PerguntaServico {
//
//    private final PerguntaRepositorio perguntaRepositorio;
//    private final PerguntaMapper perguntaMapper;
//
//    public List<PerguntaDTO> listar() {
//        List<Pergunta> perguntas = perguntaRepositorio.findAll();
//        return perguntaMapper.toDto(perguntas);
//    }
//
//    public PerguntaDTO obterPorId(int id) {
//        Pergunta pergunta = perguntaRepositorio.findById(id).get();
//        return perguntaMapper.toDto(pergunta);
//    }
//
//    public PerguntaDTO salvar(PerguntaDTO perguntaDTO) {
//        Pergunta pergunta = perguntaMapper.toEntity(perguntaDTO);
//        Pergunta perguntaAux = perguntaRepositorio.save(pergunta);
//        return perguntaMapper.toDto(perguntaAux);
//    }
//
//
//
//}
