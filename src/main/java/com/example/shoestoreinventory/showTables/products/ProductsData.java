package com.example.shoestoreinventory.showTables.products;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductsData {
    private final SimpleIntegerProperty pId;
    private final SimpleIntegerProperty cId;
    private final SimpleIntegerProperty sId;
    private final SimpleStringProperty pName;
    private final SimpleStringProperty pColor;
    private final SimpleIntegerProperty pStock;
    private final SimpleDoubleProperty pPrice;
    private final SimpleIntegerProperty sale;

    public ProductsData(int pId, int cId, int sId, String pName, String pColor, int pStock, double pPrice, int sale) {
        this.pId = new SimpleIntegerProperty(pId) ;
        this.cId = new SimpleIntegerProperty(cId);
        this.sId = new SimpleIntegerProperty(sId);
        this.pName = new SimpleStringProperty(pName);
        this.pColor = new SimpleStringProperty(pColor);
        this.pStock = new SimpleIntegerProperty(pStock);
        this.pPrice = new SimpleDoubleProperty(pPrice);
        this.sale = new SimpleIntegerProperty(sale);
    }


    public int getpId() {
        return pId.get();
    }

    public SimpleIntegerProperty pIdProperty() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId.set(pId);
    }

    public int getcId() {
        return cId.get();
    }

    public SimpleIntegerProperty cIdProperty() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId.set(cId);
    }

    public int getsId() {
        return sId.get();
    }

    public SimpleIntegerProperty sIdProperty() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId.set(sId);
    }

    public String getpName() {
        return pName.get();
    }

    public SimpleStringProperty pNameProperty() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName.set(pName);
    }

    public String getpColor() {
        return pColor.get();
    }

    public SimpleStringProperty pColorProperty() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor.set(pColor);
    }

    public int getpStock() {
        return pStock.get();
    }

    public SimpleIntegerProperty pStockProperty() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock.set(pStock);
    }

    public double getpPrice() {
        return pPrice.get();
    }

    public SimpleDoubleProperty pPriceProperty() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice.set(pPrice);
    }

    public int getSale() {
        return sale.get();
    }

    public SimpleIntegerProperty saleProperty() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale.set(sale);
    }
}
