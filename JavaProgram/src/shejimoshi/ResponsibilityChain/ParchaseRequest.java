package shejimoshi.ResponsibilityChain;

public class ParchaseRequest {
    private int type;
    private float price;
    private int id;

    public ParchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }


}
