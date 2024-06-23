package com.cinema.functions;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Usuario;
import com.cinema.exception.ErroCreatingDatabase;
import com.cinema.exception.ErroReadingFiles;



public class creatUserDatabase  {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private File userDir = new File("D:\\cinema\\cinema\\database\\Usuarios");    


    public void creatUser(Map<UUID, Usuario> cadastroDeUsuario) throws ErroCreatingDatabase {

            if(!userDir.exists()){
                logger.info("cheking if the foulder exists");
                userDir.mkdirs();
            }
            

            logger.info("creating usuario Table");
            File userTable = new File(userDir, "Usuarios.txt");
            if(!userTable.exists()){
                try{
                    boolean tableCreated = userTable.createNewFile();

                    if(tableCreated){
                        logger.info("database Table Created Suceesfully");
                    }else{
                        logger.info("Erro Creating Database Table");
                    }
                } catch (IOException e){
                    e.toString();
                    logger.error("Error Creating table: " + e.getMessage());
                    throw new ErroCreatingDatabase(ErroCreatingDatabase.erroCreatingTable(e), e);
                }
               
            }else{
                logger.warn("Table Usuarios already Exists");
            } 


                try{
                    FileWriter file = new FileWriter(userTable, true);
                    PrintWriter write = new PrintWriter(file);


                    for (Map.Entry<UUID, Usuario> entry : cadastroDeUsuario.entrySet()) {
                        write.println("Id: " + entry.getKey() + "," + " " + entry.getValue().toString());
                        logger.info("User inserted into table sucessfully");
                        write.println();
                    }

                    write.flush();
                    write.close();

                }catch( IOException e){
                    ErroReadingFiles.standadartMessage(e);
                    logger.error(ErroCreatingDatabase.errorPushingUser(e) + e.getMessage() + ErroReadingFiles.standadartMessage(e));
                    throw new ErroCreatingDatabase(ErroCreatingDatabase.errorPushingUser(e));
                }
    }

}
