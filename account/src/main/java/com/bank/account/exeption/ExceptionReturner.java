package com.bank.account.exeption;

import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class ExceptionReturner {

    public EntityNotFoundException getEntityNotFoundException(String message) {
        return new EntityNotFoundException(message);
    }
}