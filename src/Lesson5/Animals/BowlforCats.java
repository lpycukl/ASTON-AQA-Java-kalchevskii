package Lesson5.Animals;

public class BowlforCats {
    private int countOfFood;

    public BowlforCats(int countOfFood) {
        this.countOfFood = countOfFood;
    }

    public int getCountOfFood() {
        return countOfFood;
    }

    public void setCountOfFood(int countOfFood) {
        this.countOfFood = countOfFood;
    }

    public void addFood(int countOfFood) {
        setCountOfFood(this.countOfFood + countOfFood);
    }
}
