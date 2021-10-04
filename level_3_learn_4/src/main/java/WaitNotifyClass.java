public class WaitNotifyClass {
    private Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyClass waitNotifyClass = new WaitNotifyClass();

        Thread thread1 = new Thread(()-> waitNotifyClass.printA());
        Thread thread2 = new Thread(()->waitNotifyClass.printB());
        thread1.start();
        thread2.start();
    }

    public void printA(){
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentLetter != 'A'){
                        mon.wait();
                    }
                    System.out.println("A");
                    currentLetter = 'B';
                    mon.notify();
                }

            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentLetter != 'B'){
                        mon.wait();
                    }
                    System.out.println("B");
                    currentLetter = 'A';
                    mon.notify();
                }

            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
