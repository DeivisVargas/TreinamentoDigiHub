package com.microservico.digihub.domain.exception;

import com.microservico.digihub.domain.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {

    //para dizer que é para capturar as exceções lançadas pela classe passada por parametro
    //sempre que ela for lançada vai cair nesse metodo passando a classe que quero tratar
    //que são referentes a validações de input de entidade

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<ErrorMessage> entityNotFoundException(RuntimeException ex ,
                                                                HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request , HttpStatus.NOT_FOUND , ex.getMessage() ));
    }


}
