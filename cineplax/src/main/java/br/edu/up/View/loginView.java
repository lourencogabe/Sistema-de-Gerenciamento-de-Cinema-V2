package com.cinema.View;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.SessionManager;
import com.cinema.Controller.buyTicketController;
import com.cinema.Controller.deleteTicket;
import com.cinema.Controller.editTicket;
import com.cinema.Controller.editUserData;
import com.cinema.Controller.loginController;
import com.cinema.Controller.readUserTickets;
import com.cinema.Controller.UnloagController;
import com.cinema.Model.login;
import com.cinema.Model.userSession;
import com.cinema.functions.readUserDatabase;

public class loginView {

 private static final Logger logger = LogManager.getLogger(Main.class);


 private static final Scanner scanner = new Scanner(System.in);
     public static void main(String[] args){

        readUserDatabase.readUser();

        Map<UUID, login> logedUser = loginController.getUser();

        logInAplication(logedUser);
     }


     public static void logInAplication(Map<UUID, login> logedUser){
        logger.info("Login in on the aplication");
        System.out.println("informe o email do usuario");
        String email = scanner.nextLine();
        System.out.println("Informe a senha do usuario");
        String senha = scanner.nextLine();

        boolean isValid = loginController.validateUserCredetials(email, senha);

        if(isValid){
            logger.info("Credential Valide user loged in");
            ValidateUser(email);
            buyTicketController.validateUserInSession(email);
            readUserTickets.validateUserInSession(email);
            editTicket.validateUserInSession(email);
            deleteTicket.validateUserInSession(email);
            editUserData.validateUserInSession(email);
            UnloagController.validateUserInSession(email);
        }else{
            logger.warn("Credentials no founded user not loged in");
        }
    }

    public static void ValidateUser(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            logger.info("user logedin: " + UserSession.getNome());
        }else{
            logger.info("please log in on the aplication to buy a ticket");
        }
    }
}
