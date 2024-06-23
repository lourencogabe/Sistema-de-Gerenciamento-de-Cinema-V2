package com.cinema.Controller;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.userSession;

public class UnloagController {
    private static final Logger logger = LogManager.getLogger(Main.class);
        private static  UUID id = null;
    public static void unloagUser(){
        userSession session = SessionManager.getUserDataFromSession(id);

        if(session != null){

            String userEmail = session.getEmail();
            SessionManager.removeSession(userEmail);
        }

    }



    public static void validateUserInSession(String email){
        logger.info("validating user session in unloage method");
        if(SessionManager.isUserLoggedIn(email)){
            logger.info("user is logedin");
            userSession UserSession = SessionManager.getUserSession(email);
            id = UserSession.getUserId();
        }
    }
}
