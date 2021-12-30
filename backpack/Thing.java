package backpack;

public class Thing {
    private int weight;
    private int price;
    private String name;

    public Thing(String name, int weight, int price) {
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + name + ": " +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
