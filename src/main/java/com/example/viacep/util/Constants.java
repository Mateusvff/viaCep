package com.example.viacep.util;

public class Constants {

    public String url(String cep){
        return "https://viacep.com.br/ws/" + cep + "/json/";
    }
}
