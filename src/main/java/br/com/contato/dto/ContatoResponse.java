package br.com.contato.dto;

import org.springframework.stereotype.Component;

@Component
public class ContatoResponse {
    private Long id;
    private String nome;
    private String numero;

    public ContatoResponse() {
    }

    public ContatoResponse(Long id, String nome, String numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
