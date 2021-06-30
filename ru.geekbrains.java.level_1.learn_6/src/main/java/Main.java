public class Main {
    public static void main(String[] args) {
        Animal animalCat = new Cat(200, 10);
        Animal animalDog = new Dog(500, 10);
        animalCat.run();
        animalCat.sail();
        animalDog.run();
        animalDog.sail();
        Animal[] animals = new Animal[]{
                new Cat(200, 10),
                new Cat(300, 15),
                new Cat(100, 11),
                new Dog(500, 10),
                new Dog(600, 15),
                new Dog(300, 7),
                new Dog(700, 17),
                new Dog(250, 9)
        };
        AnimalUtils.countAnimal(animals);
    }
}
