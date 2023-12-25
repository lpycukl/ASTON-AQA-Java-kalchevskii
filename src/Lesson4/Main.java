package Lesson4;

public class Main {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Ivanov Ivan Ivanovich", "Engineer123",
                "ivivan123@mailbox.com", "892311232312", 22222, 22);
        persArray[2] = new Person("Ivan Ivanov", "SuperEngineer",
                "ivivanko@mailbox.com", "88005553535", 300000, 303);
        persArray[3] = new Person("Ivanova Ivanko", "BOSS",
                "boss@mailbox.com", "892312312", 123456, 40);
        persArray[4] = new Person("Super chel", "Ivan",
                "superchel@mailbox.com", "89231231211", 300200, 20);
    }
}
