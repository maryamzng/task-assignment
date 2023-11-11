package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class IllegalTransactionException extends RuntimeException{

    private final String fieldName;
    private final BigDecimal fieldValue;

    public IllegalTransactionException(String fieldName, BigDecimal fieldValue) {
        super(String.format("%s is not enough : '%s'",  fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public BigDecimal getFieldValue() {
        return fieldValue;
    }
}
