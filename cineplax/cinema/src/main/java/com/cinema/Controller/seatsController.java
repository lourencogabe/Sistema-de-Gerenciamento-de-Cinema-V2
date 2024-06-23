package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.CinePlax.Main;
import com.cinema.Model.BuyTickets;

public class seatsController {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static List<BuyTickets> seatsList = new ArrayList<>();


    public static void seatsList(List<Integer> seatNumber ){
        logger.info("calling seats controller");
        BuyTickets ticketsSeat = new BuyTickets(seatNumber);
        fillArrayOfseats(ticketsSeat);


    }


    public static void clearSeats() {
        logger.info("Clearing catalog array");
        seatsList.clear();
    }

    private static void fillArrayOfseats(BuyTickets seats){
        logger.info("Felling seats Array");
        seatsList.add(seats);
    }

    public static List<BuyTickets> getMovieSeats(){
        logger.info("retriving movie data");
        return seatsList;
    }
}

