package com.andre.desafio.rentacar.exceptions;

import com.andre.desafio.rentacar.controllers.VagaController;
import com.andre.desafio.rentacar.models.errors.ErrorResponse;
import com.andre.desafio.rentacar.models.errors.ObjectError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice(basePackageClasses = VagaController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ObjectError> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);

        logger.error(errorResponse.getMessage());

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleControllerExcpetion(CustomException e) {

        int httpStatus = e.getRentacarValidacoes().getHttpStatus();
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), httpStatus, HttpStatus.valueOf(httpStatus).name(), null, null);

        logger.error(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(httpStatus));
    }

    private List<ObjectError> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ObjectError(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus httpStatus, List<ObjectError> errors) {

        return new ErrorResponse("Parametros inválidos",
                httpStatus.value(), httpStatus.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }
}
