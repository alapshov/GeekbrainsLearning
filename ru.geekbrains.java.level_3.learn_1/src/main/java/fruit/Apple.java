package fruit;

public class Apple extends Fruit{

    public Apple(){
        setWeight(1.0f);
    }

    @Override
    public void setWeight(float weight) {
        super.setWeight(weight);
    }

    @Override
    public float getWeight() {
        return super.getWeight();
    }
}
