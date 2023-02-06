package com.example.assignment1;

public interface SortingStrategy extends Runnable {
    public void sort(int[] numbers);
}

class SelectionSort {
    private int[] list;
    private SortingHubController controller;

    public void sort(int[] numbers) {
        int n = numbers.length;
        for(int i=0; i<n-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
    }
    public void run() {}
}

class MergeSort {
    private int[] list;
    private SortingHubController controller;
    public void sort(int[] numbers) {
        int n = numbers.length;
        if(n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for(int i=0; i<mid; i++) {
            l[i] = numbers[i];
        }
        for(int i=mid; i < n; i++) {
            r[i-mid] = numbers[i];
        }
        sort(l);
        sort(r);

        merge(numbers, l, r, mid, n-mid);
    }
    public void merge(int[] numbers, int[] l, int[] r, int left, int right) {
        int i = 0, j=0, k=0;
        while(i < left && j < right) {
            if(l[i] <= r[j]) {
                numbers[k++] = l[i++];
            } else {
                numbers[k++] = r[j++];
            }
        }
        while (i < left) {
            numbers[k++] = l[i++];
        }
        while(j < right) {
            numbers[k++] = r[j++];
        }
    }
    public void run() {}
 }
