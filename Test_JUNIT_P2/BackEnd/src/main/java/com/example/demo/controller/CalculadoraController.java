package com.example.demo.controller;

import com.example.demo.model.Operacao;
import com.example.demo.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculadora")
@CrossOrigin(origins = "*")
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    @GetMapping("/calcular")
    public Operacao calcular(
            @RequestParam(required = false) Double n1,
            @RequestParam(required = false) Double n2,
            @RequestParam String op) {
        return service.calcular(n1, n2, op);
    }

    @GetMapping("/historico")
    public List<Operacao> getHistorico() {
        return service.listarHistorico();
    }

    @DeleteMapping("/historico")
    public void limparHistorico() {
        service.excluirHistorico();
    }
}
