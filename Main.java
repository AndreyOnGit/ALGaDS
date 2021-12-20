public class Main {
    public static void main(String[] args) {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        int[] ints = arrayBuilder.buildIntArrays(10000000);
        System.out.println("The lost int = " + arrayBuilder.getLostInt(ints));
    }

}
