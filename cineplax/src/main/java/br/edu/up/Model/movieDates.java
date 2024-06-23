package com.cinema.Model;

public class movieDates extends BuyTickets {
   private String[] dates;


    public movieDates(String nome, String[] movieDuration, String[] dates) {
    super(nome, movieDuration);
    this.dates = dates;
}



    public String[] getDates() {
        return dates;
    }
}
