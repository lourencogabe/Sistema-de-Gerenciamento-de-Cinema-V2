package com.cinema.Model;


public class  Catalogue extends Movies {
    
    public Catalogue() {
        super();
    }

    public Catalogue(String nome) {
        super();
        setNome(nome);
    }

    public Catalogue(String nome, String[] seat) {
        super();
        setNome(nome);
        setSeat(seat);
    }


    public Catalogue(String nome, int hora, int minuto) {
        super();
        setNome(nome);
        setHora(hora);
        setMinuto(minuto);
    }


    public Catalogue(String nome, String[] genero, String classificacao, int hora, int minuto, String[] seat) {
        super();
        setNome(nome);
        setGenero(genero);
        setClassificacao(classificacao);
        setHora(hora);
        setMinuto(minuto);
        setSeat(seat);
    }


    public Catalogue(String nome, String[] genero, String classificacao, int hora, int minuto) {
        super();
        setNome(nome);
        setGenero(genero);
        setClassificacao(classificacao);
        setHora(hora);
        setMinuto(minuto);
        }
}
