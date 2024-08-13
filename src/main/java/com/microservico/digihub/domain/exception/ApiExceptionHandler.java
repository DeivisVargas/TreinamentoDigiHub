package com.microservico.digihub.domain.exception;

import com.microservico.digihub.domain.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    //para dizer que é para capturar as exceções lançadas pela classe passada por parametro
    //sempre que ela for lançada vai cair nesse metodo passando a classe que quero tratar
    //que são referentes a validações de input de entidade
    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<ErrorMessage> MethodArgumentNotValidException(MethodArgumentNotValidException ex ,
                                                                        HttpServletRequest request,
                                                                        BindingResult result){
        //@Slf4j
        log.error("Api Error - ", ex);// lara fazer o erro de console
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request , HttpStatus.UNPROCESSABLE_ENTITY , "Campos(s) inválido(s)" , result));
    }


}