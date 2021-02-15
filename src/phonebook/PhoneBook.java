package phonebook;

import java.util.Scanner;

public class PhoneBook {


    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        Person.initBD();

        while (count < 1000) {
            System.out.print("""
                    Введите поисковое значение. 
                    На вход принимается Имя; Номер телефона; E-mail : 
                    """);
            String searchString = in.nextLine();
            while (!nullStringChecker(searchString)) {
                searchString = in.nextLine();
            }
            Person.findPerson(searchString);
            phoneBookExit(in);
            count++;
        }

    }
    public static void phoneBookExit(Scanner reader) {
        System.out.println("""
                                
                Для выхода напечатайте выход. 
                Для продолжения нажмите Enter.
                """);
        String line = reader.nextLine();
        if ("Выход".equalsIgnoreCase(line)) {
            System.out.println("Вы вышли из телефонной книги. ");
            System.exit(0);
        }
    }

    public static boolean nullStringChecker(String string) {
        boolean flag = true;
        if ("".equals(string)) {
            System.out.println("Вы ничего не ввели. Попробуйте снова...");
            flag = false;
        }
        return flag;
    }
}

class Person {
    private final String name;
    private final String phone;
    private final String email;
    private static final Person[] persons = new Person[10];

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }

    public static void initBD() {
        persons[0] = new Person("Юля", "89210000000", "Julia@yandex.com");
        persons[1] = new Person("Сергей", "777777", "borya@yandex.com");
        persons[2] = new Person("Друган", "23566777", "univer@yandex.com");
        persons[3] = new Person("EvilBoss", "456546546", "boss@yandex.com");
        persons[4] = new Person("Anna", "+79216661666", "mylove@yandex.com");
    }

    public String toString() {
        return "\n\nName: " + this.getName() + "\nPhone number: " + this.getPhone() + "\nEmail: " +
                this.getEmail();
    }

    // поиск человека
    public static void findPerson(String searchString) {
        System.out.println(findEngine(searchString, persons));
    }

    public static String findEngine(String searchString, Person[] persons) {
        for (Person person : persons) {
            if (person == null) continue;
            if (person.getName().equals(searchString)) {
                System.out.println(person);
            }
            if (person.getPhone().equals(searchString)) {
                System.out.println(person);
            }
            if (person.getEmail().equals(searchString)) {
                System.out.println(person);
            }
        }
        System.out.println("Такого контакта не существует!");
        return "";
    }


}

/*
 ДЗ
Дописать методы поиска для телефона и почты
Сделать так же выход
Продумать обработку исключений для поиска по пустым значениям
*/
