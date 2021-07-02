public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 10);
        Cat cat1 = new Cat("Murzik", 20);
        Bowl bowl = new Bowl();
        bowl.putFood(40);

//        System.out.printf("В миске %d еды \n", bowl.getFoodAmount());
//        cat.eat(bowl);
//        System.out.printf("В миске %d еды \n", bowl.getFoodAmount());
//        cat1.eat(bowl);
//        System.out.printf("В миске %d еды \n", bowl.getFoodAmount());

        Cat[] catArray = new Cat[]{
                new Cat("Fillya", 20),
                new Cat("Tishka", 60),
                new Cat("Chernysh", 30),
                new Cat("Murka", 20),
                new Cat("Motya", 10)
        };
        Bowl bowl2 = new Bowl();
        bowl2.putFood(70);
        for (Cat cat3 : catArray) {
            cat3.eat(bowl2);
            System.out.printf("В миске %d еды \n", bowl2.getFoodAmount());
        }

    }
}
