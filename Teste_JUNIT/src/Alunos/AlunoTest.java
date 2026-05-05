package Alunos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    void deveCalcularMediaCorretamente(){
        Aluno aluno = new Aluno();
        double media = aluno.calcularMedia(8 , 6);

        assertEquals(7.0, media);
    }

    @Test
    void deveRetornarAprovado(){
        Aluno aluno = new Aluno();
        String resultado = aluno.verificarSitucao(7);

        assertEquals("Aprovado", resultado);
    }

    @Test
    void deveRetornarReprovado(){
        Aluno aluno = new Aluno();
        String resultado = aluno.verificarSitucao(5);

        assertEquals("Reprovado", resultado);
    }
}