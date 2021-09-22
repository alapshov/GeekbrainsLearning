package fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList = new ArrayList<>();
    private float weightSum;

    public void addFruit(T fruit){
        fruitList.add(fruit);
    }

    public float getWeight() {
        weightSum = 0;
        for (T fruit: fruitList) {
            weightSum += fruit.getWeight();
        }
        return weightSum;
    }

    public boolean compare(Box<?> fruitBox){
        return this.getWeight() == fruitBox.getWeight();
    }

    public void intersperse(Box<T> fruitBox){
        for (T fruit: fruitList) {
            fruitBox.addFruit(fruit);
        }
        fruitList.clear();
    }
}
