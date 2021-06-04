package view.body;

import model.Sale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JPTableElements extends JPanel {

    private DefaultTableModel defaultTable;
    private JTable tableElements;
    private JScrollPane scrollTable;

    public JPTableElements(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.decode("#30373D"));
        initComponents();
    }

    private void initComponents() {
        defaultTable = new DefaultTableModel();

        tableElements = new JTable();
        tableElements.setModel(defaultTable);
        tableElements.getTableHeader().setReorderingAllowed(false);
        tableElements.getTableHeader().setBackground(new Color(120, 120, 120));

        //setSize

        tableElements.getTableHeader().setPreferredSize(new Dimension(150,50));
        tableElements.getTableHeader().setForeground(Color.WHITE);
        tableElements.setBackground(Color.WHITE);
        tableElements.setFillsViewportHeight(true);
        tableElements.setRowHeight(40);

        scrollTable = new JScrollPane(tableElements);
        scrollTable.setForeground(Color.WHITE);
        scrollTable.setAlignmentX(LEFT_ALIGNMENT);
        this.add(scrollTable);
    }

    public void showTablePercentageByAge(Double[]average){
        clearTable();
        String[] headers = {"Porcentaje menores de edad","18 - 40","41-70"};
        defaultTable.setColumnIdentifiers(headers);
        defaultTable.addRow(average);

    }

    public void showTableOrderSalesByDate(ArrayList<Sale> sales){
        clearTable();
        String [] headers = {"Usuario", "Fecha", "Cantidad", "Descripcion", "Precio"};
        defaultTable.setColumnIdentifiers(headers);
        loadSalesToList(sales);
    }

    public void showTableGeneralSales(ArrayList<Sale> sales){
        clearTable();
        String [] headers = {"Usuario", "Fecha", "Cantidad", "Descripcion", "Precio", "Impuesto", "Valor total"};
        defaultTable.setColumnIdentifiers(headers);
        loadSalesToListWithTaxes(sales);
    }

    public void showTableNumSaleByUser(ArrayList<Sale> sale){
        clearTable();
        String[] headers = {"Cliente","Numero de ventas"};
        defaultTable.setColumnIdentifiers(headers);
        loadSalesToListNumSaleByUser(sale);
    }

    private void loadSalesToListNumSaleByUser(ArrayList<Sale> salesList) {
        for (Sale sale : salesList)
            defaultTable.addRow(sale.getSalesByUser());
    }

    private void loadSalesToList(ArrayList<Sale> salesList) {
        for (Sale sale : salesList)
            defaultTable.addRow(sale.getSalesData());
    }

    private void loadSalesToListWithTaxes(ArrayList<Sale> salesList) {
        for (Sale sale : salesList)
            defaultTable.addRow(sale.getSalesGeneral());
    }

    private void clearTable() {
        defaultTable.setRowCount(0);
    }
}
