package com.teste4.demo.service;

import com.teste4.demo.model.Operadora;
import com.teste4.demo.repository.OperadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadoraService {

    @Autowired
    private OperadoraRepository operadoraRepository;

    public List<Operadora> buscarPorNome(String nome) {
        return operadoraRepository.findByNomeContainingIgnoreCase(nome);
    }
}
