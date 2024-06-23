package com.cinema.functions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.CinePlax.Main;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;

public class editedTickedInfo {
    
    private static File ticketsTable = new File("D:\\cinema\\cinema\\database\\tickets");

  private static final Logger logger = LogManager.getLogger(Main.class);

    public static void editedTicketDate(userSession session, movieTicket movieDate){      
    logger.info("editing ticket date");
    File TicketFile = new File(ticketsTable, session.getUserId() + 
    "-" + session.getNome() + "-"  + movieDate.getNome() + "-" + ".txt");

    
        if(TicketFile.isFile()){
            String pathOfFile = TicketFile.toString();
            editDateOnFile(movieDate.getData(), pathOfFile);
        }else {
            logger.info("File not founded");
        }

    }

    public static void editDateOnFile(String date, String path){
        logger.info("editing ticket date file");
       File file = new File(path);
       File storage = new File(file.getParentFile(), "Storage.txt");

       try(BufferedReader reader = new BufferedReader(new FileReader(file));
       BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){

        String curretLine;
        boolean found = false;

        while ((curretLine = reader.readLine()) != null) {
            if(curretLine.contains("Data:")){

                String updatedLine = curretLine.replaceAll("Data: \\d{2}/\\d{2}/\\d{4}", "Data: " + date);
                writer.write(updatedLine);
                found = true;
            }else{
                writer.write(curretLine);
            }

            if (!found) {
                logger.info("File not founded");
            }


            writer.close();
            reader.close();


            if(!file.delete()){
               logger.info("Could not delete the file");
            }

            if (!storage.renameTo(file)) {
               logger.info("Could not rename to storage");
            }
        }
        
       } catch (IOException e){
            logger.error("Failed to edit file");
       }
       
    }


    public static void editSession(userSession session, movieTicket movieTime){
        logger.info("editing ticket session");
        File TicketFile = new File(ticketsTable, session.getUserId() + 
        "-" + session.getNome() + "-"  + movieTime.getNome() + "-" + ".txt");

        if(TicketFile.isFile()){    
            logger.info("ticket file validate");
            String pathOfFile = TicketFile.toString();
          
            editeMovieSession(movieTime.getHora(), movieTime.getMinuto(), pathOfFile);
        }else {
            logger.error("File not founded");
        }
    
    }


    public static void editeMovieSession(int hora, int minuto, String path){
        logger.info("eciting movie session");
        File file = new File(path);
        File storage = new File(file.getParentFile(), "Storage.txt");

        try(BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){

            String curretLine;
            boolean found = false;

            while ((curretLine = reader.readLine()) != null) {
                if(curretLine.contains("Reserva:")){

                    String horaStr = String.format("%02d", hora);
                    String minutoStr = String.format("%02d", minuto);
                    String newTime = horaStr + ":" + minutoStr;

                    String updatedLine = curretLine.replaceAll("Reserva: \\d{2}:\\d{2}", "Reserva: " + newTime);
                    writer.write(updatedLine);
                    found = true;
                }else{
                    writer.write(curretLine);
                }


                if (!found) {
                    logger.info("File not founded");
                }
    
                writer.close();
                reader.close();
    
    
              if(!file.delete()){
                logger.info("Could not delete the file");
               }
    
                if (!storage.renameTo(file)) {
                    logger.info("Could not rename to storage");
               }
            }

        } catch(IOException e){
            logger.error("File not founded");
        }

    }


    public static void editSets(userSession session, movieTicket movieSeats){
        logger.info("editing seats");
        File TicketFile = new File(ticketsTable, session.getUserId() + 
        "-" + session.getNome() + "-"  + movieSeats.getNome() + "-" + ".txt");

        if(TicketFile.isFile()){
            logger.info("ticket file is a file");
            String pathOfFile = TicketFile.toString();
          
            editeMovieSeats(movieSeats.getSeat(), pathOfFile);
        }else {
            logger.info("File not founded on edit sets");
        }
    
    }

    public static void editeMovieSeats(String[] seats, String path) {
        logger.info("Editing movie seats");
        File file = new File(path);
        File storage = new File(file.getParentFile(), "Storage.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(storage))) {

            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains("Assentos:")) {
                
                    String prefix = "Assentos: ";
                    String suffix = ",";
                    int startIndex = currentLine.indexOf(prefix) + prefix.length();
                    int endIndex = currentLine.indexOf(suffix, startIndex);

                    if (startIndex != -1 && endIndex != -1) {
                        String existingSeats = currentLine.substring(startIndex, endIndex);
                        String updatedSeats = String.join(".", seats);
    
                        String updatedLine = currentLine.replaceFirst(prefix + existingSeats + suffix, prefix + updatedSeats + suffix);
                        writer.write(updatedLine);
                        found = true;
                    }

                } else {
                    writer.write(currentLine);
                }

                writer.close();
                reader.close();

                if(!file.delete()){
                    logger.info("Could not delete the file");
                 }
      
                  if (!storage.renameTo(file)) {
                    logger.info("Could not rename to storage");
                 }

            }

            if (!found) {
                logger.info("No line containing 'Assentos:' found in the file.");
            }

        } catch (IOException e) {
             logger.error("Error editing file: " + e.getMessage());
        }

    }

}
