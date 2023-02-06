package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class SortingHubController implements Initializable {
    private int[] intArray;

    private SortingStrategy sortingMethod;
    @FXML
    private ComboBox<String> algorithmComboBox;
    @FXML
    private Slider sliderControl;
    @FXML
    private Button sortButton;
    @FXML
    private Button resetButton;
    @FXML
    private Label arrayValue;
    @FXML
    private Pane paneWindow;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateArray(64);
        updateGraph(intArray);
        algorithmComboBox.setValue("Merge Sort");
        algorithmComboBox.getItems().addAll("Merge Sort", "Selection Sort");
        sliderControl.setValue(64);
        arrayValue.setText("64");

    }
//    public setSortStrategy() {
//        sortingMethod =
//   }
    public void sliderListener() {
        arrayValue.setText("" + (int) Math.floor(sliderControl.getValue()));
        populateArray((int) sliderControl.getValue());
        updateGraph(intArray);
    }
    public void resetListener() {
        algorithmComboBox.setValue("Merge Sort");
        sliderControl.setValue(64);
        arrayValue.setText("64");
        updateGraph(intArray);
    }
    //populate the array with values of non-repeating values from in a range given by the Slider value
    public int[] populateArray(int size) {
        intArray = new int[size];
        int randomNumber;
        Random num = new Random();
        //add numbers from 1 to whatever the slider Value is to the array
        for(int i=0; i<size; i++) {
            intArray[i] = i+1;
        }
        //shuffle the values indexes around to create a unsorted array
        for(int i=0; i<size-1; i++) {
            int r = num.nextInt(size - i) + i;
            int temp = intArray[i];
            intArray[i] = intArray[r];
            intArray[r] = temp;
        }
        return intArray;
    }
    public void updateGraph(int[] data) {
        int n = data.length;
        paneWindow.getChildren().clear();
        double width = paneWindow.getWidth();
        double height = paneWindow.getHeight();

        double rectWidth = width/n - 2;
        for(int i=0; i<n; i++) {
            double rectHeight = (data[i] * height) / n;
            double x = (width/n) * i + 1;
            double y = height - rectHeight;
            Rectangle br = new Rectangle(x, y, rectWidth, (int) rectHeight);
            br.setFill(Color.RED);
            paneWindow.getChildren().add(br);
        }
    }
}
