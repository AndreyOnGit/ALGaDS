package gb;

public class Notebook implements Comparable<Notebook> {
    private int price;
    private int ram;
    private String manufacturer;

    private final static int MAXPRICE = 2000;
    private final static int MINPRICE = 500;
    private final static int DISCRETEOFPRICE = 50;

    private final static int MAXRAM = 24;
    private final static int MINRAM = 4;
    private final static int DISCRETEOFRAM = 4;

    private final static String[] MANUFACTURERS = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};


    public Notebook(int price, int ram, String manufacturer) {
        this.price = price;
        this.ram = ram;
        this.manufacturer = manufacturer;
    }

    public Notebook() {
    }

    public int getPrice() {
        return price;
    }


    public int getRam() {
        return ram;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", ram=" + ram +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    public static int getRandomPrice() {
        return (int) ((Math.random() * ((MAXPRICE / DISCRETEOFPRICE - MINPRICE / DISCRETEOFPRICE) + 1)) + MINPRICE / DISCRETEOFPRICE) * DISCRETEOFPRICE;
    }

    public static int getRandomRAM() {
        return (int) ((Math.random() * ((MAXRAM / DISCRETEOFRAM - MINRAM / DISCRETEOFRAM) + 1)) + MINRAM / DISCRETEOFRAM) * DISCRETEOFRAM;
    }

    public static String getRandomManufacturer() {
        return MANUFACTURERS[(int) (Math.random() * MANUFACTURERS.length)];
    }

    @Override
    public int compareTo(Notebook o) {
        if (this.getPrice() == o.getPrice()) {
            if (this.getRam() == o.getRam()) {
                if (this.getManufacturer().equals(o.getManufacturer())) return 0;
                else if (this.getWeightOfManufacturer() > o.getWeightOfManufacturer()) return 1;
                else return -1;
            } else if (this.getRam() > o.getRam()) return 1;
            else return -1;
        } else if (this.getPrice() > o.getPrice()) {
            return 1;
        } else return -1;
    }

    private int getWeightOfManufacturer() {
//      Lenuvo > Asos > MacNote > Eser > Xamiou
        switch (this.getManufacturer()) {
            case "Xamiou":
                return 0;
            case "Eser":
                return 1;
            case "MacNote":
                return 2;
            case "Asos":
                return 3;
            default:
                return 4;
        }
    }
}
