package com.example.viacep.repository;

import com.example.viacep.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT e.cep from Endereco e ")
    List<String> findCep();

    Optional<Endereco> getByCep(String cep);

}
