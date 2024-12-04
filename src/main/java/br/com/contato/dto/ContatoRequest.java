package br.com.contato.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ContatoRequest {
    @NotNull
    private String nome;
    @NotNull
    private String numero;

    public ContatoRequest() {
    }

    public ContatoRequest(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
