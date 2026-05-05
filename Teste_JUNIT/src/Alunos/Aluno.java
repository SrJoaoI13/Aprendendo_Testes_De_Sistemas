package Alunos;

public class Aluno {
     public  double calcularMedia(double nota1, double nota2){
         return  (nota1 + nota2 / 2);
     }

     public String verificarSitucao(double media){
         if (media >= 7) {
             return "Aprovado";
         }else {
             return "Reprovado";
         }
     }
}
