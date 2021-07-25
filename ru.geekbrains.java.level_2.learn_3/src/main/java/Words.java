import java.util.*;
import java.util.stream.Collectors;

public class Words {
    public static void main(String[] args) {
        List<String> wordsList = Arrays.asList("пальма", "лошадка", "зебра", "антилопа", "лошадка", "лошадка", "пальма");
        //Вариант с хешсетом
        // Set<String> uniqueElements = new HashSet<>(wordsList);
        // Альтернативный варинант через стрим
        List<String> uniqueElements = wordsList.stream().distinct().collect(Collectors.toList());
        System.out.printf("Уникальные элементы списка wordsList: %s \n", uniqueElements);
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < uniqueElements.size(); i++) {
            int count = 0;
            for (int j = 0; j < wordsList.size(); j++) {
                if (uniqueElements.get(i).contains(wordsList.get(j))) {
                    count++;
                }
            }
            countMap.put(uniqueElements.get(i), count);
        }
        System.out.println(countMap);
    }
}