package backpack;

import java.util.ArrayList;
import java.util.Arrays;

public class Backpack {
    public static void main(String[] args) {
        System.out.println("FINAL: " + Arrays.toString(getBestCombination(getThings(), 20)));
    }

    public static Thing[] getThings() {
        Thing[] things = new Thing[3];
        things[2] = new Thing("telephone", 1, 20000);
        things[0] = new Thing("TV", 15, 300000);
        things[1] = new Thing("note", 7, 40000);
        return things;
    }

    public static Thing[] getBestCombination(Thing[] things, int weight) {
        int bestPrice = 0;
        Thing[] bestSubThings = null;

        if (getTotalWeight(new ArrayList<>(Arrays.asList(things))) <= weight) return things;

        for (int i = 0; i < things.length; i++) {
            ArrayList<Thing> arrayList = new ArrayList<>(Arrays.asList(things));
            arrayList.remove(i);

            if (bestPrice == 0) {
                bestSubThings = getBestCombination(arrayList.toArray(new Thing[arrayList.size()]), weight);
                bestPrice = getTotalPrice(arrayList);
            }
            ArrayList<Thing> currentArrayList = new ArrayList<>(Arrays.asList(getBestCombination(arrayList.toArray(new Thing[arrayList.size()]), weight)));
            if (getTotalPrice(currentArrayList) > bestPrice)
                bestSubThings = getBestCombination(currentArrayList.toArray(new Thing[currentArrayList.size()]), weight);
            bestPrice = getTotalPrice(currentArrayList);
        }
        return bestSubThings;

    }

    public static int getTotalPrice(ArrayList<Thing> arrayList) {
        int totalPrice = 0;
        for (Thing th : arrayList) totalPrice += th.getPrice();
        return totalPrice;
    }

    public static int getTotalWeight(ArrayList<Thing> arrayList) {
        int totalWeight = 0;
        for (Thing th : arrayList) totalWeight += th.getWeight();
        return totalWeight;
    }
}
