package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double numero1;
    private Double numero2;
    private String operacao;
    private Double resultado;
    private String erro;
    private LocalDateTime dataHora;

    public Operacao(Double numero1, Double numero2, String operacao, Double resultado, LocalDateTime dataHora) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
        this.resultado = resultado;
        this.dataHora = dataHora;
    }

    public Operacao(Double numero1, Double numero2, String operacao, String erro, LocalDateTime dataHora) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
        this.erro = erro;
        this.dataHora = dataHora;
    }
}
