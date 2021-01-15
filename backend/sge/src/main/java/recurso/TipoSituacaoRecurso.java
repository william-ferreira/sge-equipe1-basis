package recurso;

import com.basis.sge.sge.dominio.TipoSituacao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servico.PreInscricaoServico;
import servico.TipoSituacaoServico;
import servico.dto.PreInscricaoDTO;
import servico.dto.TipoSituacaoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/tipo_situacao")
@RequiredArgsConstructor
public class TipoSituacaoRecurso {
    private final TipoSituacaoServico tipoSituacaoServico;
    @GetMapping
    public ResponseEntity<List<TipoSituacaoDTO>> Listar (){
        return null;
    }
    @GetMapping("{/id}")
    public ResponseEntity<TipoSituacaoDTO> obterPoId(@PathVariable int id){
        return null;
    }
    @PostMapping
    public ResponseEntity<TipoSituacaoDTO> salvar(@RequestBody TipoSituacaoDTO tipoSituacaoDTO){
        return null;
    }
    @PutMapping
    public ResponseEntity<TipoSituacaoDTO> editar(@RequestBody TipoSituacaoDTO tipoSituacaoDTO){
        return null;
    }
    @DeleteMapping("{/id}")
    public void remover(){

    }


}
