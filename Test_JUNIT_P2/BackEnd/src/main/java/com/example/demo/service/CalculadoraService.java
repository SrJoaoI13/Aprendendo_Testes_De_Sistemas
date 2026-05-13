package com.example.demo.service;

import com.example.demo.model.Operacao;
import com.example.demo.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculadoraService {

    @Autowired
    private OperacaoRepository repository;

    public Operacao calcular(Double n1, Double n2, String operacao) {
        Double resultado = null;
        String erro = null;

        try {
            if (n1 == null || n2 == null) {
                erro = "Entrada inválida: números não podem ser nulos";
            } else {
                switch (operacao.toLowerCase()) {
                    case "soma":
                        resultado = n1 + n2;
                        break;
                    case "subtracao":
                        resultado = n1 - n2;
                        break;
                    case "multiplicacao":
                        resultado = n1 * n2;
                        break;
                    case "divisao":
                        if (n2 == 0) {
                            erro = "Erro: Divisão por zero";
                        } else {
                            resultado = n1 / n2;
                        }
                        break;
                    case "porcentagem":
                        resultado = (n1 * n2) / 100;
                        break;
                    case "potenciacao":
                        resultado = Math.pow(n1, n2);
                        break;
                    case "raiz":
                        if (n1 < 0) {
                            erro = "Erro: Raiz quadrada de número negativo";
                        } else {
                            resultado = Math.sqrt(n1);
                        }
                        break;
                    default:
                        erro = "Operação inválida";
                }
            }
        } catch (Exception e) {
            erro = "Erro ao realizar operação: " + e.getMessage();
        }

        Operacao op;
        if (erro != null) {
            op = new Operacao(n1, n2, operacao, erro, LocalDateTime.now());
        } else {
            op = new Operacao(n1, n2, operacao, resultado, LocalDateTime.now());
        }

        return repository.save(op);
    }

    public List<Operacao> listarHistorico() {
        return repository.findAll();
    }

    public void excluirHistorico() {
        repository.deleteAll();
    }
}
