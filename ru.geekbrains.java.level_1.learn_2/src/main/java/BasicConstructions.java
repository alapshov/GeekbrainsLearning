import java.util.Scanner;

public class BasicConstructions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение а: ");
        int a = scanner.nextInt();
        System.out.print("Введите значение b: ");
        int b = scanner.nextInt();
        System.out.println(checkSum(a, b));
        System.out.println(checkNumberA2(a));
        checkNumberA(a);
        stringsNumber("Тестовая строка", a);
        leapYear();

    }

    public static Boolean checkSum(int a, int b) {
        int c = a + b;
        return (c >= 10 && c <= 20) ? true : false;
    }

    public static void checkNumberA(int a) {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static Boolean checkNumberA2(int a) {
        return a < 0 ? true : false;
    }

    public static void stringsNumber(String str, int number) {
        for (int i = number; i > 0; i--) {
            System.out.println(str);
        }
    }

    public static Boolean leapYear() {
        boolean bool = false;
        for (int i = 1900; i <= 2021; i++) {
            if (i % 4 != 0) {
                System.out.println(i + " не високосный");
            } else if (i % 100 != 0) {
                System.out.println(i + " високосный");
                bool = true;
            } else if (i%400 == 0){
                System.out.println(i + " високосный");
                bool = true;
            }
        }
        return bool;
    }

}
