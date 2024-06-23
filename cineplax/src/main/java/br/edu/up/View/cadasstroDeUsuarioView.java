package com.cinema.View;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.usuarioController;
import com.cinema.Model.Usuario;
import com.cinema.exception.ErroCadastroDeUsuario;




public class cadasstroDeUsuarioView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws Exception  {
     
      try {
        logger.info("Creating user");
        Usuario usuario = solcitarDadosUsuario();
        usuarioController.criarUsuario(usuario.getNome(), usuario.getCpf(), 
        usuario.getCelular(), usuario.getEmail(), usuario.getSenha());
      } catch (ErroCadastroDeUsuario e){
        logger.error(e.toString());
        System.out.println("Erro creatring User" + e.getMessage());
      }
      
    }

    
    public static Usuario  solcitarDadosUsuario(){
      logger.info("Coletando dados do usuário");

      System.out.println("Nome:");
      String nome = scanner.nextLine();

      System.out.println("CPF:");
      String cpf = scanner.nextLine();

      System.out.println("Celular:");
      String celular = scanner.nextLine();

      System.out.println("Email:");
      String email = scanner.nextLine();

      System.out.println("Senha:");
      String senha = scanner.nextLine();

      return new Usuario(nome, cpf, celular, email, senha);
    }
  }





