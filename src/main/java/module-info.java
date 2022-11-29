module com.example.shoestoreinventory {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires lombok;
    requires java.desktop;

    opens com.example.shoestoreinventory to javafx.fxml;
    exports com.example.shoestoreinventory;
    exports com.example.shoestoreinventory.showTables.products;
    opens com.example.shoestoreinventory.showTables.products to javafx.fxml;
    opens com.example.shoestoreinventory.addProducts to javafx.fxml;
}