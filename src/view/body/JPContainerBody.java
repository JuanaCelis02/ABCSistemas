package view.body;

import model.Sale;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPContainerBody extends JPanel {

    private Presenter myPresenter;
    private JPTableElements jpTableElements;

    public JPContainerBody(Presenter presenter){
        myPresenter = presenter;
        this.setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        jpTableElements = new JPTableElements();
        this.add(jpTableElements,BorderLayout.CENTER);
    }

    public void showTablePercentageByAge(Double[]average){
       jpTableElements.showTablePercentageByAge(average);

    }

    public void showTableOrderSalesByDate(ArrayList<Sale> sales){
        jpTableElements.showTableOrderSalesByDate(sales);
    }

    public void showTableGeneralSales(ArrayList<Sale> sales){
        jpTableElements.showTableGeneralSales(sales);
    }

    public void showTableNumSaleByUser(ArrayList<Sale> sale){
        jpTableElements.showTableNumSaleByUser(sale);
    }

}
