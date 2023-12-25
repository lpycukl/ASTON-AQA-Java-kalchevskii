package Lesson4;

public class Person {
    String firstNameSecondNameSurname;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int yearsOld;

    public Person(String firstNameSecondNameSurname, String position, String email, String phoneNumber, int salary, int yearsOld) {
        this.firstNameSecondNameSurname = firstNameSecondNameSurname;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.yearsOld = yearsOld;
    }

    public void printInformation() {
        System.out.println("ФИО: " + firstNameSecondNameSurname);
        System.out.println("Должность: " + position);
        System.out.println("EMAIL: " + email);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + yearsOld);
    }
}
