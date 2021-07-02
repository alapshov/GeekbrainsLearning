public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= appetite){
            bowl.decreaseFood(this.appetite);
            System.out.printf("Кот %s съел немного еды: %d\n", this.name, this.appetite);
            satiety = true;
        } else System.out.printf("Коту %s не хватило еды\n", this.name);
        System.out.printf("Сытость кота: %s\n", satiety);
    }

}
