package com.horustek.gda.infra.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsUserByUsernameValidator.class)
@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ExistsUserByUsername {

    String message() default "Este usuario no existe en el sistema";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
