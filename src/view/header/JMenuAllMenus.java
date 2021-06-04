package view.header;

import presenter.EVENTS;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class JMenuAllMenus extends JToolBar {

    private JMenuBar menuBar;
    private JMenu menuLoadFiles, menuReports, menuWriteFile, menuAbout;
    private JMenuItem loadUser, loadSales, exit, averageUsers, generalSales, totalSales, numSales, exportFile;

    private Presenter myPresenter;

    public JMenuAllMenus(Presenter presenter){
        myPresenter = presenter;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        //this.setBackground(Color.DARK_GRAY);
        this.setFloatable(false);
        initComponents();
    }

    private void initComponents() {
        menuBar = new JMenuBar();

        menuLoadFiles = new JMenu("Menu archivo");
        menuReports = new JMenu("Menu informes");
        menuWriteFile = new JMenu("Menu datos");
        menuAbout = new JMenu("Acerca de");

        loadUser = new JMenuItem("Cargar clientes");
        loadSales = new JMenuItem("Cargar ventas");
        exit = new JMenuItem("Salir");
        averageUsers = new JMenuItem("Porcentaje de usuarios");
        generalSales = new JMenuItem("Ventas generales");
        totalSales = new JMenuItem("Ventas totales");
        numSales = new JMenuItem("Numero de compras");
        exportFile = new JMenuItem("Exportar resultados");

        addItemsToMenuLoadFile();
        addItemsToMenuReports();
        addItemsToMenuWriteFile();
        addItemAbout();
    }

    private void addItemsToMenuLoadFile() {

        loadUser.addActionListener(myPresenter);
        loadUser.setActionCommand(EVENTS.C_LOAD_FILE_USER.toString());
        menuLoadFiles.add(loadUser);
        menuLoadFiles.addSeparator();

        loadSales.addActionListener(myPresenter);
        loadSales.setActionCommand(EVENTS.C_LOAD_FILE_SALES.toString());
        menuLoadFiles.add(loadSales);
        menuLoadFiles.addSeparator();
        menuLoadFiles.add(exit);

        menuBar.add(menuLoadFiles);
    }

    private void addItemsToMenuReports() {
        averageUsers.addActionListener(myPresenter);
        averageUsers.setActionCommand(EVENTS.C_SHOW_PERCENTAGE_TABLE.toString());
        menuReports.add(averageUsers);
        menuReports.addSeparator();

        generalSales.addActionListener(myPresenter);
        generalSales.setActionCommand(EVENTS.C_SHOW_GENERAL_SALES.toString());
        menuReports.add(generalSales);
        menuReports.addSeparator();

        totalSales.addActionListener(myPresenter);
        totalSales.setActionCommand(EVENTS.C_SHOW_TABLE_SALES_BY_DATE.toString());
        menuReports.add(totalSales);
        menuReports.addSeparator();


        numSales.addActionListener(myPresenter);
        numSales.setActionCommand(EVENTS.C_SHOW_TABLE_USER_NUMSALE.toString());
        menuReports.add(numSales);

        menuBar.add(menuReports);
    }

    private void addItemsToMenuWriteFile() {

        exportFile.addActionListener(myPresenter);
        exportFile.setActionCommand(EVENTS.C_EXPORT_FILES.toString());
        menuWriteFile.add(exportFile);

        menuBar.add(menuWriteFile);
    }

    private void addItemAbout() {
        menuBar.add(menuAbout);
        this.add(menuBar);
    }


}
