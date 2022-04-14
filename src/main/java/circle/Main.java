package circle;

import java.util.Scanner; // Para usar a funcao scanner e pedir o raio ao usuario

public class Main {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in); // chama a funcao scanner
        System.out.println("Entre com o raio do circulo.");
        float radius = Float.parseFloat(scanner.next()); //espera o usuario digitar o raio e coloca na variaval

        Circle calc = new Circle(radius); //envia o raio para a classe Circle
        calc.circumference(); //chama metodo para calcular a circunferencia
        calc.area(); //chama metodo para calcular a area
    }
}