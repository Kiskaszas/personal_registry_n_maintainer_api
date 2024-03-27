package com.example.personal_registry_n_maintainer_api.exception;

public class PersonalRegistryException extends RuntimeException {

    public PersonalRegistryException() {
        super();
    }

    public PersonalRegistryException(String message) {
        super(message);
    }

    public PersonalRegistryException(String message, Throwable cause) {
        super(message, cause);
    }
}
