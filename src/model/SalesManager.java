package model;

import java.util.ArrayList;
import java.util.Comparator;

public class SalesManager{

    private ArrayList<Sale> listSale;
    private ArrayList<Sale> listSaleExport;

    public SalesManager() {
        listSale = new ArrayList<>();
        listSaleExport = new ArrayList<>();
    }

    public ArrayList<Sale> getListSale() {
        return listSale;
    }

    public void setListSale(ArrayList<Sale> listSale) {
        this.listSale = listSale;
    }

    public ArrayList<Sale> getListSaleExport() {
        return listSaleExport;
    }

    public void setListSaleExport(ArrayList<Sale> listSaleExport) {
        this.listSaleExport = listSaleExport;
    }

    public void addSales(Sale sales){
        listSale.add(sales);
    }

    public void addSalesToListExport(Sale sale) {
        listSaleExport.add(sale);
    }

    public void orderDateSales(ArrayList<Sale>list){
        list.sort(new Comparator<Sale>() {
            @Override
            public int compare(Sale o1, Sale o2) {
                return o1.getSaleDate().compareTo(o2.getSaleDate());
            }
        });
    }
}
