package br.com.casadocodigo.novolivro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping("/cadastro")
    @Transactional
    public String cadastrarLivro(@RequestBody @Valid LivroDto livro) {
        LivroEntity l = livro.toModel();
        manager.persist(l);
        return l.toString();
    }


}
