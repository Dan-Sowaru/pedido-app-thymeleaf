package br.com.letscode.pedidoapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class EmailService {
    public EmailService(String smtp, String imap) {
    }

    //    Outra forma de injetar valor, com o @Value, e dizemos pra buscar la em application.properties veja abaixo:
//
//    private String smtp;
//
//    public EmailService(@Value("${email.service.smtp}") String smtp, String imap) {
//        this.smtp = smtp;
//        this
//
//    }

    public void enviar(String destino) {
        System.out.println("############");
        System.out.println("Enviando e-mail...");
        System.out.println("Destino: " + destino);
        System.out.println("E-mail enviado!");
        System.out.println("############");
    }
}
