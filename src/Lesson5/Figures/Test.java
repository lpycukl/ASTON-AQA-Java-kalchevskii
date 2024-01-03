package Lesson5.Figures;

public class Test {

    public static void main(String[] args) {

        Circle circle = new Circle(5);
        circle.setColorBorder("blue");
        circle.setColorFilling("red");

        Square square = new Square(5);
        square.setColorBorder("blue");
        square.setColorFilling("red");

        Rectangle rectangle = new Rectangle(6, 8, 10);
        rectangle.setColorBorder("green");
        rectangle.setColorFilling("white");

        System.out.println("Круг");
        System.out.println(circle.perimeter());
        System.out.println(circle.area());
        System.out.println(circle.getColorFilling());
        System.out.println(circle.getColorBorder());

        System.out.println("Квадрат");
        System.out.println(square.perimeter());
        System.out.println(square.area());
        System.out.println(square.getColorFilling());
        System.out.println(square.getColorBorder());

        System.out.println("Тругольник");
        System.out.println(rectangle.perimeter());
        System.out.println(rectangle.area());
        System.out.println(rectangle.getColorFilling());
        System.out.println(rectangle.getColorBorder());
    }

}
