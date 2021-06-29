package br.com.casadocodigo.novacategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NovaCategoriaRepository extends JpaRepository<NovaCategoriaEntity, Long> {
    Optional<NovaCategoriaEntity> findByNome(String nome);
}
