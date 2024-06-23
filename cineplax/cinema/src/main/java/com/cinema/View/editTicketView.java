package com.cinema.View;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.catalogueDatesController;
import com.cinema.Controller.editTicket;
import com.cinema.Controller.readUserTickets;
import com.cinema.Controller.seatsController;
import com.cinema.Model.BuyTickets;
import com.cinema.Model.Catalogue;
import com.cinema.Model.movieDates;
import com.cinema.Model.movieTicket;
import com.cinema.functions.readMovieDates;
import com.cinema.functions.readSeats;

public class editTicketView {
    final static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        logger.info("Editing ticket view");
        List<movieTicket> userMovieTikckest = readUserTickets.getUserTickets();

        System.out.println("Ingressos disponiveis para edicao");

        for (movieTicket movieTicket : userMovieTikckest) {
            System.out.println("------------------------------");
            System.out.println("Nome: " + movieTicket.getNome());
            System.out.println("------------------------------");
        }

        System.out.println("Selecione o ingresso que deseja editar");
        int index = scanner.nextInt();

        Catalogue selectedMovie = userMovieTikckest.get(index);

        System.out.println("1: Editar data");
        System.out.println("2: Editar Reserva");
        System.out.println("3: Editar Asscento");
        int choise = scanner.nextInt();

        switch (choise) {
            case 1:
                readMovieDates.readMovieDatesTable();
                List<movieDates> movieTDate = catalogueDatesController.getMovieDatesAndTime();
                movieDates selectedMovieDates = null;
                for (movieDates movieDate : movieTDate) {
                    if (movieDate.getNome().equals(selectedMovie.getNome())) {
                        selectedMovieDates = movieDate;
                        break;
                    }
                }

                String[] availableDates = selectedMovieDates.getDates();
                int dateIndex = 0;

                if (selectedMovieDates != null) {
                    for (int i = 0; i < availableDates.length; i++) {
                        System.out.println("Data [" + i + "]: " + availableDates[i]);
                    }

                    System.out.println("Selecione a data do filme");
                    dateIndex = scanner.nextInt();
                }

                if (dateIndex >= 0 && dateIndex < availableDates.length) {
                    String selectedDate = availableDates[dateIndex];

                    logger.info("Data selecioneda: " + selectedDate);
                    String selectdMovie = selectedMovie.getNome();

                    movieTicket editMovieDate = new movieTicket(selectdMovie, selectedDate);

                    editTicket.editTicketData(editMovieDate);
                }

                break;

            case 2:
                readMovieDates.readMovieDatesTable();
                List<movieDates> movieTime = catalogueDatesController.getMovieDatesAndTime();
                movieDates selectedReservationTime = null;
                for (movieDates time : movieTime) {
                    if (time.getNome().equals(selectedMovie.getNome())) {
                        selectedReservationTime = time;
                        break;
                    }
                }

                String[] avaibleReservation = selectedReservationTime.getMovieDuration();
                int timeIndex = -1;

                if (selectedReservationTime != null) {

                    for (int i = 0; i < avaibleReservation.length; i++) {
                        System.out.println("Horario disponivel [" + i + "]: " + avaibleReservation[i]);
                    }

                    System.out.println("Selecione o horario do filme");
                    timeIndex = scanner.nextInt();

                }
                if (timeIndex >= 0 && timeIndex < avaibleReservation.length) {
                    String selectedTime = avaibleReservation[timeIndex];

                    String[] timeParts = selectedTime.split(":");

                    if (timeParts.length == 2) {
                        int hora = Integer.parseInt(timeParts[0].trim());
                        int minuto = Integer.parseInt(timeParts[1].trim());

                        String selectMovie = selectedMovie.getNome();

                        movieTicket editMovieSession = new movieTicket(selectMovie, hora, minuto);
                        editTicket.editTicketSessionTime(editMovieSession);
                    } else {
                        logger.info("Invalid time format selected.");
                    }

                }

                break;

            case 3:
                readSeats.readSeatsTable();
                List<BuyTickets> ticketSeats = seatsController.getMovieSeats();
                System.out.println("Ascentos Disponiveis");

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
                    } catch (NumberFormatException e) {
                        System.out.println("Número de assento inválido: " + seatNumbers[i]);
                    }
                }

                String selectdMovie = selectedMovie.getNome();

                movieTicket editMovieSeats = new movieTicket(selectdMovie, seatNumbers);
                editTicket.editSeats(editMovieSeats);

                break;

            default:

                break;
        }

    }

}
