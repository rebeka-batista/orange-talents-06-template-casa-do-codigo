package br.com.casadocodigo.cadastroestado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class CadastroEstadoController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoRepository repository;

    @PostMapping("/cadastro")
    @Transactional
    public String cadastrarLivro(@RequestBody @Valid CadastroEstadoDto estado) {
        EstadoEntity e = estado.toModel(manager);
        manager.persist(e);
        return e.toString();
    }

}
