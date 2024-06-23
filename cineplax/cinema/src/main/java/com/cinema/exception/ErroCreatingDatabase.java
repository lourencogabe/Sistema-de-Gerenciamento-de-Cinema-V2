package com.cinema.exception;

public class ErroCreatingDatabase extends Exception {
    
    public ErroCreatingDatabase(String message){
        super(message);
    }

    public ErroCreatingDatabase(String message, Throwable cause){
        super(message, cause);
    }


    public static String errorPushingUser(Exception e){
            return "Error creating User on table Usuarios: " + e.getMessage();
    }

    public static String erroCreatingTable(Exception e){
        return "Erro creating user Table: " + e.getMessage();
    }

  @Override
    public String toString() {
        return "Erro ao criar o banco de dados: " + getMessage();
    }
    
}
