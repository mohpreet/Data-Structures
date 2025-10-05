package day3;

import java.util.Arrays;

public class TesterMergeSort {

    private static  void mergeSort(int[] actualArray){
        int arrayLength = actualArray.length;

        if(arrayLength<=1){
            return;
        }
        Arrays.stream(actualArray).forEach(element-> System.out.print(element+","));
        System.out.println();
        int leftArray[] = Arrays.copyOf(actualArray,arrayLength/2);
        int rightArray[] =Arrays.copyOfRange(actualArray,arrayLength/2, arrayLength);
        mergeSort(leftArray);
        mergeSort(rightArray);
        mergeArrays(leftArray,rightArray,actualArray);
    }
    private static void mergeArrays(int[] leftArray,int[] rightArray,int[] resultArray){
        int i = 0, j = 0, k = 0;

        // compare elements and pick smaller
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                resultArray[k++] = leftArray[i++];
            } else {
                resultArray[k++] = rightArray[j++];
            }
        }

        // copy leftovers from left
        while (i < leftArray.length) {
            resultArray[k++] = leftArray[i++];
        }

        // copy leftovers from right
        while (j < rightArray.length) {
            resultArray[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        mergeSort(new int[]{2,7,1,9,4,11,6,15,3,5});
    }
}
