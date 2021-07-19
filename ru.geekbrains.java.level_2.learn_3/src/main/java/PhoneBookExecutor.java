import java.lang.reflect.Array;
import java.util.*;


public class PhoneBookExecutor {
    private static Map<String, List<PhoneBook>> phoneBookMap = new HashMap<>();
    private static List<PhoneBook> phoneBookList = new ArrayList<>();

    public static void main(String[] args) {
        add("Иванов", "+79054562332");
        add("Петров", "+79054231235");
        add("Сидоров", "+7925452315");
        add("Иванов", "+79267524123");
        System.out.println((phoneBookMap.get("Иванов")));
    }

    public static void add(String surname, String phone) {
        phoneBookList = phoneBookMap.get(surname) == null ? new ArrayList<>() : phoneBookMap.get(surname);
        phoneBookList.add(new PhoneBook(surname, phone));
        phoneBookMap.put(surname, phoneBookList);
    }

    public static List<PhoneBook> get(String surname) {
        return phoneBookMap.get(surname);
    }
}
