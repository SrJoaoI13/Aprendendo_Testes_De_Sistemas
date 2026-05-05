package Calculadora;

public class Divisao {
    public double calcularD(double a, double b){
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        return (a / b);
    }
}