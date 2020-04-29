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
            System.out.println(array[i]);
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

    public static void main(String[] args){
        int oneHundred[] = fillRandom(100);
        //int oneThousand[] = fillRandom(1000);
        //int tenThousand[] = fillRandom(10000);
        //int hundredThousand[] = fillRandom(100000);
        //int oneMillion[] = fillRandom(1000000);

        long oneHundredQuickTime = quickSortTime(oneHundred);
        long oneHundredMergeTime = mergeSortTime(oneHundred);

        //long oneThousandQuickTime = quickSortTime(oneThousand);
        //long oneThousandMergeTime = mergeSortTime(oneThousand);

        //long tenThousandQuickTime = quickSortTime(oneThousand);
        //long tenThousandMergeTime = mergeSortTime(tenThousand);
        
        //long hundredThousandQuickTime = quickSortTime(hundredThousand);
        //long hundredThousandMergeTime = mergeSortTime(hundredThousand);
        
        //long oneMillionQuickTime = quickSortTime(oneMillion);
        //long oneMillionMergeTime = mergeSortTime(oneMillion);
        
        System.out.println("Elapsed time in milliseconds for QuickSort (n=100): " + oneHundredQuickTime/(double)1000000);
        System.out.println("Elapsed time in milliseconds for MergeSort (n=100): " + oneHundredMergeTime/(double)1000000);

        //System.out.println("Elapsed time in milliseconds for QuickSort (n=1000): " + oneThousandQuickTime/(double)100000);
        //System.out.println("Elapsed time in milliseconds for MergeSort (n=1000): " + oneThousandMergeTime/(double)1000000);

        //System.out.println("Elapsed time in milliseconds for QuickSort (n=10000): " + tenThousandQuickTime/(double)1000000);
        //System.out.println("Elapsed time in milliseconds for MergeSort (n=10000): " + tenThousandMergeTime/(double)1000000);
        
        //System.out.println("Elapsed time in milliseconds for QuickSort (n=100000): " + hundredThousandQuickTime/(double)1000000);
        //System.out.println("Elapsed time in milliseconds for MergeSort (n=100000): " + hundredThousandMergeTime/(double)1000000);

        //System.out.println("Elapsed time in milliseconds for QuickSort (n=1000000): " + oneMillionQuickTime/(double)1000000);
        //System.out.println("Elapsed time in milliseconds for MergeSort (n=1000000): " + oneMillionMergeTime/(double)1000000);

    }
}
