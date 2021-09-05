package com.shashank.ps.heap;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {

    @Getter
    private final int[] heap;

    @Getter
    private int size;

    public MinHeap(int capacity) {
        this.size = 0;

        heap = new int[capacity + 1];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(20);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(50);
        minHeap.insert(55);
        minHeap.insert(45);
        minHeap.insert(90);
        minHeap.insert(80);
        minHeap.printHeap();
        System.out.printf("Value %s deleted%n", minHeap.delete(3));
        minHeap.printHeap();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int pos) {
        return (pos-1)/2;
    }
    //k = 1 for left and k = 2 for right child.
    public int getChild(int pos, int k) {
        return (2*pos) + k;
    }

    public int getMinChild(int pos) {
        int leftChild = getChild(pos, 1);
        int rightChild = getChild(pos, 2);
        return Math.min(leftChild, rightChild);
    }

    public void insert(int x) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is full. No space to insert further values");
        }
        heap[size++] = x;
        heapify(size-1);
    }

    public int delete(int x) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        int key = heap[x];
        heap[x] = heap[size-1];
        size--;
        heapifyDown(x);
        return key;
    }

    private void heapify(int i) {
        int temp = heap[i];
        while (i > 0 && temp < heap[getParent(i)]) {
            heap[i] = heap[getParent(i)];
            i = getParent(i);
        }
        heap[i] = temp;
    }

    public boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (getChild(i, 1) < size) {
            child = getMinChild(i);
            if (temp > heap[child]) {
                heap[i] = heap[child];
            } else {
                break;
            }
            i = child;
        }
        heap[i] = temp;
    }

    public void printHeap() {
        Arrays.stream(heap).limit(size).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
