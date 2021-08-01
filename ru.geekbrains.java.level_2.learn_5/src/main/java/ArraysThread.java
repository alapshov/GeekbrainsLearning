import java.util.Arrays;

public class ArraysThread {

    static final int size = 100000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    ;
    static long a;

    public static void main(String[] args) {
        fillArray();
        calculateArray(arr, size);
        System.out.println("Время выполнения в однопоточном режиме: " + (System.currentTimeMillis() - a));
        calculateArrayThread();
        System.out.println("Время выполнения в многопоточном режиме: " + (System.currentTimeMillis() - a));


    }

    public static void fillArray() {
        Arrays.fill(arr, 1);
        a = System.currentTimeMillis();
        int i = 1;
    }

    public static void calculateArray(float[] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void calculateArrayThread() {
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Thread thread1 = new Thread(() -> calculateArray(arr1, h));
        Thread thread2 = new Thread(() -> calculateArray(arr2, h));
        thread1.start();
        thread2.start();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
    }


}
