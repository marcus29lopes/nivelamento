package com.teste4.demo.controller;

import com.teste4.demo.model.Operadora;
import com.teste4.demo.service.OperadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperadoraController {

    @Autowired
    private OperadoraService operadoraService;

    @GetMapping("/operadoras/buscar")
    public List<Operadora> buscarOperadoras(@RequestParam String nome) {
        return operadoraService.buscarPorNome(nome);
    }
}
