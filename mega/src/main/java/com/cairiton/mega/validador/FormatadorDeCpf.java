package com.cairiton.mega.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FormatadorDeCpf implements ConstraintValidator<ValidaCpf, String> {
    
    @Override
    public boolean isValid(String conteudo, ConstraintValidatorContext context) {
        String regex = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(conteudo);
        return matcher.matches();
    }
    
}
