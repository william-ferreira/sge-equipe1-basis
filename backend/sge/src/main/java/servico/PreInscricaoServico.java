package servico;

import com.basis.sge.sge.dominio.PreInscricao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repositorio.PreInscricaoRepositorio;
import servico.dto.PreInscricaoDTO;
import servico.dto.UsuarioDTO;
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
        List<PreInscricao> lista = preInscricaoRepositorio.findAll();
        return preInscricaoMapper.toDto(lista);
    }

    public PreInscricaoDTO obterPorId(Integer id) {
        PreInscricao preInscricao = preInscricaoRepositorio.findById(id).get();
        return preInscricaoMapper.toDto(preInscricao);
    }

    public PreInscricaoDTO salvar(PreInscricaoDTO preInscricaoDTO){
        return null;
    }
    public PreInscricaoDTO editar(PreInscricaoDTO preInscricaoDTO) {
        return null;
    }
    public PreInscricaoDTO remover(Integer id) {
        return null;
    }








}
