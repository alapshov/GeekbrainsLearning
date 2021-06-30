public class Dog extends Animal{

    public Dog(int runDistance, int sailDistance) {
        super.runDistance = runDistance;
        super.sailDistance = sailDistance;
    }

    @Override
    public void run(){
         if(super.runDistance > 500){
             System.out.println("Бобик не может пробежать больше 500 м.");
         } else
        System.out.printf("Бобик пробежал %s м.\n", super.runDistance);
    }

    @Override
    public void sail(){
        if(super.sailDistance > 10){
            System.out.println("Бобик не может проплыть болше 10 метров");
        } else
        System.out.printf("Бобик проплыл %s м.\n", super.sailDistance);
    }
}
