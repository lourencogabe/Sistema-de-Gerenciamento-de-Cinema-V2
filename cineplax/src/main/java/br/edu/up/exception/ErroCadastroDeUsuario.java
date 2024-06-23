package com.cinema.exception;

public class ErroCadastroDeUsuario extends Exception {

  public ErroCadastroDeUsuario(String message){
    super(message);
  }

  public ErroCadastroDeUsuario(String message, Throwable cause){
    super(message, cause);
  }

@Override
public String toString() {
    return "Erro ao cadastrar um usuario: " + getMessage();
}

}
