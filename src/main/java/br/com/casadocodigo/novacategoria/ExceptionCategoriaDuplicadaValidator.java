package br.com.casadocodigo.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ExceptionCategoriaDuplicadaValidator implements Validator {

    @Autowired
    private NovaCategoriaRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovaCategoriaDto novaCategoria = (NovaCategoriaDto) target;
        Optional<NovaCategoriaEntity> optionalCategoria = repository.findByNome(novaCategoria.getNome());

        if (optionalCategoria.isPresent()) {
            errors.rejectValue("nome", null, "Essa categoria já foi cadastrada " + novaCategoria.getNome());
        }

    }
}
