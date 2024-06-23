package com.cinema.exception;
import java.io.IOException;

public class ErroReadingFiles extends IOException {
    

    public ErroReadingFiles(String message){
        super(message);
    }

    public ErroReadingFiles(String message, Throwable cause){
        super(message, cause);
    }

   
    public static String standadartMessage(Exception e){
        return "Erro reading file, null elements pressent: " + e.getMessage();
    }


}