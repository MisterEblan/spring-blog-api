package com.mreblan.springblog.exceptions;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) { super(msg); }

    public ResourceNotFoundException(String msg, Throwable cause) { super(msg, cause); }
}
