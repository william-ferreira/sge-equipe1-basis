package servico;

import com.basis.sge.sge.dominio.PreInscricao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repositorio.PreInscricaoRepositorio;
import servico.dto.PreInscricaoDTO;
import servico.exception.RegraNegocioException;
import servico.mapper.PreInscricaoMapper;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PreInscricaoServico {
    private final PreInscricaoRepositorio preInscricaoRepositorio;
    private final PreInscricaoMapper preInscricaoMapper;

    public List<PreInscricaoDTO> listar() {
        return preInscricaoMapper.toDto(this.preInscricaoRepositorio.findAll());
    }

    public PreInscricaoDTO obterPorId(Integer id) {
        PreInscricao preInscricao = this.preInscricaoRepositorio.findById(id).orElseThrow(()->new RegraNegocioException("ID não encontrado"));
        return preInscricaoMapper.toDto(preInscricao);
    }

    public PreInscricaoDTO salvar(PreInscricaoDTO preInscricaoDTO){

        this.preInscricaoRepositorio.save(preInscricaoMapper.toEntity(preInscricaoDTO));
        return preInscricaoDTO;
    }

    public void remover(PreInscricaoDTO preInscricaoDTO)
    {
        this.preInscricaoRepositorio.delete(preInscricaoMapper.toEntity(preInscricaoDTO));
    }








}
