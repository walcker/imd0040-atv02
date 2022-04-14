package circle;

public class Circle {

    float radius;

    Circle(float radius){
        this.radius = radius;
    }

    public void area(){
        System.out.println((Math.PI*Math.pow(radius,2)));
    }

    public void circumference(){
        System.out.println((2 * Math.PI * radius));
    }
}