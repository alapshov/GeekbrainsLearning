public class AnimalUtils {
    public static void countAnimal(Animal[] animals) {
        int countDog = 0;
        int countCat = 0;
        for (Animal animal : animals) {
            if(animal.getClass() == Cat.class){
                animal.run();
                animal.sail();
                countCat++;
            } else {
                animal.run();
                animal.sail();
                countDog++;
            }
        }
        System.out.printf("Собак создано %d шт. || Котов создано %d шт.", countDog, countCat);
    }
}
