package com.example.shoestoreinventory.addProducts;

import com.example.shoestoreinventory.DialogsFX;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class addProductSupplierController {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";

    public TextField dateOrder;
    public TextField supplierID;
    public TextField orderID;
    public TextField quantity;
    public TextField price;
    public TextField storeID;
    public Button back;
    public RadioButton newOrder;
    public RadioButton existingOrder;
    public TextField productID;

    public void createOrder(ActionEvent actionEvent) {
        try {
            // load the driver class
            Class.forName(DRIVER);

            // establish connection to database
            conn = DriverManager.getConnection(DATABASE_URL, "COMP214_F22_zo_131", "password");
            CallableStatement cs = conn.prepareCall("{? = call new_supplier_order (?,?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setInt(2, Integer.parseInt(supplierID.getText()));
            cs.setString(3, dateOrder.getText());
            cs.execute();

            String returnVarchar = cs.getString(1);
            DialogsFX.showInformation("Creating order",returnVarchar);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // close the connection after you're finnished with it
                } catch (SQLException ex) {/*nothing here*/}
                conn = null;
            }
        }

    }
    public void addProduct(ActionEvent actionEvent) {
        try {
            // load the driver class
            Class.forName(DRIVER);

            // establish connection to database
            conn = DriverManager.getConnection(DATABASE_URL, "COMP214_F22_zo_131", "password");
            CallableStatement cs = conn.prepareCall("{? = call new_supplier_order_products (?,?,?,?,?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setInt(2, Integer.parseInt(orderID.getText()));
            cs.setInt(3, Integer.parseInt(productID.getText()));
            cs.setInt(4,Integer.parseInt(quantity.getText()));
            cs.setDouble(5,Double.parseDouble(price.getText()));
            cs.setInt(6,Integer.parseInt(storeID.getText()));
            cs.execute();

            String returnVarchar = cs.getString(1);
            DialogsFX.showInformation("Adding product to a order",returnVarchar);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // close the connection after you're finnished with it
                } catch (SQLException ex) {/*nothing here*/}
                conn = null;
            }
        }
    }

    public void resetForm(ActionEvent actionEvent) {
        orderID.setText("");
        productID.setText("");
        quantity.setText("");
        price.setText("");
        storeID.setText("");
    }


    public void goBack(ActionEvent actionEvent) {
        Stage stage = (Stage) this.back.getScene().getWindow();
        stage.close();
    }

    public void disableExistingOrder(ActionEvent actionEvent) {
        orderID.setEditable(false);
        quantity.setEditable(false);
        productID.setEditable(false);
        price.setEditable(false);
        storeID.setEditable(false);
        supplierID.setEditable(true);
        dateOrder.setEditable(true);
    }

    public void disableNewOrder(ActionEvent actionEvent) {
        orderID.setEditable(true);
        productID.setEditable(true);
        quantity.setEditable(true);
        price.setEditable(true);
        storeID.setEditable(true);
        supplierID.setEditable(false);
        dateOrder.setEditable(false);
    }

}
