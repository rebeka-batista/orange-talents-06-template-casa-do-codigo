package br.com.casadocodigo.compra;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/cadastro")
    @Transactional
    public String fazerCompra(@RequestBody @Valid CompraDto compra) {
        CompraEntity c = compra.toModel();
        manager.persist(c);
        return c.toString();
    }


}
