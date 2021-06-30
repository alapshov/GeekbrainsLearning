public class Cat extends Animal {

    public Cat(int runDistance, int sailDistance) {
        super.runDistance = runDistance;
        super.sailDistance = sailDistance;
    }

    @Override
    public void run() {
        if (super.runDistance > 200) {
            System.out.println("Мурзик не может пробежать больше 200 м.");
        } else
        System.out.printf("Мурзик пробежал %s м.\n", super.runDistance);
    }

    @Override
    public void sail() {
        System.out.println("Мурзик не умеет плавать");
    }
}
