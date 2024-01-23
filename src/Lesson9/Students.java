package Lesson9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Students {

    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Sex.MAN),
                new Student("Максим", 20, Sex.MAN),
                new Student("Екатерина", 20, Sex.WOMAN),
                new Student("Михаил", 28, Sex.MAN)
        );
        AtomicInteger manAge = new AtomicInteger();
        int maleCounter = (int) students.stream().filter(student -> student.getGender().equals(Sex.MAN)).count();
        students.stream().filter(student -> student.getGender().equals(Sex.MAN)).forEach(student -> manAge.addAndGet(student.getAge()));
        System.out.println("средний возраст мужчин " + manAge.get() / maleCounter);

        System.out.print("Повестка грозит следующим: ");
        students.stream().filter(student -> student.getGender().equals(Sex.MAN) && student.getAge() >= 18 && student.getAge() <= 27).forEach(s -> System.out.print(s.getName() + " "));
        System.out.println();
    }

    private enum Sex {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Sex gender;

        public Student(String name, Integer age, Sex gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getGender() {
            return gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}
