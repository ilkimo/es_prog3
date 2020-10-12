import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class AppCalcolatrice {
    public static void main(String[] args) {

        Random r = new Random();
        ArrayList<Integer> arrayInteri = new ArrayList<>();
        ArrayList<Double> arrayDouble = new ArrayList<>();
        ArrayList<Float> arrayFloat = new ArrayList<>();
        ArrayList<Long> arrayLong = new ArrayList<>();

        for(int i=0; i<5; i++){
            arrayInteri.add(r.nextInt(10));
            arrayDouble.add(r.nextDouble());
            arrayFloat.add(r.nextFloat());
            arrayLong.add(r.nextLong());
        }

        System.out.print("arrayInteri: ");
        Calcolatrice.print(arrayInteri);
        int sommaInteri = (Integer)Calcolatrice.sum(arrayInteri);
        System.out.println("sommaInteri = " + sommaInteri);
        int maxInteri = (Integer)Calcolatrice.max(arrayInteri);
        System.out.println("maxInteri = " + maxInteri);

        System.out.println();
        System.out.print("arrayDouble: ");
        Calcolatrice.print(arrayDouble);
        double sommaDouble = (Double)Calcolatrice.sum(arrayDouble);
        System.out.println("sommaInteri = " + sommaDouble);
        double maxDouble = (Double)Calcolatrice.max(arrayDouble);
        System.out.println("maxDouble = " + maxDouble);

        System.out.println();
        System.out.print("arrayIarrayFloatnteri: ");
        Calcolatrice.print(arrayFloat);
        float sommaFloat = (Float)Calcolatrice.sum(arrayFloat);
        System.out.println("sommaInteri = " + sommaFloat);
        float maxFloat = (Float)Calcolatrice.max(arrayFloat);
        System.out.println("maxFloat = " + maxFloat);

        System.out.println();
        System.out.print("arrayLong: ");
        Calcolatrice.print(arrayLong);
        long sommaLong = (Long)Calcolatrice.sum(arrayLong);
        System.out.println("sommaLong = " + sommaLong);
        long maxLong = (Long)Calcolatrice.max(arrayLong);
        System.out.println("maxLong = " + maxLong);
    }
}
