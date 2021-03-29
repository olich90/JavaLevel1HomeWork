package homework6.Animal;

// 1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    //3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
    @Override
    public void run(int len) {
        int runLimit = 200;
        if (len > 0 && len <= runLimit)
            System.out.println(name + " пробежал " + len + " м.");
        else
            System.out.println("Коты, а в частности " + name + ", не хотят бегать на расстояние более " + runLimit + " м.");
    }

    @Override
    public void swim(int len) {
        System.out.println(name + " не умеет плавать.");
    }
}
