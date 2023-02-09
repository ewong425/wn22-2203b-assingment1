package com.example.assignment1;

import javafx.application.Platform;

class MergeSort implements SortingStrategy {
    private int[] list;
    private SortingHubController controller;

    public MergeSort(SortingHubController controller, int[] intArray) {
        this.controller = controller;
        this.list = intArray;
    }

    @Override
    public void sort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length-1);
    }

    public void merge(int arr[], int start, int mid, int end) {
        int start2 = mid + 1;
        if (arr[mid] <= arr[start2]) {
            return;
        }
        while (start <= mid && start2 <= end) {
            if (arr[start] <= arr[start2]) {
                start++;
            }
            else {
                int value = arr[start2];
                int index = start2;

                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }

                arr[start] = value;

                start++;
                mid++;
                start2++;
            }
        }
        Platform.runLater(() -> controller.updateGraph(arr));
        try {
            Thread.sleep(50);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    @Override
    public void run() {
        sort(list);
    }
}