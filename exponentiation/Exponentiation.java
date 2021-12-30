package exponentiation;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(raiseToDegree(-2.5f,1));
    }

    public static float raiseToDegree(float nmb, int degree){
        if (nmb == 0 && degree < 0) throw new RuntimeException("Недопустимая комбинация");
        if (degree ==0) return 1;
        if (degree == 1) return nmb;
        if (degree < 0) return raiseToDegree(1/nmb, Math.abs(degree));
        return (nmb * raiseToDegree(nmb, degree-1));
    }

}
