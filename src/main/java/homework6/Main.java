package homework6;

import homework6.Animal.*;

public class Main {
    public static void main(String[] args) {
        int len = 10; // 600
        Animal[] animalsArr = {
                new Cat("Васька"),
                new Cat("Семен"),
                new Dog("Барбос"),
                new Dog("Тузик"),
                new Dog("Шарик"),
                new Animal("Чебурашка")
        };

        int cntCat = 0, cntDog = 0, cntAnimal = 0;
        for (Animal animal : animalsArr) {
            animal.run(len);
            animal.swim(len);
            //4. * Добавить подсчет созданных котов, собак и животных.
            if (animal instanceof Cat) cntCat++;
            if (animal instanceof Dog) cntDog++;
            cntAnimal++;
        }
        System.out.println("-------------------------");
        System.out.println("Котов создано: " + cntCat);
        System.out.println("Собак создано: " + cntDog);
        System.out.println("Непонятных животных создано: " + (cntAnimal - cntCat - cntDog));
        System.out.println("Всего животных создано: " + cntAnimal);
    }
}