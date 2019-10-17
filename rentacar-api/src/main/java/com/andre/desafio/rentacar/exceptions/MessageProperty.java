package com.andre.desafio.rentacar.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

@Component
public class MessageProperty {
    private static MessageSource messageSource;

    @Autowired
    public MessageProperty(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static String getMessage(String cod) {

        return messageSource.getMessage(cod, new Object[0], new Locale("pt", "br"));
    }

}
