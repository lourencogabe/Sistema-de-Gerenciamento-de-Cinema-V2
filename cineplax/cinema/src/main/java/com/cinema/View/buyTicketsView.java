package com.cinema.View;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.CinePlax.Main;
import com.cinema.Controller.buyTicketController;
import com.cinema.Controller.catalogueController;
import com.cinema.Controller.catalogueDatesController;
import com.cinema.Controller.seatsController;
import com.cinema.Model.BuyTickets;
import com.cinema.Model.Catalogue;
import com.cinema.Model.movieDates;
import com.cinema.functions.readMovieDates;
import com.cinema.functions.readMovieTable;
import com.cinema.functions.readSeats;




public class buyTicketsView {
      final static Scanner scanner = new Scanner(System.in);
      private static final Logger logger = LogManager.getLogger(Main.class);
public static void main(String[] args) throws Exception  {
     logger.info("runnign buy ticket menu");

    readMovieTable.readMovieCalatologue();
    List<Catalogue> catalogList = catalogueController.getCartaz();

    readMovieDates.readMovieDatesTable();
    List<movieDates> movieTimeAndDate = catalogueDatesController.getMovieDatesAndTime();

    readSeats.readSeatsTable();
    List<BuyTickets> ticketSeats = seatsController.getMovieSeats();


   

    int counter = 0;
    for (Catalogue catalog : catalogList) {
        System.out.println("Opcao" + " " + counter + " " + "Nome " + catalog.getNome());
        String[] generos = catalog.getGenero();
        for (int i = 0; i < generos.length; i++) {
            System.out.print(generos[i]);
            if (i < generos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Classificacao: " + catalog.getClassificacao());
        System.out.println("Duracao: " + catalog.getHora() + "h " + catalog.getMinuto() + "min");
        System.out.println("----------------------");
        counter++;
    }


     System.out.println("Selecione o filme que deseja assitir");
     int index = scanner.nextInt();

    //metodo para escrever o nome do filme no nome do arquivo
     if (index >= 0 && index < catalogList.size()) {
        Catalogue selectedMovie = catalogList.get(index);

        System.out.println("Selectd movie" + selectedMovie.getNome());


     // Display available dates for the selected movie
           movieDates selectedMovieDates = null;

            for (movieDates datesOfCatalogue : movieTimeAndDate) {
              //System.out.println("movie return: " + datesOfCatalogue.getNome());
                if (datesOfCatalogue.getNome().equals(selectedMovie.getNome())) {
                    selectedMovieDates = datesOfCatalogue;
                    break;
               }
            }
                 String[] availableDates = selectedMovieDates.getDates();
                 int dateIndex = 0;
                    if(selectedMovieDates != null){
                        for (int i = 0; i < availableDates.length; i++) {
                            System.out.println("Data [" + i + "]: " + availableDates[i]);
                        }
        
                        System.out.println("Selecione a data do filme");
                        dateIndex = scanner.nextInt();
                    }
       
          


           movieDates selectedReservationTime = null;

           for (movieDates reservationOfCatalogue :  movieTimeAndDate) {
                if(reservationOfCatalogue.getNome().equals(selectedMovie.getNome())){
                    selectedReservationTime =  reservationOfCatalogue;
                    break;
                }
           }

                String[] avaibleReservation = selectedReservationTime.getMovieDuration();
                int timeIndex = 0;


           if(selectedReservationTime != null){
                for (int i = 0; i < avaibleReservation.length; i++) {
                    System.out.println("Horario disponivel [" + i + "]: " + avaibleReservation[i]);
                }

                System.out.println("Selecione o horario do filme");
                timeIndex = scanner.nextInt();
           }




           System.out.println("Quantidade Ingressos");
           int quantidade = scanner.nextInt();


                    for (BuyTickets buyTickets : ticketSeats) {
                        System.out.println("Assentos: " + buyTickets.getSeats());
                    }

                 
                  
                    System.out.println("Selecione os assentos (exemplo: 1 2 3):");

                    scanner.nextLine();
                    
                    String acento = scanner.nextLine();
                    String[] seatNumbers = acento.split("\\s+");
                    
                    int[] selectedSeats = new int[seatNumbers.length];
                    
                    for (int i = 0; i < seatNumbers.length; i++) {
                        try {
                            selectedSeats[i] = Integer.parseInt(seatNumbers[i]);
                           // System.out.println("acentos" + selectedSeats[i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Número de assento inválido: " + seatNumbers[i]);
                        }
                    }
           //=================================================================================//


            if(dateIndex >= 0 && dateIndex < availableDates.length && timeIndex >= 0 && timeIndex < avaibleReservation.length){
            String selectedDate = availableDates[dateIndex];
            String selectedReservation  = avaibleReservation[timeIndex];
            BuyTickets pickedTicket = new BuyTickets(
                selectedMovie.getNome(),
                selectedMovie.getGenero(),
                selectedMovie.getClassificacao(),
                selectedMovie.getHora(),
                selectedMovie.getMinuto(),
                selectedDate,selectedReservation,seatNumbers
            );


            buyTicketController.buyMovieTickets(pickedTicket, quantidade);

           }

 
        
     }else {
        logger.info("no movies avaible");
     }
     
    }


 
}

