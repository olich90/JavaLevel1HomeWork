package homework5;

public class HomeWork5 {
    public static void main(String[] args) {
        //4. Создать массив из 5 сотрудников.
        Employee[] eArray = new Employee[5];
        eArray[0] = new Employee(1, "Иванов Иван Иванович", "аналитик", "ivanovii@mail.ru", "+79991234567", 1000, 25);
        eArray[1] = new Employee(2, "Смирнов Сергей Сергеевич", "разработчик", "smirnovss@mail.ru", "+79981234567", 1500, 26);
        eArray[2] = new Employee(3, "Петров Пётр Петрович", "тестировщик", "petrovpp@mail.ru", "+79971234567", 1000, 40);
        eArray[3] = new Employee(4, "Николаев Николай Николаевич", "HR", "nikolaevnn@mail.ru", "+79961234567", 800, 42);
        eArray[4] = new Employee(5, "Егоров Егор Егорович", "уборщик", "-", "+79951234567", 1500, 41);

        // 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (int i = 0; i < eArray.length; i++) {
            if (eArray[i].getAge() > 40)
                eArray[i].printEmployee();
        }
    }
}