import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SortTime{
    private static int partition(int intArray[], int p, int r){
        int x = intArray[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(intArray[j] < x){
                i++;
                int temp = intArray[i];
                intArray[i] = intArray[j];
                intArray[j] = temp;
            }
        }
        intArray[r] = intArray[i+1];
        intArray[i + 1] = x;
        return i + 1;
    }

    private static void quickSort(int intArray[], int p, int r){
        if(p<r){
            int pivot = partition(intArray, p, r);
            quickSort(intArray, p, pivot - 1);
            quickSort(intArray, pivot + 1, r);
        }
    }

    private static void merge(int intArray[], int low, int mid, int high){
        int leftLength = (mid-low)+ 1;
        int rightLength = high-mid;
        int[] left = new int[leftLength];
        //left[0] = intArray[low];
        for(int i =0; i<leftLength;i++){ //length-1?
            left[i] = intArray[low+i];
        }
        int[] right = new int[rightLength];
        for(int i=0; i<rightLength; i++){
            right[i] = intArray[mid+i+1];
        }
        int i=0;
        int j=0;
        int k=low;
        while(i< leftLength && j<rightLength){
            if(left[i]<=right[j]){
                intArray[k]= left[i];
                i++;
            }
            else{
                intArray[k]= right[j];
                j++;
            }
            k++;
        }
        while(i< leftLength){
            intArray[k]=left[i];
            i++; k++;
        }
        while(j< rightLength){
            intArray[k]=right[j];
            j++; k++;
        }

    }

    private static void mergeSort(int[] intArray, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(intArray, low, mid);
            mergeSort(intArray, mid+1, high);
            merge(intArray, low, mid, high);
        }
    }

    //fills given array with n random integers
    private static int[] fillRandom(int n){
        Random random = new Random();
        int[] array = new int[n];
        int randomInteger;
        for(int i=0; i<array.length;i++){
            randomInteger = random.nextInt();
            array[i]=randomInteger;
        }
        return array;
    }
    //returns elapsed time in nanoseconds for intArray using mergeSort of size n
    private static long mergeSortTime(int array[]){
        long startTime = System.nanoTime();
        mergeSort(array, 0, array.length-1);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    private static long quickSortTime(int array[]){
        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    private static long quickSortAverageTime(int n){
        long array[] = new long[100];
        for(int i = 0; i < 100; i++)
            array[i] = quickSortTime(fillRandom(n));

        return arrayAverage(array);
    }

    private static long mergeSortAverageTime(int n){
        long array[] = new long[100];
        for(int i = 0; i < 100; i++)
            array[i] = mergeSortTime(fillRandom(n));

        return arrayAverage(array);
    }

    private static long arrayAverage(long array[]){
        long total = 0;
        for(int i = 0; i < array.length; i++)
            total += array[i];

        return total / (long)array.length;
    }

    public static void main(String[] args){
        int[] array;
        long quickTime;
        long mergeTime;
        for(int i = 0; i <= 6; i++){
            array = fillRandom((int)Math.pow(10, i));
            quickTime = quickSortTime(array);
            mergeTime = mergeSortTime(array);
            System.out.print("Elapsed time in milliseconds for QuickSort (n="+ (int)Math.pow(10, i) +"): ");
            System.out.format("%.4f\n", quickTime/(double)1000000);
            System.out.print("Elapsed time in milliseconds for MergeSort (n="+ (int)Math.pow(10, i)+")): ");
            System.out.format("%.4f\n", mergeTime/(double)1000000);
        }
        
        /* //For finding averages
        long averageQuickTime;
        long averageMergeTime;
        for(int i = 0; i <= 6; i++){
            averageQuickTime = quickSortAverageTime((int)Math.pow(10, i));
            averageMergeTime = mergeSortAverageTime((int)Math.pow(10, i));

            System.out.print("Average elapsed time in milliseconds for QuickSort (n="+ (int)Math.pow(10, i) +"): ");
            System.out.format("%.4f\n", averageQuickTime/(double)1000000);
            System.out.print("Average elapsed time in milliseconds for MergeSort (n="+ (int)Math.pow(10, i)+")): ");
            System.out.format("%.4f\n", averageMergeTime/(double)1000000);
        }
        */
    }
}
