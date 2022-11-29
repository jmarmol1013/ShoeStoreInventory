package com.example.shoestoreinventory.showTables.products;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.*;

public class ShowTableProductsController{
    public Button back;

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    @FXML
    private TableView<ProductsData> tableDisplay;
    @FXML
    private TableColumn<ProductsData, Integer> ID_col;
    @FXML
    private TableColumn<ProductsData, Integer> IDCategory_col;
    @FXML
    private TableColumn<ProductsData, String> product_col;
    @FXML
    private TableColumn<ProductsData, String> color_col;
    @FXML
    private TableColumn<ProductsData, Integer> stock_col;
    @FXML
    private TableColumn<ProductsData, Double> price_col;
    public TableColumn<ProductsData,Integer> IDSupplier_col;
    public TableColumn<ProductsData,Integer> sale_col;

    @FXML
    private void initialize() {
        displayProductsTable();
    }

    public void displayProductsTable(){
        tableDisplay.setEditable(false);
        final ObservableList<ProductsData> data = FXCollections.observableArrayList();
        ID_col.setCellValueFactory(new PropertyValueFactory<ProductsData, Integer>("pId"));
        IDCategory_col.setCellValueFactory(new PropertyValueFactory<ProductsData, Integer>("cId"));
        IDSupplier_col.setCellValueFactory(new PropertyValueFactory<ProductsData,Integer>("sId"));
        product_col.setCellValueFactory(new PropertyValueFactory<ProductsData, String>("pName"));
        color_col.setCellValueFactory(new PropertyValueFactory<ProductsData, String>("pColor"));
        stock_col.setCellValueFactory(new PropertyValueFactory<ProductsData, Integer>("pStock"));
        price_col.setCellValueFactory(new PropertyValueFactory<ProductsData, Double>("pPrice"));
        sale_col.setCellValueFactory(new PropertyValueFactory<ProductsData, Integer>("sale"));
        try{
            // load the driver class
            Class.forName( DRIVER );

            // establish connection to database
            conn = DriverManager.getConnection( DATABASE_URL, "COMP214_F22_zo_131", "password" );
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM products");
            System.out.println("Printing products");
            while (rs.next()) {
                int pId = rs.getInt(1);
                int cId = rs.getInt(2);
                int sId = rs.getInt(3);
                String name = rs.getString(4);
                String color = rs.getString(5);
                int stock = rs.getInt(6);
                double price = rs.getInt(7);
                int sale = rs.getInt(8);

                System.out.print("Products getter");
                ProductsData entry = new ProductsData(pId, cId, sId, name,color,stock,price, sale);
                data.add(entry);
            }
            tableDisplay.setItems(data);
            st.close();
            System.out.println(data);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if (conn != null) {
                try {
                    conn.close(); // close the connection after you're finnished with it
                } catch (SQLException ex) {/*nothing here*/}
                conn = null;
            }
        }
    }

    public void goBack(ActionEvent e) {
        Stage stage = (Stage) this.back.getScene().getWindow();
        stage.close();
    }
}