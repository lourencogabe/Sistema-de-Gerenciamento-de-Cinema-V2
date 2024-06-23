package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;
import com.cinema.functions.readTicketsTable;

public class readUserTickets {

   private static  UUID id = null;
   public static List<movieTicket> userTickets = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static movieTicket readUserTicket(String nome, String classificacao, String[] genero, int hour,  int minuto
    ,String[] seats, String data, String horario, int quantidade){

        logger.info("reeading user ticket");
        
        try{              
            logger.info("validating user");     
           movieTicket userTicket = new movieTicket(nome,genero, classificacao,hour, minuto,seats,data,horario,quantidade);
           fillUserTicketArray(userTicket);
                    
        }catch (NullPointerException e){
            logger.info("uer not loged in");
        }
      
              

             return null;

    }

    public static void validateUserInSession(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            if(UserSession != null){
                id = UserSession.getUserId();
                logger.info("Called from read ticker: " + UserSession.getNome() + UserSession.getUserId());
            }
        }
    }

    public static void fillUserTicketArray(movieTicket userTicket){
        logger.info("felling ticket array with data");
        userTickets.add(userTicket);
    }



    public static void clearTickets() {
        logger.info("Clearing catalog array");
        userTickets.clear();
    }
    

    public static List<movieTicket> getUserTickets(){
       
        try{
            userSession session = SessionManager.getUserDataFromSession(id);
            if (session != null) {
                logger.info("validating user and reading tickets table"); 
                readTicketsTable.readTicketTable(session);
            }else{
                logger.info("uer not loged in");
            }
            
        }catch(NullPointerException e){
            logger.error("session is empty");
        }
     
        return userTickets;
    }
}
