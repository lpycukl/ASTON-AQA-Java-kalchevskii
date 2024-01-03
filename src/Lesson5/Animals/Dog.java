package Lesson5.Animals;

public class Dog extends Animal {
    static int counterDogs;

    public Dog(String name) {
        super(name);
        runMax = 500;
        swimMax = 10;
        counterDogs++;
    }

    @Override
    public void run(int meters) {
        super.run(meters);
    }

    @Override
    public void swim(int meters) {
        super.swim(meters);
    }

    public static void checkCount() {
        System.out.println("всего собак: " + counterDogs);
    }
}
