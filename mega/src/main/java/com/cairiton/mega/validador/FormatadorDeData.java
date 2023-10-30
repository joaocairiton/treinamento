package com.cairiton.mega.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FormatadorDeData implements ConstraintValidator<ValidaData, String> {
    
    @Override
    public boolean isValid(final String conteudo, final ConstraintValidatorContext context) {
        final String regex = "\\d{2}/\\d{2}/\\d{4}";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(conteudo);
        return matcher.matches();
    }
    
}
