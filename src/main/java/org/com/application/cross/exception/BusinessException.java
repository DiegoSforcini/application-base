package org.com.application.cross.exception;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;

@Getter
@RegisterForReflection
public class BusinessException extends RuntimeException {

    String message;

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

}
