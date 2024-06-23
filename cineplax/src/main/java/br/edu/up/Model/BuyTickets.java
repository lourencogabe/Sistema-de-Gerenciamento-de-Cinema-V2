package com.cinema.Model;

import java.util.List;

public class BuyTickets extends Catalogue {
    private String data;
    private String[] movieDuration;
    private String timeReservation;
    private List<Integer> seats;
    
    public BuyTickets(String nome) {
        super(nome);
    }

    
    public BuyTickets(List<Integer> seats) {
        this.seats = seats;
    }

    public BuyTickets(String nome, String[] movieDuration) {
        super(nome);
        this.movieDuration = movieDuration;
    }




    public BuyTickets(String nome, String[] genero, String classificacao, int hora, int minuto, String data) {
        super(nome, genero, classificacao, hora, minuto);
        this.data = data;
    }
    
    


    public BuyTickets(String nome, String[] genero, String classificacao, int hora, int minuto, String data,
    String timeReservation, String[] seats) {
        super(nome, genero, classificacao, hora, minuto, seats);
        this.data = data;
        this.timeReservation = timeReservation;
    }


    //getters
    public String getData() {
        return data;
    }

    public String[] getMovieDuration() {
        return movieDuration;
    }

    public String getTimeReservation() {
        return timeReservation;
    }


    public List<Integer> getSeats() {
        return seats;
    }



      //setters

    public void setData(String data) {
        this.data = data;
    }


  
}
