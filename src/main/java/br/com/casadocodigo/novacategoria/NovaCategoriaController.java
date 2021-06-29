package br.com.casadocodigo.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class NovaCategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ExceptionCategoriaDuplicadaValidator exceptionCategoriaDuplicadaValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(exceptionCategoriaDuplicadaValidator);
    }

    @PostMapping(value = "/cadastro")
    @Transactional
    public String cadastrarCategoria(@RequestBody @Valid NovaCategoriaDto categoria) {
        NovaCategoriaEntity c = new NovaCategoriaEntity(categoria.getNome());
        manager.persist(c);
        return c.toString();
    }
}
