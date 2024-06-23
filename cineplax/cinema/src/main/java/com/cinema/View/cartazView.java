package com.cinema.View;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.catalogueController;
import com.cinema.Model.Catalogue;
import com.cinema.functions.readMovieTable;



public class cartazView {

    private static final Logger logger = LogManager.getLogger(Main.class);
      public static void main(String[] args) throws Exception  {
     
        //invocacao do metodo de leitura do catalogo
        readMovieTable.readMovieCalatologue();
        //invocacao do metodo de preenchimento da array de controller retornando o getCartaz
         List<Catalogue> catalogList = catalogueController.getCartaz();
      

         //foreachLoop para visualizar o filme
         logger.info("Reading catalogue Array");
         for (Catalogue catalog : catalogList) {
            System.out.println("Nome: " + catalog.getNome());
            String[] generos = catalog.getGenero();
            for (int i = 0; i < generos.length; i++) {
                System.out.print(generos[i]);
                if (i < generos.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("Classificacao: " + catalog.getClassificacao());
            System.out.println("Duracao: " + catalog.getHora() + "h " + catalog.getMinuto() + "min");
            System.out.println("----------------------");
        }

        logger.info("Reading catalogue array complete");
         
       
    }

  



}
