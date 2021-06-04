package view;

import model.Sale;
import presenter.Presenter;
import view.body.JPContainerBody;
import view.header.JPContainerHeader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPMainPanel extends JPanel {

    private Presenter myPresenter;

    private JPContainerHeader jpContainerHeader;
    private JPContainerBody jpContainerBody;

    public JPMainPanel(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BorderLayout());
        setBackground(Color.white);
        initComponents();
    }

    private void initComponents() {

        jpContainerHeader = new JPContainerHeader(myPresenter);
        add(jpContainerHeader, BorderLayout.PAGE_START);

        jpContainerBody = new JPContainerBody(myPresenter);
        add(jpContainerBody,BorderLayout.CENTER);
    }

    public void showTablePercentageByAge(Double[]average){
        jpContainerBody.showTablePercentageByAge(average);
    }

    public void showTableOrderSalesByDate(ArrayList<Sale> sales){
        jpContainerBody.showTableOrderSalesByDate(sales);
    }

    public void showTableGeneralSales(ArrayList<Sale> sales){
        jpContainerBody.showTableGeneralSales(sales);
    }

    public void showTableNumSaleByUser(ArrayList<Sale> sale){
        jpContainerBody.showTableNumSaleByUser(sale);
    }


}
