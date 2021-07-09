public class Human implements Doing {
    private int jumpHeight;
    private int distance;

    public Human(int jumpHeight, int distance) {
        this.jumpHeight = jumpHeight;
        this.distance = distance;
    }

    public int jump() {
        System.out.printf("Человек прыгнул на: %d см. ", jumpHeight);
        return jumpHeight;
    }

    public int run() {
        System.out.printf("Человек пробежал: %d м. ", distance);
        return distance;
    }
}
