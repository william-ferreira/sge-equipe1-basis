package recurso;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servico.dto.PreInscricaoDTO;
import servico.PreInscricaoServico;

import java.util.List;

@RestController
@RequestMapping("/api/pre_inscricao")
@RequiredArgsConstructor
public class PreInscricaoRecurso {
    private final PreInscricaoServico preInscricaoServico;
    @GetMapping
    public ResponseEntity<List<PreInscricaoDTO>> Listar (){
        return null;
    }
    @GetMapping("{/id}")
    public ResponseEntity<PreInscricaoDTO> obterPoId(@PathVariable int id){
        return null;
    }
    @PostMapping
    public ResponseEntity<PreInscricaoDTO> salvar(@RequestBody PreInscricaoDTO preInscricaoDTO){
        return null;
    }
    @PutMapping
    public ResponseEntity<PreInscricaoDTO> editar(@RequestBody PreInscricaoDTO preInscricaoDTO){
        return null;
    }
    @DeleteMapping("{/id}")
    public void remover(){

    }


}
