import java.lang.reflect.Array;

public class ArrayDepositor {
    String[][] strings;

    public void putArray(String[][] strings) {
        this.strings = strings;
        int result = 0;
        if (strings.length <= 4) {
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings.length; j++) {
                    try {
                        result += Integer.parseInt(this.strings[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Передан не верный формат данных. Требуется целочисленный тип, получен символьный.", i, j);
                    }

                }
            }
            System.out.println(result);
        } else throw new MySizeArrayException("Превышена размерность массива.");


    }

}
