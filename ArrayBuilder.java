public class ArrayBuilder {
    private int[] ints;

    public ArrayBuilder() {
    }

    public int[] buildIntArrays(int length) {
        this.ints = new int[length];
        int lostIndex = (int) (Math.random() * length);
        int j = 1;
        for (int i = 0; i < ints.length; i++) {
            if (lostIndex == i) j++;
            ints[i] = j++;
        }
        return ints;
    }

    public int getLostInt(int[] ints) {
        int firstIndex = 0;
        int lastIndex = ints.length - 1;
        int currentIndex;
        if (ints[0] == 2) return 1;
        do {
            currentIndex = (firstIndex + lastIndex) / 2;
            if (ints[currentIndex] > currentIndex + 1) lastIndex = currentIndex;
            if (ints[currentIndex] == currentIndex + 1) firstIndex = currentIndex + 1;
        } while (lastIndex != firstIndex);
        return ints[lastIndex] - 1;
    }
}
