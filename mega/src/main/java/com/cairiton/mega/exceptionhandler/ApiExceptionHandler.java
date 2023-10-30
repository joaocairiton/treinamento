package com.cairiton.mega.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cairiton.mega.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @Autowired
    private MessageSource messageSource;
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
            final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        
        final List<Problema.Campo> campos = new ArrayList<>();
        
        for (final ObjectError error : ex.getBindingResult().getAllErrors()) {
            final String nome = ((FieldError) error).getField();
            final String mensagem = this.messageSource.getMessage(error, LocaleContextHolder.getLocale());
            
            campos.add(new Problema.Campo(nome, mensagem));
            
        }
        
        final Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        problema.setCampos(campos);
        
        return this.handleExceptionInternal(ex, problema, headers, status, request);
    }
    
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(final NegocioException ex, final WebRequest request) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        
        final Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo(ex.getMessage());
        
        return this.handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }
    
}
