package Lesson5.Figures;

public class Rectangle extends Figure implements Calculatable {
    int a;
    int b;
    int c;

    public Rectangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        int p = (a + b + c) / 2;
        return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));

    }
}
