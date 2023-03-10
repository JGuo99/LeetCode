package SearchSortTemplate;

public class BST {
    public boolean BSTRecursive(int[] array, int x, int left, int right) {
        if (left > right)
            return false;
        int mid = left + (right - left) / 2;
        if (array[mid] == x)
            return true;
        else if (x < array[mid])
            return BSTRecursive(array, x, left, mid-1);
        else
            return BSTRecursive(array, x, mid + 1, right);
    }

    public boolean BSTIterative(int[] array, int x) {
        int left = 0;
        int right = array.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == x)
                return true;
            else if (x < array[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

}
