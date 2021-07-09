public class Robot implements Doing {
    private int jumpHeight;
    private int distance;

    public Robot(int jumpHeight, int distance) {
        this.jumpHeight = jumpHeight;
        this.distance = distance;
    }

    public int jump() {
        System.out.printf("Робот прыгнул на: %d см. ", jumpHeight);
        return jumpHeight;
    }

    public int run() {
        System.out.printf("Робот пробежал: %d м. ", distance);
        return distance;
    }
}
