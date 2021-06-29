package br.com.casadocodigo.novoautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ExceptionEmailDuplicadoValidator exceptionEmailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(exceptionEmailDuplicadoValidator);
    }

    @PostMapping("/cadastro")
    @Transactional
    public String cadastrarAutor(@RequestBody @Valid NovoAutorDto autor) {
        AutorEntity a = autor.toModel();
        manager.persist(a);
        return a.toString();

    }

}
