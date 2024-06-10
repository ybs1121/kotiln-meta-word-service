package com.example.demo.core

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomRestControllerAdvice {


    @ExceptionHandler(Exception::class)
    fun commonExceptionHandler(e: Exception): String? {
        return e.message
    }
}