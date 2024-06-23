package com.cinema.functions;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.BuyTickets;
import com.cinema.Model.userSession;
import com.cinema.exception.ErroReadingFiles;

public class creatTicketsTable {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private File ticketsDir = new File("D:\\cinema\\cinema\\database\\tickets");


    public void cretUserTicket(userSession session, BuyTickets tickets, int quantity) throws ErroReadingFiles{
        logger.info("Function to creat user database called");
        File ticketsTable = new File(ticketsDir, session.getUserId() + 
         "-" + session.getNome() + "-"  + tickets.getNome() + "-" + ".txt");

         if(!ticketsTable.exists()){
            try{
                logger.info("validating the user table folder");
                boolean tableCreated = ticketsTable.createNewFile();

                if(tableCreated){
                    logger.info("table created");
                }else{
                    logger.error("failled to creat table");
                }
                
                writeTicket(session, tickets, quantity);
            }catch(IOException e){
                logger.error(e.toString());
                throw new ErroReadingFiles(ErroReadingFiles.standadartMessage(e));
            }            
         }
    }

    public void writeTicket(userSession session, BuyTickets tickets, int quantity) throws IOException {
        logger.info("writing user data on file");
        File movieTicket = new File(ticketsDir, session.getUserId() + 
        "-" + session.getNome() + "-"  + tickets.getNome() + "-" + ".txt");

        FileWriter table = new FileWriter(movieTicket, true);
        PrintWriter write = new PrintWriter(table);

        List<BuyTickets> ticket = new ArrayList<>();
        ticket.add(tickets);

        for (BuyTickets buyTickets : ticket) {
            write.println("Nome: " + buyTickets.getNome()
            + "," + " " + "Classificacao: " + buyTickets.getClassificacao() + "," + " " 
            + "Genero: " + String.join(" . ", buyTickets.getGenero()) + "," + " " +
            "Duracao: " + buyTickets.getHora() + "h" + " e "  +
            buyTickets.getMinuto() + "m" + ", " + "Data: " +buyTickets.getData() + ", " +
            "Reserva: " + buyTickets.getTimeReservation() + "," 
            + " " + "Assentos: " +  String.join(".", buyTickets.getSeat())  + "," + " " + "Quantidade: " + quantity + ";");
        }

        write.flush();
        write.close();

        logger.info("Finished writing to the file");
    }
}
