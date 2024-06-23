package com.cinema.Model;

public  class Usuario  {
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String senha;

    public Usuario() {}


    public Usuario(String nome) {
        this.nome = nome;
    }


    public Usuario(String nome, String cpf, String celular, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
    }


    //Construtor para reealizacao de login
    
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    //Getters

    public String getNome() {
        return nome;
    }


    public String getCpf() {
        return cpf;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
        
    }

   //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + ", email=" + email + ", senha="
                + senha + ";";
    }



}
