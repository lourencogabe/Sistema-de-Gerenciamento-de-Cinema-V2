package com.cinema.Controller;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.CinePlax.Main;
import com.cinema.Model.Usuario;
import com.cinema.Model.userSession;
import com.cinema.functions.editUserInfo;

public class editUserData {

    private static  UUID id = null;

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static Usuario editUserEmail (userSession userEmail){

        userSession session = SessionManager.getUserDataFromSession(id);
        logger.info("calling method to edit user email");
        
        if(session != null){
            logger.info("validating user");
            editUserInfo.editEmail(session, userEmail);

        }else{
            logger.info("user not loged in");
        }
        

        return userEmail;


    }



    public static  Usuario  editUserPassword(Usuario userPassword){
        userSession session = SessionManager.getUserDataFromSession(id);

        logger.info("calling method to edit user password");
        if(session != null){
            logger.info("validating user");
            System.out.println(userPassword);
            editUserInfo.editPassword(session, userPassword);

        }else{
            logger.info("user not loged in");
        }

            return null;
    }


    public static Usuario deleteUser(){
        userSession session = SessionManager.getUserDataFromSession(id);
        logger.info("calling method to delete user");
        if(session != null){
            
            editUserInfo.deletUseer(session);
        }else{
            logger.info("user not loged in");
        }

        return null;
    }


    
    public static void validateUserInSession(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            if(UserSession != null){
                id = UserSession.getUserId();
                logger.info("Called from edit user info ticker: " + UserSession.getNome() + UserSession.getUserId());
            }
        }
    }

}
