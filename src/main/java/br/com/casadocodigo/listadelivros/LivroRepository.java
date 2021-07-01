package br.com.casadocodigo.listadelivros;

import br.com.casadocodigo.novolivro.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}
