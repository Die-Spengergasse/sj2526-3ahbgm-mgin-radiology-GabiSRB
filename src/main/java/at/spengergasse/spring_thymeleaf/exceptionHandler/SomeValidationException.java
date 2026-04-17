package at.spengergasse.spring_thymeleaf.exceptionHandler;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SomeValidationException extends RuntimeException {

    private final Map<String, String> errors;
    public SomeValidationException(Map<String, String> errors) {
        this.errors = errors;
    }
}