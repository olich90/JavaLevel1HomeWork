package homework7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик", 15),
                new Cat("Мурзик", 20),
                new Cat("Толстопуз", 35)
        };
        Bowl bowl = new Bowl();
        bowl.putFood(40);

        for (Cat cat : cats) {
            cat.eat(bowl);
            System.out.printf("Кот %s сыт? %b\n", cat.getName(), cat.isFull());
        }
    }
}