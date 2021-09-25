import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 */

public class ArraysSwap {

    public <T> T[] swap(T[] arr) {
        T c = arr[0];
        arr[0] = arr[1];
        arr[1] = c;
        return arr;
    }

    public <T> ArrayList<T> castArrayToArraylist(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
