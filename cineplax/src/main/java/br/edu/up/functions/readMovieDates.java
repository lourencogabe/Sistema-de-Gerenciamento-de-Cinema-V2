package com.cinema.functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.catalogueDatesController;

public class readMovieDates {
      private static final Logger logger = LogManager.getLogger(Main.class);
private static File datesFile = new File("D:\\cinema\\cinema\\database\\moviesDate");


    public static void readMovieDatesTable(){
        File movieDate = new File(datesFile, "movieAvaibleDates.txt");

        if(movieDate.exists()){
            logger.info("File founded");
        }else{
            logger.info("File not founded");
        }


        if(movieDate.isFile()){
            try(BufferedReader reader = new BufferedReader(new FileReader(movieDate))){
                String line;
                String id = null;
                String data;
                String time;
                String[] movieData = null;
                String[] avaibleHour = null;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("id:")) {

                        if (id != null) {
                            catalogueDatesController.moviesDatesAndTime(id, movieData, avaibleHour);
                            movieData = null;
                            avaibleHour = null;
                        }

                        int start = line.indexOf("id:") + "id:".length();
                        int end = line.indexOf(",", start);
                        id = line.substring(start, end).trim();
                    }

                    if(line.contains("Datas:")){
                        int start = line.indexOf("Datas:") + "Datas:".length();
                        int end = line.indexOf(",", start);
                        data = line.substring(start, end).trim();
                        movieData = data.split("\\s*\\.\\s*");
                    }

                    if(line.contains("horarios:")){
                        int start = line.indexOf("horarios:") + "horarios:".length();
                        int end = line.indexOf(";", start);
                        time = line.substring(start, end).trim();

                         avaibleHour = time.split(",\\s*");
                        for (String t : avaibleHour) {
                           String[] splitTime = t.split("\\:");

                           if(splitTime.length == 2){
                            String hour = splitTime[0];
                            String minute = splitTime[1];

                           }else{
                            logger.info("Invalid Formate");
                           }
                        }
                    }
                }

                if (id != null) {
                    catalogueDatesController.moviesDatesAndTime(id, movieData, avaibleHour);
                }

            }catch (IOException e){
                logger.error(("error reading file: " + e.getMessage()));
            }
        }

    }
}
