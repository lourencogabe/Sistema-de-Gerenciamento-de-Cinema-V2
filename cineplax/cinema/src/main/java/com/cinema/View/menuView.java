package com.cinema.View;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;

public class menuView {
    final static Scanner scanner = new Scanner(System.in);
     private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("running main menu");
        int runtime = 100;

        for(int i = 0; i < runtime; i++){
            System.out.println("Menu");
            System.out.println("1: Cadastrar usuario");
            System.out.println("2: listar filmes em cartaz");
            System.out.println("3: Logar na aplicacao");
            System.out.println("4: comprar ingresso");
            System.out.println("5: mostrar ingressos comprados");
            System.out.println("6: editar ingresso");
            System.out.println("7: deletar ingresso");
            System.out.println("8: editar dados do usuario");
            System.out.println("9: deslogar da aplicacao");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    executeCreatUser();
                    break;

                case 2:
                    executeCartaz();
                    break;
            
                case 3:
                    login();
                    break;

                case 4: 
                    buy();
                    break;
                case 5:
                    viewBougthTickets();
                    break;  
                    
                case 6:
                    editUserTicket();
                    break;

                case 7:
                    deleteTicker(); 
                    break;

                case 8:
                    EditUserCredentials();
                    break;    

                    case 9:
                    UnloagUser();
                    break;
                default:
                 
                    break;
            }
        }
        
    }



    public static void executeCreatUser(){
        try {
            cadasstroDeUsuarioView.main(new String[0]);
        }catch (Exception e){
         
            System.out.println("Erro Executing User Registration" + e.getMessage());
        }
    }

    public static void executeCartaz(){
        try {
            cartazView.main(new String[0]);
        }catch (Exception e){

            System.out.println("Erro Executing view Catalogue" + e.getMessage());
        }
    }


    public static void login(){
        try {
            loginView.main(new String[0]);
        }catch (Exception e){
      
            System.out.println("Erro Executing view login" + e.getMessage());
        }
    }


    public static void buy(){
        try {
            buyTicketsView.main(new String[0]);
        }catch (Exception e){
         logger.error("Erro Executing buy ticket" + e.getMessage());
        }
    }


    public static void viewBougthTickets(){
        try {
            viewUserTicket.main(new String[0]);
        }catch (Exception e){
             logger.error("Erro Executing view tickets" + e.getMessage());        
        }
    }

    public static void editUserTicket(){
        try {
            editTicketView.main(new String[0]);
        }catch (Exception e){
            logger.error("Erro Executing edit ticket" + e.getMessage());
        }
    }

    public static void deleteTicker(){
        try {
            deleteTicketView.main(new String[0]);
        }catch (Exception e){
             logger.error("Erro Executing delete ticket" + e.getMessage());
        }
    }

    public static void EditUserCredentials(){
        try {
            editUserInfo.main(new String[0]);
        }catch (Exception e){
            logger.error("Erro Executing edit user credentials" + e.getMessage());

        }
    }

    public static void UnloagUser(){
        try {
            unloagUserView.main(new String[0]);
        }catch (Exception e){
            logger.error("Erro Executing Unloag user" + e.getMessage());

        }
    }

}
