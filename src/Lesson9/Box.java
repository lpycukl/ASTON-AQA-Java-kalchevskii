package Lesson9;

import java.util.ArrayList;
import java.util.Objects;

public class Box {
    ArrayList<Fruit> fruits = new ArrayList<>();

    public Box() {
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(Fruit fruit) {
        if (fruits.size() == 0) {
            fruits.add(fruit);
        } else if (fruits.get(0).getName() == fruit.getName()) {
            fruits.add(fruit);
        } else {
            System.out.println("В этой коробке лежат другие фрукты");
        }
    }

    public void getWeiht() {
        if (fruits.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            double weight = fruits.get(0).getWeight() * fruits.size();
            System.out.println("Вес коробки: " + weight);
        }
    }

    public boolean compare(Box compareBox) {
        if (!fruits.get(0).getName().equals(compareBox.fruits.get(0).getName())) {
            return false;
        }
        if (!(fruits.size() == compareBox.fruits.size())) {
            return false;
        }
        return true;
    }

    public void teleportation(Box boxForTeleportation) {
        if (!fruits.get(0).getName().equals(boxForTeleportation.fruits.get(0).getName())) {
            System.out.println("в эту коробку нельзя персыпать эти фрукты");
        } else {
            boxForTeleportation.fruits.addAll(fruits);
            fruits.clear();
        }
    }

}
