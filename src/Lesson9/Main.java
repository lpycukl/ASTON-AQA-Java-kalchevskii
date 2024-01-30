package Lesson9;

public class Main {

    public static void main(String[] args) {

        Box boxApples1 = new Box();
        Box boxOranges = new Box();

        boxApples1.addFruit(new Apple());
        boxApples1.addFruit(new Apple());
        boxApples1.addFruit(new Apple());
        boxApples1.addFruit(new Orange()); //В этой коробке лежат другие фрукты
        boxApples1.getWeiht(); //Вес коробки: 3.0

        for (int i = 0; i < 3; i++) {
            boxOranges.addFruit(new Orange());
        }
        boxOranges.getWeiht(); //Вес коробки: 4.5


        Box boxApples2 = new Box();
        boxApples2.addFruit(new Apple());
        boxApples2.addFruit(new Apple());
        boxApples2.addFruit(new Apple());

        System.out.println(boxApples1.compare(boxOranges)); //false
        System.out.println(boxApples1.compare(boxApples2)); //true

        boxApples1.teleportation(boxApples2);
        boxApples1.getWeiht();//Коробка пуста
        boxApples2.getWeiht();//Вес коробки: 6.0

        boxApples2.teleportation(boxOranges);//в эту коробку нельзя персыпать эти фрукты


    }


}
