package com.cinema.CinePlax;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.View.menuView;
import com.cinema.exception.ErroCadastroDeUsuario;


public class Main {
  
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws ErroCadastroDeUsuario {
        executarMenu();

    }

 
    public static void executarMenu(){
        try {
            logger.info("Executing main block");
            menuView.main(new String[0]);
        }catch (Exception e){
            logger.error("Erro Executing User Registration" + e.getMessage());
        }
    }

}
