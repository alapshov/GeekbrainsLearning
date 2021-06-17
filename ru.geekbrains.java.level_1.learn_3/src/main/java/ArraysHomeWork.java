import java.util.Arrays;

public class ArraysHomeWork {

    public static void main(String[] args) {

        arrayReplacer();
        arrayPlaceholder();
        arrayDiagonal();
        System.out.println(Arrays.toString(initialValueArray(10, 33)));
        arrayMinMax();
        System.out.println(checkBalance(new int[]{1, 2, 3, 5, 1}));
    }

    /***
     * Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0
     */
    public static void arrayReplacer() {
        int[] arrayInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Начальный массив: " + Arrays.toString(arrayInt));
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == 1) {
                arrayInt[i] = 0;
            } else {
                arrayInt[i] = 1;
            }
        }
        System.out.println("Измененный массив: " + Arrays.toString(arrayInt));
    }

    /***
     * Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     */
    public static void arrayPlaceholder() {
        int[] arrayInt = new int[100];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = i + 1;
        }
        System.out.println(Arrays.toString(arrayInt));
    }

    /***
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     */
    public static void arrayDiagonal() {
        int[][] arrayInt = new int[6][6];
        for (int i = 0, j = arrayInt.length - 1; i < arrayInt.length && j >= 0; i++, j--) {
            arrayInt[i][i] = 1;
            arrayInt[i][j] = 1;
            System.out.println(Arrays.toString(arrayInt[i]));
        }
    }

    /***
     * Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
     */
    public static int[] initialValueArray(int len, int initialValue) {
        int[] arrayInt = new int[len];
        for (int i = 0; i < len; i++) {
            arrayInt[i] = initialValue;
        }
        return arrayInt;
    }

    /***
     * * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
     */
    public static void arrayMinMax() {
        int[] arrayInt = {12, 1, -3, 5, 7, 3, 5, 9, 6, 0, 4, 9};
        int max = Arrays.stream(arrayInt).max().getAsInt();
        int min = Arrays.stream(arrayInt).min().getAsInt();
        System.out.println("Максимальное значение массива: " + max);
        System.out.println("Минимальное значение массива: " + min);

    }

    /***
     * ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * **Примеры:
     * checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     * checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     *
     * граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
     */
    public static boolean checkBalance(int[] arrayInt) {
        boolean flag = false;
        int arrSum = 0;
        for (int item : arrayInt) {
            arrSum += item;
        }
        int leftSum = 0;
        for (int i = 0; i < arrayInt.length; i++) {
           leftSum += arrayInt[i];
           if(leftSum == arrSum - leftSum){
               flag = true;
           }
        }
        return flag;
    }

    /***
     * *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
     * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */

    public static void displace(int[] arrInt, int n){
        // Это задание не осилил
    }

}
