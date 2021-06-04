package view;

import model.Sale;
import presenter.Presenter;

import javax.swing.*;
import java.util.ArrayList;

public class JFrameMainWindow extends JFrame {

    private JPMainPanel mainPanel;
    private Presenter myPresenter;

    public JFrameMainWindow(Presenter presenter) {
        myPresenter = presenter;
        setExtendedState(MAXIMIZED_BOTH);
        setSize(600, 400);
        //setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.LOGO_PAGE)).getImage());
        setTitle("ABC SISTEMAS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new JPMainPanel(myPresenter);
        JScrollPane jsPMainPanel = new JScrollPane();
        jsPMainPanel.setViewportView(mainPanel);
        jsPMainPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(jsPMainPanel);
    }

    public void showTablePercentageByAge(Double[]average){
        mainPanel.showTablePercentageByAge(average);
    }
    public void showTableOrderSalesByDate(ArrayList<Sale> sales){
        mainPanel.showTableOrderSalesByDate(sales);
    }

    public void showTableGeneralSales(ArrayList<Sale> sales){
        mainPanel.showTableGeneralSales(sales);
    }

    public void showTableNumSaleByUser(ArrayList<Sale> sale){
        mainPanel.showTableNumSaleByUser(sale);
    }

}

