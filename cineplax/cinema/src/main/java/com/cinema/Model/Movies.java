package com.cinema.Model;

import java.util.Arrays;

public abstract class Movies  {
    
    private String nome;
    private String[] genero;
    private String classificacao;
    private int hora;
    private int minuto;
    private String[] seat;

    public Movies() {}


    public Movies(String nome, String[] genero, String classificacao, int hora, int minuto, String[] seat) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.hora = hora;
        this.minuto = minuto;
        this.seat = seat;
    }

    //Getters
    public String getNome() {
        return nome;
    }


    public String[] getGenero() {
        return genero;
    }


    public String getClassificacao() {
        return classificacao;
    }


    public int getHora() {
        return hora;
    }


    public int getMinuto() {
        return minuto;
    }


    public String[] getSeat() {
        return seat;
    }

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setGenero(String[] genero) {
        this.genero = genero;
    }


    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }


    public void setHora(int hora) {
        this.hora = hora;
    }


    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }


    public void setSeat(String[] seat) {
        this.seat = seat;
    }


    @Override
    public String toString() {
        return "Movies{" +
                "nome='" + nome + '\'' +
                ", genero=" + Arrays.toString(genero) +
                ", classificacao='" + classificacao + '\'' +
                ", hora=" + hora +
                ", minuto=" + minuto +
                ", seat=" + Arrays.toString(seat) +
                '}';
    }

}
