import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class TestClass {

    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("---===Подготовка сьюта===---");
    }

    @AfterSuite
    public static void afterSuite(){
        System.out.println("---===Завершение сьюта===---");
    }

    @Test(priority = 1)
    public static void Test1(){
        System.out.println("---===Тест-1 пройден!!!===---");
    }

    @Test(priority = 2)
    public static void Test2(){
        System.out.println("---===Тест-2 пройден!!!===---");
    }

    @Test(priority = 3)
    public static void Test3(){
        System.out.println("---===Тест-3 пройден!!!===---");
    }

    @Test(priority = 4)
    public static void Test4(){
        System.out.println("---===Тест-4 пройден!!!===---");
    }

    @Test(priority = 5)
    public static void Test5(){
        System.out.println("---===Тест-5 пройден!!!===---");
    }

}
