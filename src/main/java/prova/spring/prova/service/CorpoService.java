package prova.spring.prova.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import prova.spring.prova.entity.Corpo;
import prova.spring.prova.repository.CorpoRepository;

@Service
public class CorpoService {

    @Autowired
    private CorpoRepository corpoRepo;

    public Corpo cadastraCorpo(Corpo corpo) {
        if (corpo == null || corpo.getNome() == null || corpo.getNome().isBlank() ||
            corpo.getDescricao() == null || corpo.getDescricao().isBlank() ||
            corpo.getDistancia() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return corpoRepo.save(corpo);
    }

    public List<Corpo> listaRegistros(){
        return corpoRepo.findAll();
    }

    
    public List<Corpo> buscaCorposPorNomeEDistancia(String nome, Float distancia) {
        if (nome == null || nome.isBlank() || distancia == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parâmetros de busca inválidos!");
        }
        return corpoRepo.findCorposByNomeContainingAndDistanciaGreaterThan(nome, distancia);
    }
}
