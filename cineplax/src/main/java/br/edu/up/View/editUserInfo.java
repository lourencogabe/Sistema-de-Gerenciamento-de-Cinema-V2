package com.cinema.View;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.editUserData;
import com.cinema.Model.Usuario;
import com.cinema.Model.login;
import com.cinema.Model.userSession;
public class editUserInfo {
     final static Scanner scanner = new Scanner(System.in);
      private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception  {
        logger.info("entered edit user view");
        System.out.println("Selecione o que deseja editar");
        System.out.println("1: Editar email");
        System.out.println("2: Editar senha");
        System.out.println("3: Apagar conta");
        int op = scanner.nextInt();
        
        scanner.nextLine();


        switch (op) {
            case 1:
                System.out.println("Informe o novo email");
                String email = scanner.nextLine();

                 userSession emailUser = new userSession(email);
                 emailUser.setEmail(email);
                 editUserData.editUserEmail(emailUser);
                break;

            case 2:
                    System.out.println("Informe a senha");
                    String senha = scanner.nextLine();
                    Usuario userPassword = new login(senha);
                    userPassword.setSenha(senha);
                    editUserData.editUserPassword(userPassword);

                break;

                case 3:
                  editUserData.deleteUser();
                break;

            default:

            
                break;
        }


    }

}
