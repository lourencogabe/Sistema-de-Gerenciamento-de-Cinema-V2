package com.cinema.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.CinePlax.Main;
import com.cinema.Controller.UnloagController;

public class unloagUserView {

     private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Unlogin user");
        UnloagController.unloagUser();
    }



    
}
