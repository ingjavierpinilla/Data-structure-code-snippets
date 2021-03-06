package MaxHeap;

import java.util.PriorityQueue;

public class MaxHeap {

    private int[] array;
    private int size;

    public MaxHeap() {
        this.array = new int[2];
        this.size = 0;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }

    public void buildHeap(int[] a) {
        setArray(a);
        setSize(a.length-1);

        for (int i = (getSize()) / 2; i >= 1; i--) {
            siftDown(i);
        }

    }

    public void insert(int value) {
        setSize(getSize()+1);
        if (array.length <= getSize()) {
            
            int[] a = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                a[i]=array[i];
            }
            setArray(a);
        }
        
        array[size] = value;
        siftUp(size);

    }

    public void siftUp(int value) {
        while (value > 1 && array[parent(value)] < array[value]) {
            swap(parent(value), value);
            value = parent(value);
        }
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = array[fpos];
        array[fpos] = array[spos];
        array[spos] = tmp;

    }

    public void siftDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        if (l <= getSize() && array[l] > array[maxIndex]) {
            maxIndex = l;
        }
        int r = rightChild(i);
        if (r <= getSize() && array[r] > array[maxIndex]) {
            maxIndex = r;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            siftDown(maxIndex);
        }

    }

    public int extractMax() {
        int result = array[1];
        array[1] = array[size];
        size--;
        siftDown(1);
        return result;
    }

    public void sort(int[] a) {
        PriorityQueue<Integer> pQ= new PriorityQueue<Integer>(a.length);

        for (int i = 0; i < a.length; i++) {
            pQ.add(a[i]);
        }
        setArray(a);
        for (int i = 0; i < array.length; i++) {
            
            this.array[i]=pQ.poll();
        }
     

    }

}
