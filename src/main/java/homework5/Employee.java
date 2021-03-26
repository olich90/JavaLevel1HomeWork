package homework5;

public class Employee {
    // 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    private int id, salary, age;
    private String fullName, position, eMail, phoneNumber;

    //2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(int id, String fullName, String position, String eMail, String phoneNumber, int salary, int age) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void printEmployee() {
        System.out.printf("Сотрудник номер %d, ФИО: %s, должность: %s, email: %s, телефон: %s, возраст: %d\n", id, fullName, position, eMail, phoneNumber, age);
    }

    // Вернем возраст через getter (для задания 5)
    public int getAge() {
        return age;
    }
}
