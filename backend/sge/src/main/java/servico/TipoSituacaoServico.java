package servico;


import com.basis.sge.sge.dominio.TipoSituacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import repositorio.TipoSituacaoRepositorio;


import servico.dto.TipoSituacaoDTO;
import servico.mapper.TipoSituacaoMapper;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoSituacaoServico {
    private final TipoSituacaoRepositorio tipoSituacaoRepositorio;
    private final TipoSituacaoMapper tipoSituacaoMapper;

    public List<TipoSituacaoDTO> listar() {
        List<TipoSituacao> lista = tipoSituacaoRepositorio.findAll();
        return tipoSituacaoMapper.toDto(lista);
    }

    public TipoSituacaoDTO obterPorId(Integer id) {
        TipoSituacao preInscricao = tipoSituacaoRepositorio.findById(id).get();
        return tipoSituacaoMapper.toDto(preInscricao);
    }

    public TipoSituacaoDTO salvar(TipoSituacaoDTO tipoSituacaoDTO){
        return null;
    }
    public TipoSituacaoDTO editar(TipoSituacaoDTO tipoSituacaoDTO) {
        return null;
    }
    public TipoSituacaoDTO remover(Integer id) {
        return null;
    }








}
