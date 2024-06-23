package com.cinema.Model;

import java.util.UUID;

public class login extends Usuario{
    
    private UUID key;

    public login(UUID key) {
        this.key = key;
    }




    public login(String senha) {
        super(senha);
    }




    public login(String email, String senha) {
        super(email, senha);
       
    }


     //Getters
        public UUID getKey() {
            return key;
        }


}
