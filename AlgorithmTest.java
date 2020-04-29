import java.util.Random;
import java.util.concurrent.TimeUnit;


public class AlgorithmTest{

    //fills given array with n random integers
    public static void fillRandom(int array[], int n){
        Random random = new Random();
        int randomInteger;
        for(int i=0; i<array.length;i++){
            randomInteger = random.nextInt();
            array[i]=randomInteger;
        }
    }
    //returns elapsed time in nanoseconds for intArray using mergeSort of size n
    public static long mergeSortTime(int array[]){
        long startTime = System.nanoTime();
        MergeSort.mergeSort(array, 0, array.length-1);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static void main(String[] args){
        int oneHundred[] = new int[100];
        int oneThousand[] = new int[1000];
        int tenThousand[] = new int[10000];
        int oneMillion[] = new int[1000000];

        fillRandom(oneHundred, oneHundred.length);
        fillRandom(oneThousand, oneThousand.length);
        fillRandom(tenThousand, tenThousand.length);
        fillRandom(oneMillion, oneMillion.length);

        long oneHundredTime = mergeSortTime(oneHundred);
        long oneThousandTime = mergeSortTime(oneThousand);
        long tenThousandTime = mergeSortTime(tenThousand);
        long oneMillionTime = mergeSortTime(oneMillion);


        System.out.println("Elapsed time in nanoseconds for MergeSort (n=100): " + oneHundredTime);
        System.out.println("Elapsed time in milliseconds for MergeSort (n=100): " + oneHundredTime/1000000);

        System.out.println("Elapsed time in nanoseconds for MergeSort (n=1000): " + oneThousandTime);
        System.out.println("Elapsed time in milliseconds for MergeSort (n=1000): " + oneThousandTime/1000000);

        System.out.println("Elapsed time in nanoseconds for MergeSort (n=10000): " + tenThousandTime);
        System.out.println("Elapsed time in milliseconds for MergeSort (n=10000): " + tenThousandTime/1000000);

        System.out.println("Elapsed time in nanoseconds for MergeSort (n=1000000): " + oneMillionTime);
        System.out.println("Elapsed time in milliseconds for MergeSort (n=1000000): " + oneMillionTime/1000000);

    }
}
