package com.horustek.gda.infra.validation;

import com.horustek.gda.repositories.seguridad.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
@Slf4j
@Service
public class ExistsUserByIdValidator implements
        ConstraintValidator<ExistsUserById, String> {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void initialize(ExistsUserById constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return usuarioRepository.existsById(value);
    }
}