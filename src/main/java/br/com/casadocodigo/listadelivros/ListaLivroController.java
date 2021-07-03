package br.com.casadocodigo.listadelivros;

import br.com.casadocodigo.novolivro.LivroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista-livro")
public class ListaLivroController {

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<LivroEntity> listaDeLivros() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesLivroDto> listarLivros(@PathVariable Long id) {
        Optional<LivroEntity> optionalLivro = repository.findById(id);
        if (optionalLivro.isPresent()) {
            return ResponseEntity.ok(new DetalhesLivroDto(optionalLivro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
