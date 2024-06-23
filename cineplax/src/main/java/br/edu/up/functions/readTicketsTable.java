package com.cinema.functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.readUserTickets;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;

public class readTicketsTable {
 private static final Logger logger = LogManager.getLogger(Main.class);
    private static String ticketsTable = ("D:\\cinema\\cinema\\database\\tickets");

    public static void readTicketTable(userSession session) {
        readUserTickets.clearTickets();
        String userIdString = session.getUserId().toString();
        Path ticketsDirectory = Paths.get(ticketsTable);
       
        try {
            List<movieTicket> allUserTickets = new ArrayList<>();
            Files.walkFileTree(ticketsDirectory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().isFile()) {
                        String fileName = file.getFileName().toString();
                        if (fileName.startsWith(userIdString)) {
                            System.out.println("Reading files: " + fileName);
                            List<movieTicket> userTicketsFromFile = readFile(file.toFile(), session);
                            allUserTickets.addAll(userTicketsFromFile);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            logger.info("Total user tickets found: " + allUserTickets.size());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Erro localizing file no file founded" + e.getMessage());
        }
    }


    private static List<movieTicket> readFile(File file, userSession session) {
        logger.info("reading ticket files");
        List<movieTicket> userTickets = new ArrayList<>();

        

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String nome = "";
            String classificacao = "";
            String[] genero = null;
            int hour = 0;
            int minute = 0;
            String duracao = "";
            String data = "";
            String reserva = "";
            String[] seats = null;
            int quantidade = 0;
    
            while ((line = reader.readLine()) != null) {
                try {
                    if (line.contains("Nome:")) {
                        int start = line.indexOf("Nome:") + "Nome:".length();
                        int end = line.indexOf(",", start);
                        nome = line.substring(start, end).trim();
                    }
    
                    if (line.contains("Classificacao:")) {
                        int start = line.indexOf("Classificacao:") + "Classificacao:".length();
                        int end = line.indexOf(",", start);
                        classificacao = line.substring(start, end).trim();
                    }
    
                    if (line.contains("Genero:")) {
                        int start = line.indexOf("Genero:") + "Genero:".length();
                        int end = line.indexOf(",", start);
                        String generoString = line.substring(start, end).trim();
                        genero = generoString.split("\\s*\\s*\\.\\s*\\s*");
                    }
    
                    if (line.contains("Duracao:")) {
                        int start = line.indexOf("Duracao:") + "Duracao:".length();
                        int end = line.indexOf(",", start);
                        duracao = line.substring(start, end).trim();
                    
    
                        duracao = duracao.replace("h", "").replace("m", "");
                        String[] movieDuration = duracao.split("\\s*e\\s*");
                    
                        if (movieDuration.length == 2) {
                            hour = Integer.parseInt(movieDuration[0].trim());
                            minute = Integer.parseInt(movieDuration[1].trim());
                        }
                    }
    
                    if (line.contains("Data:")) {
                        int start = line.indexOf("Data:") + "Data:".length();
                        int end = line.indexOf(",", start);
                        data = line.substring(start, end).trim();
                    }
    
                    if (line.contains("Reserva:")) {
                        int start = line.indexOf("Reserva:") + "Reserva:".length();
                        int end = line.indexOf(",", start);
                        reserva = line.substring(start, end).trim();
                    }
    
                    if (line.contains("Assentos:")) {
                        int start = line.indexOf("Assentos:") + "Assentos:".length();
                        int end = line.indexOf(",", start);
                        String seatsString = line.substring(start, end).trim();
                        seats = seatsString.split("\\s*\\.\\s*");

                    }
    
                    if (line.contains("Quantidade:")) {
                        int start = line.indexOf("Quantidade:") + "Quantidade:".length();
                        int end = line.indexOf(";", start);
                        String quantityString = line.substring(start, end).trim();
                        quantidade = Integer.parseInt(quantityString);
                    }
    




                    movieTicket userTicketsInfo = new movieTicket(nome, genero, classificacao, hour, minute, seats, data, reserva, quantidade);
                    userTickets.add(userTicketsInfo);

                    
                    readUserTickets.readUserTicket(nome, classificacao, genero, hour, minute, seats, data, reserva, quantidade);
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    logger.error("Error parsing line: " + line + ". Skipping...");
                    continue;
                }
            }
    
        } catch (IOException e) {
           logger.error("Error reading file: " + e.getMessage());
        }
    
        return userTickets;
    }

}