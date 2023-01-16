package HeapTemplate;

import java.util.Arrays;

public class MaxHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getparentIndex(int childIndex) { return (childIndex - 1) / 2; }
    private boolean hasLeftChild(int index) { return getLeftChildIndex( index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex( index) < size; }
    private boolean hasparent(int index) { return getparentIndex(index) >= 0; }
    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)] ; }
    private int parent(int index) { return items[getparentIndex(index)]; }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    private void ensureExtraCapacitY( ) {
        if (size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return items[0];
    }

    public void add(int item) {
        ensureExtraCapacitY();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasparent(index) && parent(index) < items[index]) {
            swap(getparentIndex(index), index);
            index = getparentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = (hasRightChild(index) && rightChild(index) > leftChild(index)) ?
                    getRightChildIndex(index) : getLeftChildIndex(index);
            if (items[index] > items[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }
}
