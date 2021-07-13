public class Treadmill implements Actions {
    private static final int length = 250;

    public boolean action(Doing doing) {
        if (doing.run() >= length) {
            System.out.println("Дистанция пройдена");
            return true;
        } else System.out.println("Дистанция не пройдена");
        return false;
    }
}
