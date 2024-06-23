package com.cinema.functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.loginController;
import com.cinema.exception.ErroReadingFiles;

public class readUserDatabase{

 
private static final File userDatabse = new File("D:\\cinema\\cinema\\database\\Usuarios");
private static final Logger logger = LogManager.getLogger(Main.class);


public static void readUser(){

    File userTable = new File(userDatabse, "Usuarios.txt");

    if(userTable.exists()){
        logger.info("User Table Already Exists");
    }

        if(userTable.isFile()){
            logger.info("User table is a file");
            try(BufferedReader reader = new BufferedReader(new FileReader(userTable))) {
                logger.info("Reading user Table");
                String line;
                String id = "";
                String nome = "";
                String cpf = "";
                String celular = "";
                String email = "";
                String senha = "";
                UUID userId = null;

               while ((line = reader.readLine()) != null) {
                    
                if(line.contains("Id:")){
                    int start = line.indexOf("Id:") + "Id:".length();
                    int end = line.indexOf(",", start);
                    id = line.substring(start, end).trim();
                    try{
                        userId = UUID.fromString(id);
                        logger.debug("Sucesfully parsed UUID: " + userId.toString());
                    } catch (IllegalArgumentException e){
                        logger.error(e.getMessage());
                    }
        
                }

                if(line.contains("nome=")){
                    int start  = line.indexOf("nome=") + "nome=".length();
                    int end = line.indexOf(",", start);
                    nome = line.substring(start, end);
                    System.out.println("nome: " + nome);
                }

                if(line.contains("cpf=")){
                    int start  = line.indexOf("cpf=") + "cpf=".length();
                    int end = line.indexOf(",", start);
                    cpf = line.substring(start, end);
                }

                if(line.contains("celular=")){
                    int start  = line.indexOf("celular=") + "celular=".length();
                    int end = line.indexOf(",", start);
                    celular = line.substring(start, end);
                   
                }

                if(line.contains("email=")){
                    int start  = line.indexOf("email=") + "email=".length();
                    int end = line.indexOf(",", start);
                    email = line.substring(start, end);
                }

                if(line.contains("senha=")){
                    int start  = line.indexOf("senha=") + "senha=".length();
                    int end = line.indexOf(";", start);
                    senha = line.substring(start, end);
                }

                loginController.loginUsuario(email, senha, userId);
                loginController.getUserData(email, userId, nome);

               }

            } catch (IOException e) {
                ErroReadingFiles.standadartMessage(e);
                logger.error(ErroReadingFiles.standadartMessage(e));
            }
        }

    }

}
