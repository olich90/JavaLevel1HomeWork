package homework7;

public class Bowl {
    private int foodAmount;

    public void putFood(int foodAmount) {
        this.foodAmount += foodAmount;
        System.out.println("Количество еды в миске = " + foodAmount);
    }

    public int decrFood(int foodAmount) {
        if (this.foodAmount < foodAmount) return -1;
        this.foodAmount -= foodAmount;
        return 0;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}