package com.cinema.Controller;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Catalogue;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;
import com.cinema.functions.deleteTicketFile;

public class deleteTicket {
        private static final Logger logger = LogManager.getLogger(Main.class);
    private static  UUID id = null;


    public static movieTicket deleteMovieTicket(movieTicket deleteTicket){

        logger.info("Calling method do delete ticket");
        userSession session = SessionManager.getUserDataFromSession(id);

        if(session != null) {
            logger.info("Validation logeed in user");

            String movieName = deleteTicket.getNome();


            Catalogue deleteUserTicket = new movieTicket(movieName);

            
            deleteTicketFile.deleteUserTicket(session, deleteUserTicket);



        }else{
            logger.info("user is not logedin");
        }

        return null;
    }

     public static void validateUserInSession(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            if(UserSession != null){
                id = UserSession.getUserId();
                System.out.println("Called from read ticker: " + UserSession.getNome() + UserSession.getUserId());
            }
        }
    }

}

