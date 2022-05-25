package com.example.viacep.service;

import com.example.viacep.domain.Endereco;
import com.example.viacep.repository.EnderecoRepository;
import com.example.viacep.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ResponseEntity<Endereco> getEndereco(String cep) throws Exception {

        Constants constants = new Constants();
        String url = constants.url(cep);

        try {
            RestTemplate restTemplate = new RestTemplate();

            //Faz uma requisição GET na url e retorna uma resposta do tipo Endereco
            ResponseEntity<Endereco> respostaRequisicao = restTemplate.getForEntity(url, Endereco.class);

            Endereco endereco = new Endereco();

            endereco.setCep(respostaRequisicao.getBody().getCep());
            endereco.setLogradouro(respostaRequisicao.getBody().getLogradouro());
            endereco.setComplemento(respostaRequisicao.getBody().getComplemento());
            endereco.setBairro(respostaRequisicao.getBody().getBairro());
            endereco.setLocalidade(respostaRequisicao.getBody().getLocalidade());
            endereco.setUf(respostaRequisicao.getBody().getUf());
            endereco.setDdd(respostaRequisicao.getBody().getDdd());

            //Salva no banco de dados o objeto endereco
            enderecoRepository.save(endereco);

            return respostaRequisicao;

        } catch (RestClientException e) {
            throw new Exception(e.getMessage());
        }
    }
}
