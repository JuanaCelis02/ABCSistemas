package model;

import java.time.LocalDate;

public class Sale{

    private String user;
    private LocalDate saleDate;
    private int num;
    private String UnitOrMeasurement;
    private double price, taxes, totalValue;

    public Sale(){

    }

    public Sale(String user, LocalDate saleDate, int num, String unitOrMeasurement, double price) {
        this.user = user;
        this.saleDate = saleDate;
        this.num = num;
        UnitOrMeasurement = unitOrMeasurement;
        this.price = price;
    }

    public Sale(String user, LocalDate saleDate, int num, String unitOrMeasurement, double price, double taxes, double totalValue) {
        this.user = user;
        this.saleDate = saleDate;
        this.num = num;
        UnitOrMeasurement = unitOrMeasurement;
        this.price = price;
        this.taxes = taxes;
        this.totalValue = totalValue;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

   

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnitOrMeasurement() {
        return UnitOrMeasurement;
    }

    public void setUnitOrMeasurement(String unitOrMeasurement) {
        UnitOrMeasurement = unitOrMeasurement;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Object[] getSalesData(){
        return new Object[]{this.user, this.saleDate, this.num, this.UnitOrMeasurement, this.price};
    }

    public Object[] getSalesByUser(){
        return new Object[]{this.user, this.num};
    }

    public double calculateTaxes(double price){
        return taxes = (price * 19) / 100;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public Object[] getSalesGeneral(){
        return new Object[]{this.user, this.saleDate, this.num, this.UnitOrMeasurement, this.price, calculateTaxes(price), calculateTaxes(price)*num};
    }


    @Override
    public String toString() {
        return user + ";" + saleDate+ ";" +num + ";"+ UnitOrMeasurement +";"+ price +";"+ taxes +";"+ totalValue;
    }

}
