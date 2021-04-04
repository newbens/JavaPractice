package shejimoshi.Decorate;

public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }
    @Override
    public float cost() {
        return this.getPrice()+obj.cost();
    }
}
