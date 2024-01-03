package Lesson5.Animals;

import Lesson5.Animals.Animal;
import Lesson5.Animals.BowlforCats;
import Lesson5.Animals.Cat;
import Lesson5.Animals.Dog;

public class Tests {
    public static void main(String[] args) {

        Cat cat1 = new Cat("catik1");
        Dog dog1 = new Dog("dogik1");

        Animal.checkCount();
        Cat.checkCount();
        Dog.checkCount();

        Cat cat2 = new Cat("catik2");
        Cat cat3 = new Cat("catik3");

        Animal.checkCount();
        Cat.checkCount();
        Dog.checkCount();

        System.out.println("");

        cat1.run(100);
        cat1.run(500);
        cat1.swim(100);
        dog1.run(500);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(50);

        System.out.println("");

        BowlforCats bowl = new BowlforCats(20);

        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats
        ) {
            cat.eat(bowl, 7);
        }

        for (Cat cat : cats
        ) {
            cat.areYouHungry();
        }

        bowl.addFood(15);
        cat3.eat(bowl, 10);
        cat3.areYouHungry();
    }
}
