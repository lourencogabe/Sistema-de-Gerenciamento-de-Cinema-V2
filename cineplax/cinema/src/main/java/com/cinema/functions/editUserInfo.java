package com.cinema.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.CinePlax.Main;
import com.cinema.Model.Usuario;
import com.cinema.Model.userSession;

public class editUserInfo {
    
  private static File userTable = new File("D:\\cinema\\cinema\\database\\Usuarios");
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void editEmail(userSession session, userSession email ){
        logger.info("editign email");

        File userFile = new File(userTable, "Usuarios.txt");

        if(userFile.isFile()){
            String newEmail = email.getEmail();
            UUID uuid = session.getUserId();
            String pathToFile = userFile.toString();
            String id = uuid.toString();



            editUserEmail(id, newEmail, pathToFile);
        }

    }


    public static void editUserEmail(String id, String newEmail, String path){
        logger.info("editign email file");
       File userInfo = new File(path);
       File storage = new File(userInfo.getParentFile(),"Storage.txt");

       try(BufferedReader reader = new BufferedReader(new FileReader(userInfo));
       BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){

        String curretLine;
        boolean found = false;

        while ((curretLine = reader.readLine()) != null) {
            if (curretLine.contains(id)) {
                String updatedLine = curretLine.replaceAll("email=[^,]*", "email=" + newEmail);
                writer.write(updatedLine);
                found = true;
            } else {
                writer.write(curretLine);
            }

            writer.newLine();
            if (!found) {
                logger.warn("File not founded");
            }
        }

    } catch(IOException e) {
        logger.error("Erro editing file" + e.getMessage());
    }

    try {
        if (!userInfo.delete()) {
            logger.warn("Could not delete the original file.");
        }

        if (!storage.renameTo(userInfo)) {
            logger.warn("Could not rename the temporary file to the original file name.");
        }
    } catch (Exception e) {
        logger.error("Error replacing the original file: " + e.getMessage());
    }

    }


    public static void editPassword(userSession session, Usuario newPassword ){
        logger.info("changing password");
        File userFile = new File(userTable, "Usuarios.txt");

        if(userFile.isFile()){
            String newPass = newPassword.getSenha();
            UUID uuid = session.getUserId();
            String pathToFile = userFile.toString();
            String id = uuid.toString();

            logger.info("password in file: " + newPass);

            editUserPassword(id, newPass, pathToFile);
        }
    }


    public static void editUserPassword(String id, String newSenha, String path){
        logger.info("changing password file");
        File userInfo = new File(path);
        File storage = new File(userInfo.getParentFile(),"Storage.txt");
 
        try(BufferedReader reader = new BufferedReader(new FileReader(userInfo));
        BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){
 
         String curretLine;
         boolean found = false;
 
         while ((curretLine = reader.readLine()) != null) {
             if (curretLine.contains(id)) {
                 String updatedLine = curretLine.replaceAll("senha=[^,]*", "senha=" + newSenha + ";");
                 writer.write(updatedLine);
                 found = true;
             } else {
                 writer.write(curretLine);
             }
 
             writer.newLine();
             if (!found) {
                 logger.info("File not founded");
             }
         }
 
     } catch(IOException e) {
         logger.error("Erro editing file");
     }
 
     try {
         if (!userInfo.delete()) {
             logger.info("Could not delete the original file.");
         }
 
         if (!storage.renameTo(userInfo)) {
            logger.info("Could not rename the temporary file to the original file name.");
         }
     } catch (Exception e) {
        logger.error("Error replacing the original file: " + e.getMessage());
    }
 
    }


    public static void deletUseer(userSession session){
        logger.info("Deleting user");
        File userFile = new File(userTable, "Usuarios.txt");

        if(userFile.isFile()){
            UUID uuid = session.getUserId();
            String pathToFile = userFile.toString();
            String id = uuid.toString();
            deleteUserFromData(id, pathToFile);
        }
    }



    public static void deleteUserFromData(String id, String path){
        File userInfo = new File(path);
        File storage = new File(userInfo.getParentFile(),"Storage.txt");
 
        try(BufferedReader reader = new BufferedReader(new FileReader(userInfo));
        BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){
 
         String curretLine;
         boolean found = false;
         while ((curretLine = reader.readLine()) != null) {
             if (curretLine.contains(id)) {
                found = true;
                continue; 
             } else {
                 writer.write(curretLine);
             }
 
             writer.newLine();
             if (!found) {
                logger.info("File not founded");
             }
         }
 
     } catch(IOException e) {
        logger.error("Erro editing file" + e.getMessage());
     }

     try {
        if (!userInfo.delete()) {
            logger.info("Could not delete the original file.");
         }
 
         if (!storage.renameTo(userInfo)) {
            logger.info("Could not rename the temporary file to the original file name.");
        }
       } catch (Exception e) {
            logger.error("Error replacing the original file: " + e.getMessage());
        }
 
    }
}
