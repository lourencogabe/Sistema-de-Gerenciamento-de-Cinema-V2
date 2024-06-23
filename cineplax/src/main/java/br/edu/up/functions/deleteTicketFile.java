package com.cinema.functions;
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.CinePlax.Main;
import com.cinema.Model.Catalogue;
import com.cinema.Model.userSession;

public class deleteTicketFile {
    

      private static File ticketsTable = new File("D:\\cinema\\cinema\\database\\tickets");
       private static final Logger logger = LogManager.getLogger(Main.class);


      public static void deleteUserTicket(userSession session, Catalogue deleteUserTicket){
        logger.info("deleting ticket file");
        File TicketFile = new File(ticketsTable, session.getUserId() + 
        "-" + session.getNome() + "-"  + deleteUserTicket.getNome() + "-" + ".txt");


        if(TicketFile.isFile()){
            System.out.println("path" + TicketFile.getAbsolutePath());
            
            if (TicketFile.delete()) {
              logger.info("File deleted successfully.");
          } else {
            logger.error("Failed to delete the file.");
          }
            
        }

      }
}
