package Lesson5.Figures;

public class Circle extends Figure implements Calculatable{
    int radius;



    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return radius*2*3.14;
    }

    @Override
    public double area() {
        return radius*radius*3.14;
    }
}
