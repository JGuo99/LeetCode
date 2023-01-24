package SearchSortTemplate;
/*
    https://visualgo.net/en/sorting
 */
public class Sorting {
    /*
        Recursively split the array into sub-arrays.
     */
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // Splits the Array into sub arrays of left and right
            int leftSize = array.length / 2;
            int[] left = new int[leftSize];
            for (int i = 0; i < leftSize; i++) left[i] = array[i];

            int rightSize = array.length - leftSize;
            int[] right = new int[rightSize];
            for (int i = 0; i < rightSize; i++) right[i] = array[i+leftSize];

            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }
    /*
        Merge the sorted sub-arrays.
         - Compares left-sub and right sub element
            - If left is less or equal --> assign to original array
            - If right is less --> assign to original array
     */
    public static void merge(int[] result, int[] left, int[] right) {
        int leftIdx = 0, rightIdx = 0;
        for (int i = 0; i < result.length; i++) {
            if (
                    rightIdx >= right.length ||
                    (leftIdx < left.length && left[leftIdx] <= right[rightIdx])
            ) {
                result[i] = left[leftIdx];
                leftIdx++;
            } else {
                result[i] = right[rightIdx];
                rightIdx++;
            }
        }
    }

    /*
        Other Sorting Algorithm is a form of swapping
     */
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
