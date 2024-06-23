package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Catalogue;

public class catalogueController {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static List<Catalogue> cartaz = new ArrayList<>();

    // funcao que recebe os paraemtro baseado no leitor de arquivos
    public static Catalogue movieCatalogue(String nome, String[] genero, String clasificacao, int hour, int minute){


        logger.info("Coletando dados do catalogo"); 

        /*aqui puxamos os parametros da funcao para o contrutor da classe de catalogos 
        que depois sera empurrado ao array de cartza na funcao fillMovieArray*/ 
        Catalogue catalogo = new Catalogue(nome, genero, clasificacao, hour, minute);

        //invoca as funcoes de validar e de prencher a array;
            fillMovieArray(catalogo);
    

        return catalogo;
    }

    public static void clearCartaz() {
        logger.info("Clearing catalog array");
        cartaz.clear();
    }

    //funcao para adicionar todas informacoes do catalogo a array de cartaz
    public static void fillMovieArray(Catalogue catologo){
        logger.info("Adding data of catalogue into array");
        cartaz.add(catologo);
    }

    //funcao para para invocar o catalogo na view
    public static List<Catalogue> getCartaz() {
        logger.info("Calling catalogue");
        return cartaz;
    }
}
