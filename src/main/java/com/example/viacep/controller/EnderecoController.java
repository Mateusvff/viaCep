package com.example.viacep.controller;

import com.example.viacep.domain.Endereco;
import com.example.viacep.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("cep/{cep}")
    public ResponseEntity<Endereco> findCep(@PathVariable String cep) throws Exception {

        ResponseEntity<Endereco> endereco = enderecoService.getEndereco(cep);
        return ResponseEntity.ok().body(endereco).getBody();
    }
}
