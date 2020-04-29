public class QuickSort
{
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

    public static void quickSort(int intArray[], int p, int r){
        if(p<r){
            int pivot = partition(intArray, p, r);
            quickSort(intArray, p, pivot - 1);
            quickSort(intArray, pivot + 1, r);
        }
    }

    private static void printArray(int intArray[]){
       for(int i = 0; i < intArray.length; i++)
            System.out.println(intArray[i]);
       System.out.println();
    }

    public static void main(String args[]){
        int[] intArray = {30,1,6,0,10};

        quickSort(intArray, 0, intArray.length - 1);

        printArray(intArray);
    }
}
