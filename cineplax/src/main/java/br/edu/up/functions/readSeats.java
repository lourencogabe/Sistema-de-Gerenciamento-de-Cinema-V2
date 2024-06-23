package com.cinema.functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.seatsController;


public class readSeats {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static File seatsTable = new File("D:\\cinema\\cinema\\database\\seats");

    public static void readSeatsTable() {
        logger.info("clearing Seats Array");
        seatsController.clearSeats();
        logger.info("reading seatles table");
        File seatsFile = new File(seatsTable, "seats.txt");

        if (seatsFile.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(seatsFile))) {
                String line;
                List<Integer> seatNumbers = new ArrayList<>();

                while ((line = reader.readLine()) != null) {
                    int index = 0;
                    while ((index = line.indexOf("Assento:", index)) != -1) {
                        int start = index + "Assento:".length();
                        int end = line.indexOf(",", start);
                        if (end == -1) {
                            end = line.indexOf(";", start);
                        }
                        if (end == -1) {
                            end = line.length();
                        }
                        String seatNumberStr = line.substring(start, end).trim();
                        try {
                            int seatNumber = Integer.parseInt(seatNumberStr);
                            seatNumbers.add(seatNumber);
                        } catch (NumberFormatException e) {
                            logger.error("Invalid seat number format: " + seatNumberStr);
                        }
                        index = end; 
                    }
                }

                seatsController.seatsList(seatNumbers);

            } catch (IOException e) {
               logger.info("Error reading seats file: " + e.getMessage());
            }
        } else {
           logger.info("Seats file not found or is not a file.");
        }
    }
}