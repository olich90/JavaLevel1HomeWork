package homework6.Animal;

public class Animal {
    protected String name;

    public Animal(String name) { this.name = name; }

    //2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
    // Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    public void run(int len) {
        System.out.println(name + " пробежал " + len + " м."); // для не котов и не собак
    }

    public void swim(int len) {
        System.out.println(name + " проплыл " + len + " м."); // для не котов и не собак
    }
}