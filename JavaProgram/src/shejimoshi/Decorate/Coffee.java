package shejimoshi.Decorate;

public class Coffee extends Drink {

    @Override
    public float cost() {
        return this.getPrice();
    }
}
