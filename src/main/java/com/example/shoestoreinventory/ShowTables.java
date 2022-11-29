package com.example.shoestoreinventory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

class ShowTables extends Stage {
    ShowTables(String tableName) throws IOException {
        if (tableName == "products"){
            FXMLLoader fxmlLoader = new FXMLLoader(InventoryApp.class.getResource("showTableProduct.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            this.setTitle("Shoe store table");
            this.setScene(scene);
            this.showAndWait();
        } else {
            System.out.println("Incomplete");
        }

    }
}
