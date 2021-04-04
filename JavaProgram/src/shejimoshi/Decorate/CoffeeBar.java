package shejimoshi.Decorate;

public class CoffeeBar {
    public static void main(String[] args) {
        Drink longblack = new LongBlack();
        longblack =  new Chocolate(longblack);
        longblack =  new Chocolate(longblack);
        System.out.println(longblack.cost());
    }
}
