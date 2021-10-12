import java.util.Arrays;

public class ArraysConverter {

    public int[] arrayConverting(int[] arrayInt) {
        int position = 0;
        int positionCounter = 0;
        int[] arrayResult;
        for (int i : arrayInt) {
            positionCounter++;
            if (i == 4) {
                position = positionCounter;
            }
        }
        arrayResult = Arrays.copyOfRange(arrayInt, position, arrayInt.length);

        if (position == 0)
            throw new RuntimeException();
        return arrayResult;
    }

    public boolean arrayChecked(int[] arrayInt){
        boolean flag = false;
        for (int i : arrayInt) {
            if (i == 4 || i == 1) {
                flag = true;
            }
        }
        return flag;
    }
}
