package at.spengergasse.spring_thymeleaf.customAnnotations;

import at.spengergasse.spring_thymeleaf.customValidators.SvnrValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SvnrValidator.class)
public @interface ValidSVNR {
    String message() default "Incorrect Social Number";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
