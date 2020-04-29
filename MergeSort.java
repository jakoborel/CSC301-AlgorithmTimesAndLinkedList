public class MergeSort{

    public static void merge(int intArray[], int low, int mid, int high){
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

    public static void mergeSort(int[] intArray, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(intArray, low, mid);
            mergeSort(intArray, mid+1, high);
            merge(intArray, low, mid, high);
        }
    }

    public static void main(String[] args){
        int[] array = {4,3,1,2,6,5};
        mergeSort(array, 0, array.length-1);
        for(int i=0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
