package SearchSortTemplate;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void MergeSort() {
        Sorting sort = new Sorting();
        int[] testArray = { 9, 7, 5, 3, 1, 8, 6, 4, 2 };
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Original Array:");
        System.out.print(Arrays.toString(testArray) + "\n");

        sort.mergeSort(testArray);
        assertEquals(Arrays.toString(expected), Arrays.toString(testArray));

        System.out.println("Sorted Array:");
        System.out.print(Arrays.toString(testArray));
    }
}
