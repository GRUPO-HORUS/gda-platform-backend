package com.horustek.gda.infra.validation;

import com.horustek.gda.repositories.seguridad.RolRepository;
import com.horustek.gda.repositories.seguridad.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
@Slf4j
@Service
public class ExistsRolByNameValidator implements
        ConstraintValidator<ExistsRolByName, String> {

    private final RolRepository rolRepository;

    @Override
    public void initialize(ExistsRolByName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return rolRepository.existsByNombreIgnoreCase(value);
    }
}