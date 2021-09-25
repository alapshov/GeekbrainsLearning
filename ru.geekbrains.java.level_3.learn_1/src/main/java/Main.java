import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strArr = new String[] {
                "1","2"
        };

        Integer[] intArr = new Integer[] {
                1,2
        };
        ArraysSwap arraysSwap1 = new ArraysSwap();
        ArraysSwap arraysSwap2 = new ArraysSwap();

        System.out.println("------========= 1 пункт задания =========------");
        System.out.println("Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)");

        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(intArr));

        arraysSwap1.swap(strArr);
        arraysSwap2.swap(intArr);

        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(intArr));

        System.out.println("------========= 2 пункт задания =========------");
        System.out.println("Написать метод, который преобразует массив в ArrayList");

        System.out.println(arraysSwap1.castArrayToArraylist(strArr));
        System.out.println(arraysSwap2.castArrayToArraylist(intArr));

    }
}
