package com.example.viacep.controller;

import com.example.viacep.domain.Endereco;
import com.example.viacep.service.EnderecoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("cep/{cep}")
    public ResponseEntity<Endereco> findCep(@PathVariable String cep) throws Exception {

        ResponseEntity<Endereco> endereco = enderecoService.getEndereco(cep);
        return ResponseEntity.ok().body(endereco).getBody();
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<Endereco>> getEnderecos(){

       List<Endereco> enderecos = enderecoService.listaEndereco();
       return ResponseEntity.ok().body(enderecos);
    }

    @GetMapping("/ceps")
    public ResponseEntity<List<String>> getCeps(){

        List<String> ceps = enderecoService.listaCep();
        return ResponseEntity.ok().body(ceps);
    }
}
