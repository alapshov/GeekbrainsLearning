public class Cat implements Doing {
    private int jumpHeight;
    private int distance;

    public Cat(int jumpHeight, int distance) {
        this.jumpHeight = jumpHeight;
        this.distance = distance;
    }

    public int jump() {
        System.out.printf("Кот прыгнул на: %d см. ", jumpHeight);
        return jumpHeight;
    }

    public int run() {
        System.out.printf("Кот пробежал: %d м. ", distance);
        return distance;
    }
}
