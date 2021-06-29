package br.com.casadocodigo.novacategoria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class NovaCategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/cadastro")
    @Transactional
    public String cadastrarCategoria(@RequestBody @Valid NovaCategoriaDto categoria) {
        NovaCategoriaEntity c = new NovaCategoriaEntity(categoria.getNome());
        manager.persist(c);
        return c.toString();
    }
}
