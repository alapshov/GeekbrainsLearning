public class Main {
    public static void main(String[] args) {
        Human human = new Human(30, 250);
        Robot robot = new Robot(150, 500);
        Cat cat = new Cat(50, 200);

        Doing[] doings = new Doing[]{
                new Human(30, 250),
                new Cat(50, 200),
                new Robot(150, 500)
        };

        Actions[] actions = new Actions[]{
                new Wall(),
                new Treadmill()
        };

        for (Doing doing : doings) {
            for (Actions action : actions) {
                if(!action.action(doing)){
                  break;
                };
            }

        }

    }
}
