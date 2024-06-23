package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.movieDates;

public class catalogueDatesController {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static List<movieDates> datesCartaz = new ArrayList<>();


    public static movieDates moviesDatesAndTime(String id, String[] datas, String[] movieDuration){

        logger.info("Calling catalogue method to display movie catalogue");
        movieDates datesAndTime = new movieDates(id, movieDuration, datas);

     
        fillMovieDataAndTime(datesAndTime);
        return datesAndTime;


       
    }


    private static void fillMovieDataAndTime(movieDates datesEtime){
        logger.info("Filling array datesCartaz with thge data");
            datesCartaz.add(datesEtime);
    }


    public static List<movieDates> getMovieDatesAndTime(){
        logger.info("Retriving data from the array cartaz");
        return datesCartaz;
        
    }

}
