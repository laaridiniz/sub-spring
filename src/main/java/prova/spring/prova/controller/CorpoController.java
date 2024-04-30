package prova.spring.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.spring.prova.entity.Corpo;
import prova.spring.prova.service.CorpoService;

import java.util.List;

@RestController
@RequestMapping(value = "/corpo")
@CrossOrigin
public class CorpoController {

    @Autowired
    private CorpoService service;

    @PostMapping
    public Corpo cadastraCorpo(@RequestBody Corpo corpo) {
        return service.cadastraCorpo(corpo);
    }

    @GetMapping
    public List<Corpo> listaRegistro() {
        return service.listaRegistros();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Corpo>> buscaCorposPorNomeEDistancia(
        @RequestParam String nome,
        @RequestParam Float distancia) {
        List<Corpo> corpos = service.buscaCorposPorNomeEDistancia(nome, distancia);
        if (corpos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(corpos);
    }
}
