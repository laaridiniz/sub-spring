package prova.spring.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import prova.spring.prova.entity.Corpo;
import java.util.List;

public interface CorpoRepository extends JpaRepository<Corpo, Long> {
    @Query("SELECT c FROM Corpo c WHERE c.nome LIKE %:nome% AND c.distancia > :distancia")
    List<Corpo> findCorposByNomeContainingAndDistanciaGreaterThan(String nome, Float distancia);
}
