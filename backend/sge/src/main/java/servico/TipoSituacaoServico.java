package servico;


import com.basis.sge.sge.dominio.TipoSituacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repositorio.TipoSituacaoRepositorio;
import servico.dto.TipoSituacaoDTO;
import servico.exception.RegraNegocioException;
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
        return tipoSituacaoMapper.toDto(this.tipoSituacaoRepositorio.findAll());
    }

    public TipoSituacaoDTO obterPorId(Integer id) {
        TipoSituacao tipoSituacao = this.tipoSituacaoRepositorio.findById(id).orElseThrow(()->new RegraNegocioException("ID não encontrado"));
        return tipoSituacaoMapper.toDto(tipoSituacao);
    }

}
