package Lesson5.Animals;

public class Cat extends Animal {
    static int counterCats;
    boolean satiety = false;


    public Cat(String name) {
        super(name);
        runMax = 200;
        swimMax = 0;
        counterCats++;
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
        System.out.println("всего котов: " + counterCats);
    }

    public void eat(BowlforCats bowl, int howMuchFood) {
        if (howMuchFood > bowl.getCountOfFood()) {
            System.out.println(name + " не смог поесть, т.к. в миске мало еды");
        } else {
            satiety = true;
            bowl.setCountOfFood(bowl.getCountOfFood() - howMuchFood);
            System.out.println(name + " наелся");
        }
    }

    public void areYouHungry() {
        if (satiety) System.out.println(name + " сыт");
        else System.out.println(name + " остался голодным");
    }
}
