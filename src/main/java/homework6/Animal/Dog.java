package homework6.Animal;

// 1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    //3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
    @Override
    public void run(int len) {
        int runLimit = 500;
        if (len > 0 && len <= runLimit)
            System.out.println(name + " пробежал " + len + " м.");
        else
            System.out.println("Собаки, а в частности " + name + ", не хотят бегать на расстояние более " + runLimit + " м.");
    }

    @Override
    public void swim(int len) {
        int swimLimit = 10;
        if (len > 0 && len <= swimLimit)
            System.out.println(name + " проплыл " + len + " м.");
        else
            System.out.println("Собаки, а в частности " + name + ", не хотят плыть на расстояние более " + swimLimit + " м.");
    }
}
