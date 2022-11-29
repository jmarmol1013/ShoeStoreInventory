package com.example.shoestoreinventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class InventoryController {

    public ChoiceBox table;

    @FXML
    private Label welcomeText;

    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("products", "orders","employee");
        //populate the Choicebox;
        table.setItems(list);
    }

    public void showTable(ActionEvent actionEvent) throws IOException {
        new ShowTables(table.getValue().toString());
    }

    public void addProduct(ActionEvent actionEvent) throws IOException {
        new addProduct();
    }

    public void sellProduct(ActionEvent actionEvent) {
    }

    public void changeProduct(ActionEvent actionEvent) {

    }
}

