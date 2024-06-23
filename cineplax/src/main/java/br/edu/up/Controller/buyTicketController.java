package com.cinema.Controller;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.BuyTickets;
import com.cinema.Model.userSession;
import com.cinema.exception.ErroReadingFiles;
import com.cinema.functions.creatTicketsTable;

public class buyTicketController {
 private static final Logger logger = LogManager.getLogger(Main.class);
    private static  UUID id = null;

    public static BuyTickets buyMovieTickets(BuyTickets tickets, int quantity) throws ErroReadingFiles{
            logger.info("calling method to buy movie tickets");
            userSession session = SessionManager.getUserDataFromSession(id);
            if(session != null){
                logger.info("User session validated");
                creatTicketsTable creaUserTicket = new creatTicketsTable();
                creaUserTicket.cretUserTicket(session, tickets, quantity);
            }else{
                logger.error("Erro validating user is not loged in");
            }

            return null;
    }

    public static void validateUserInSession(String email){
        logger.info("validating user session in buy ticket method");
        if(SessionManager.isUserLoggedIn(email)){
            logger.info("user is logedin");
            userSession UserSession = SessionManager.getUserSession(email);
            id = UserSession.getUserId();
        }
    }
}
