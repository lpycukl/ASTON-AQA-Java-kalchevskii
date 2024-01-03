package Lesson5.Animals;

public abstract class Animal {
    String name;
    int runMax;
    int swimMax;
    static int counterAnimals;

    public Animal(String name) {
        this.name = name;
        counterAnimals++;
    }

    public void run(int meters) {
        if (meters > runMax) System.out.println(name + " не может столько бегать");
        else System.out.println(name + " пробежал " + meters + " м.");
    }

    public void swim(int meters) {
        if (meters > swimMax) System.out.println(name + " не может столько плыть");
        else System.out.println(name + " проплыл " + meters + " м.");
    }

    public static void checkCount() {
        System.out.println("всего животных: " + counterAnimals);
    }
}
