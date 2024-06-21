package br.edu.up.sgi.models;

public class Ingresso {
    private int ticketNum;
    private String ticketDate;

    public Ingresso() {
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "ticketNum=" + ticketNum +
                ", ticketDate='" + ticketDate + '\'' +
                '}';
    }
}
