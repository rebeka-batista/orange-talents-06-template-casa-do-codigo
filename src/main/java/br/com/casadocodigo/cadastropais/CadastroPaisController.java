package br.com.casadocodigo.cadastropais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cadastro")
public class CadastroPaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/pais")
    @Transactional
    public String cadastrarPais(@RequestBody @Valid CadastroPaisDto pais) {
        PaisEntity p = new PaisEntity(pais.getNome());
        manager.persist(p);
        return p.toString();
    }

}
