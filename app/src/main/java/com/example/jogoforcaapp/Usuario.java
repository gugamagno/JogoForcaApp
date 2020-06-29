package com.example.jogoforcaapp;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer pontos;

    @Override
    public String toString(){
        return id + " " + nome + " " + email + " " + senha + " " + pontos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
}
