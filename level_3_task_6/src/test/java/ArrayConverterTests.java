import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayConverterTests {

    public static Stream<Arguments> dataForArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{2, 3, 5, 6, 7, 8}));
        out.add(Arguments.arguments(new int[]{1, 7, 3, 3, 4, 5, 4, 9, 8, 10}));
        out.add(Arguments.arguments(new int[]{1, 1, 0, 3, 5, 4, 4, 9, 4, 8}));
        out.add(Arguments.arguments(new int[]{1, 4, 2, 3, 4, 4, 5, 7, 5, 1}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForArray")
    public void testArraysConverter(int[] array){
        ArraysConverter arraysConverter = new ArraysConverter();
        int[] arrayConverting = arraysConverter.arrayConverting(array);
        int[] arrayConvertingTester = arrayConvertingTester(array);
        Assertions.assertArrayEquals(arrayConverting, arrayConvertingTester);
    }

    @ParameterizedTest
    @MethodSource("dataForArray")
    public void arrayChecked(int[] array){
        ArraysConverter arraysConverter = new ArraysConverter();
        Assertions.assertTrue(arraysConverter.arrayChecked(array));
    }

    public int[] arrayConvertingTester(int[] arrayInt) {
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
}
