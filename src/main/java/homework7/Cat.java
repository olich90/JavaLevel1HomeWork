package homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Bowl bowl) {
        if (bowl.decrFood(appetite) == -1) {
            System.out.printf("Кот %s не поел, для него в миске недостаточно еды. Его аппетит = %d, остаток еды в миске = %d\n", this.name, this.appetite, bowl.getFoodAmount());
            return;
        }
        isFull = true;
        System.out.printf("Кот %s съел %d единиц еды, остаток еды в миске = %d\n", this.name, this.appetite, bowl.getFoodAmount());
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return isFull;
    }
}
