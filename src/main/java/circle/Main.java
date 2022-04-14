package circle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("Entre com o raio do circulo.");
        float radius = Float.parseFloat(scanner.next());

        Circle calc = new Circle(radius);
        calc.circumference();
        calc.area();
    }
}