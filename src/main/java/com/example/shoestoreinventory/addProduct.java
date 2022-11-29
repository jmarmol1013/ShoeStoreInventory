package com.example.shoestoreinventory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class addProduct extends Stage {
    addProduct() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryApp.class.getResource("addProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.setTitle("Add product inventory");
        this.setScene(scene);
        this.showAndWait();
    }
}
