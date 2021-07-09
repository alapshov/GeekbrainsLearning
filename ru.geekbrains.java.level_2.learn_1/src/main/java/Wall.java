public class Wall implements Actions {
    private static final int height = 50;

    public boolean action(Doing doing) {
        if (doing.jump() >= height) {
            System.out.println("Вершина взята");
            return true;
        } else System.out.println("Перепрыгнуть не удалось");
        return false;
    }
}
