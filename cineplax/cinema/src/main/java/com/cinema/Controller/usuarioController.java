package com.cinema.Controller;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Usuario;
import com.cinema.exception.ErroCadastroDeUsuario;
import com.cinema.exception.ErroCreatingDatabase;
import com.cinema.functions.creatUserDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class usuarioController {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static Map<UUID, Usuario> cadastroDeUsuario = new HashMap<>();

    public static Usuario criarUsuario(String nome, String cpf, String celular, String email, String senha) throws Exception {
        logger.info("Coletando dados do usuário");

        Usuario userAccount = new Usuario(nome, cpf, celular, email, senha);

        try {
            validarDadosUsuario(userAccount);
            cadastrarUsuario(userAccount);
            criarTabelaUsuario();
        } catch (ErroCreatingDatabase | ErroCadastroDeUsuario e) {
            logger.error("Erro ao cadastrar usuário: " + e.getMessage());
            throw e;
        }

        return userAccount;
    }

    private static void validarDadosUsuario(Usuario usuario) throws ErroCadastroDeUsuario {
        logger.info("validating user");
        if (usuario.getNome() == null || usuario.getCpf() == null || usuario.getCelular() == null ||
                usuario.getEmail() == null || usuario.getSenha() == null) {
                logger.error("error validating user data incomplete data");
            throw new ErroCadastroDeUsuario("Erro ao cadastrar usuário: dados incompletos");
        }
    }

    private static void cadastrarUsuario(Usuario usuario) {
        UUID userId = UUID.randomUUID();
        cadastroDeUsuario.put(userId, usuario);
        logger.info("Usuário cadastrado com sucesso: Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail()); 
    }

    private static void criarTabelaUsuario() throws ErroCreatingDatabase {
        creatUserDatabase insertUser = new creatUserDatabase();
        insertUser.creatUser(cadastroDeUsuario);
        cadastroDeUsuario.clear();
        logger.info("Creating user table");
    }
}
