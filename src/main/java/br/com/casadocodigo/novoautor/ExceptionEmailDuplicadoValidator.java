package br.com.casadocodigo.novoautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ExceptionEmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovoAutorDto novoAutorDto = (NovoAutorDto) target;
        Optional<AutorEntity> optionalAutor = autorRepository.findByEmail(novoAutorDto.getEmail());
        if (optionalAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Esse email é cadastrado no sistema "
                            + novoAutorDto.getEmail());
        }

    }
}
