package com.cinema.Controller;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;
import com.cinema.functions.editedTickedInfo;

public class editTicket {
    private static  UUID id = null;
    private static final Logger logger = LogManager.getLogger(Main.class);



    public static movieTicket editTicketData(movieTicket editeDate){
        logger.info("calling method do edit ticket date");
        userSession session = SessionManager.getUserDataFromSession(id);

        if(session != null){
            logger.info("validating user");
            editedTickedInfo.editedTicketDate(session, editeDate);
        }else{
            logger.info("user is not loged in");
        }
       
        return null;
    }


    public static movieTicket editTicketSessionTime(movieTicket editSessionTime){

        userSession session = SessionManager.getUserDataFromSession(id);
        logger.info("calling method do edit ticket time");

        if(session != null){
            logger.info("validating user");
            editedTickedInfo.editSession(session, editSessionTime);
        }else{
            logger.info("user is not loged in");
        }

        return null;
    }


    public static movieTicket editSeats(movieTicket edMovieTicket){
        userSession session = SessionManager.getUserDataFromSession(id);
        logger.info("calling method do edit ticket seats");

        if(session != null){
            logger.info("validating user");

            editedTickedInfo.editSets(session, edMovieTicket);

        }else{
            logger.info("user is not loged in");
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


}
