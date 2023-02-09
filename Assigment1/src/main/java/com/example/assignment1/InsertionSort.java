package com.example.assignment1;

import javafx.application.Platform;

class InsertionSort implements SortingStrategy {
    private int[] list;
    private SortingHubController controller;
    public InsertionSort(SortingHubController controller, int[] intArray) {
        this.controller = controller;
        this.list = intArray;
    }
    @Override
    public void sort(int num[])
    {
        int n = num.length;
        for (int i = 1; i < n; ++i) {
            int key = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > key) {
                num[j + 1] = num[j];
                j = j - 1;
            }
            num[j + 1] = key;
            Platform.runLater(() -> controller.updateGraph(num));
            try {
                Thread.sleep(50);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void run() {
        sort(list);
    }
}