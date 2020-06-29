package com.example.jogoforcaapp;

import java.io.Serializable;

public class Palavra implements Serializable {

    private Integer id;
    private String palavra;
    private String dica;

    @Override
    public String toString() {
        return "PALAVRA: " + palavra + "     " + "DICA: " + dica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
}
