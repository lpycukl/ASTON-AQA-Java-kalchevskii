package Lesson5.Figures;

public class Square extends Figure implements Calculatable {
    int a;


    public Square(int a) {
        this.a = a;
    }

    @Override
    public double perimeter() {
        return a * 4;
    }

    @Override
    public double area() {
        return a * a;
    }
}
