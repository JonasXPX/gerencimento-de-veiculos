package com.github.jonasxpx.provas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName) {
        super(format("Entidade não encontrada %s", entityName));
    }

    public EntityNotFoundException() {
        super("Entidade não encontrada.");
    }

}
