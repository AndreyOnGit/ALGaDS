package gb;

import java.util.Arrays;

public class ArrayBuilder {
    private Notebook[] arrays;

    public ArrayBuilder() {
    }

    public Notebook[] buildArrays(int length) {
        this.arrays = new Notebook[length];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = new Notebook(Notebook.getRandomPrice(), Notebook.getRandomRAM(), Notebook.getRandomManufacturer());
        }
        return arrays;
    }

    public void printArrays(Notebook[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(i + ".  " + arrays[i]);
        }
    }

    public void sort(Notebook[] arrays) {
        Arrays.sort(arrays);
    }

    public void selectionSort(Notebook[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j].compareTo(arrays[min]) < 0) min = j;
            }
            Notebook temp = arrays[i];
            arrays[i] = arrays[min];
            arrays[min] = temp;
        }
    }

    public void optimizedSelectionSort(Notebook[] arrays) {
        int size = arrays.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            int max = i;
            for (int j = i + 1; j < size; j++) {
                if (arrays[j].compareTo(arrays[min]) < 0) min = j;
                if (arrays[j].compareTo(arrays[max]) > 0) max = j;
            }
            Notebook tempMin = arrays[i];
            arrays[i] = arrays[min];
            arrays[min] = tempMin;

            if (arrays[min].compareTo(arrays[max]) > 0) max = min;
            Notebook tempMax = arrays[size-1];
            arrays[size-1] = arrays[max];
            arrays[max] = tempMax;

            size--;
        }
    }

}
