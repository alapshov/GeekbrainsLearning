public class Bowl {
    private int foodAmount;

    public void putFood(int foodAmount) {
        this.foodAmount += foodAmount;
    }

    public void decreaseFood(int foodAmount) {
        if (this.foodAmount >= foodAmount) {
            this.foodAmount -= foodAmount;
        } else
            System.out.println("Еды не хватает");

    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
