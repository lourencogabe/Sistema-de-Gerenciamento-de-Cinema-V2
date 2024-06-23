package com.cinema.functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.catalogueController;
import com.cinema.exception.ErroReadingFiles;

public class readMovieTable {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static File catalogueeDir = new File("D:\\cinema\\cinema\\database\\movies");

    public static void readMovieCalatologue(){
        catalogueController.clearCartaz();
        File calogueTable = new File(catalogueeDir, "catalogue.txt");

        if(calogueTable.exists()){
            logger.info("Table Catalogue exists");
        }

       
        if (calogueTable.isFile()) {
            logger.info("Catalogue is a file");
          
            try(BufferedReader reader = new BufferedReader(new FileReader(calogueTable))){
                logger.info("Reading catalogue File");
                String line;
                String nome = "";
                String classificacao ="";
                String duracao = "";
                int hour = 0;
                int minute = 0;
                String[] genero = null; 

               while ((line = reader.readLine()) != null) {

                logger.info("Filling Variables with data");
                    if(line.contains("nome:")) {
                        logger.info("reading name from file");
                        int start = line.indexOf("nome:") + "nome:".length();
                        int end = line.indexOf(",");
                        nome = line.substring(start, end).trim();
                    }

                    if(line.contains("genero:")){
                        logger.info("reading gender from file");
                        int start = line.indexOf("genero:") + "genero:".length();
                        int end = line.indexOf(",", start);
                        String generoString = line.substring(start, end).trim();
                        genero = generoString.split("\\s*\\.\\s*");
                    }

                    if(line.contains("classificacao:")){
                        logger.info("reading classfication from file");
                        int start = line.indexOf("classificacao:") + "classificacao:".length();
                        int end = line.indexOf(",", start);
                        classificacao = line.substring(start, end).trim();
                    }


                    if (line.contains("duracao:")) {
                        logger.info("reading duration from file");
                        int start = line.indexOf("duracao:") + "duracao:".length();
                        int end = line.indexOf(";", start);
                        if (end == -1) {
                            end = line.length();
                        }
                       
                         duracao = line.substring(start, end).trim();
                         String[] movieDuration = duracao.split("\\s*\\.\\s*");


                        if (movieDuration.length == 2) {
                           hour = Integer.parseInt(movieDuration[0].trim());
                           minute = Integer.parseInt(movieDuration[1].trim());
   
                        }
                     
                    }



                    logger.info("Reading file complete");
                    logger.info("Pushing data into controller");
                    catalogueController.movieCatalogue(nome,genero,classificacao,hour,minute);

               }

            }catch (IOException e){
                  ErroReadingFiles.standadartMessage(e);
                  logger.error(ErroReadingFiles.standadartMessage(e));
             }
            
        }

     }
}
