package com.example.rm30966.olimpiadas;

/**
 * Created by RM30966 on 17/10/2016.
 */
public class Modalidade
{
    private String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Modalidade(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return Nome;
    }
}
