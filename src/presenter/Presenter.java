package presenter;

import model.*;
import persistence.MyFile;
import utilities.MyUtils;
import view.JFrameMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter implements ActionListener {


    private JFrameMainWindow mainWindow;
    private SalesManager salesManager;
    private UserManager userManager;

    private String pathFile;
    private MyFile myFile;

    private int fileTypeSelection = 0;

    public Presenter(){
        userManager = new UserManager();
        salesManager = new SalesManager();
        mainWindow = new JFrameMainWindow(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (EVENTS.valueOf(e.getActionCommand())){

            case C_LOAD_FILE_USER:
                fileTypeSelection = 0;
                showJFileChooser();
                break;

            case C_LOAD_FILE_SALES:
                fileTypeSelection = 1;
                showJFileChooser();
                break;

            case C_SHOW_PERCENTAGE_TABLE:
                showTablePercentageByAge(userManager.getAverageUserByAge());
                break;

            case C_SHOW_GENERAL_SALES:
                showTableGeneralSales(salesManager.getListSale());
                break;

            case C_SHOW_TABLE_SALES_BY_DATE:
                showTableOrderSalesByDate(salesManager.getListSale());
                break;

            case C_SHOW_TABLE_USER_NUMSALE:
                showTableNumSaleByUser(salesManager.getListSale());
                break;

            case C_EXPORT_FILES:
                exportFileUser();
                break;

        }
    }

    public void showTableNumSaleByUser(ArrayList<Sale> sale){
        mainWindow.showTableNumSaleByUser(sale);
    }

    public void showTablePercentageByAge(Double[]average){
        mainWindow.showTablePercentageByAge(average);
    }

    public void showTableOrderSalesByDate(ArrayList<Sale> sales){
        mainWindow.showTableOrderSalesByDate(sales);
    }

    public void showTableGeneralSales(ArrayList<Sale> sales){
        mainWindow.showTableGeneralSales(sales);
    }


    private void showJFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int jfcResult = fileChooser.showOpenDialog(mainWindow);
        switch (jfcResult){
            case JFileChooser.APPROVE_OPTION:
                pathFile = fileChooser.getSelectedFile().getAbsolutePath();

                if (new File(pathFile).canRead()){
                    myFile = new MyFile(pathFile);
                    switch (fileTypeSelection){
                        case 0:
                            startAppUser(pathFile);
                            break;
                        case 1:
                            startAppSales(pathFile);
                            break;
                    }
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Cancelado por el usuario");
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("Error de seleccion");
                break;
        }
    }


    //Leer usuarios
    private void startAppUser(String pathFile) {
        try{
            ArrayList<String> stringList = myFile.readFile(pathFile);
            manageTokenizeLinesUser(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void manageTokenizeLinesUser(ArrayList<String> stringList) {
        for (String string: stringList) {
            String [] aux = MyUtils.splitLine(string);
            if(aux.length == 6){
                userManager.addUser(new User(aux[0],
                        aux[1],
                        aux[2],
                        DocumentType.valueOf(aux[3]),
                        Gender.valueOf(aux[4]),
                        getDataOfString(aux[5])));
            }
            userManager.addUserToListExport(new User(aux[0],
                    aux[1],
                    aux[2],
                    DocumentType.valueOf(aux[3]),
                    Gender.valueOf(aux[4]),
                    getDataOfString(aux[5]),
                    userManager.determineAgeRange(getDataOfString(aux[5]))));
        }
    }

    //Leer Sales
    private void startAppSales(String pathFile) {
        try{
            ArrayList<String> stringList = myFile.readFile(pathFile);
            manageTokenizeLinesSales(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void manageTokenizeLinesSales(ArrayList<String> stringList) {
        for (String string: stringList) {
            String [] aux = MyUtils.splitLine(string);
            if(aux.length == 5){
                salesManager.addSales(new Sale(
                        aux[0],
                        getDataOfString(aux[1]),
                        Integer.parseInt(aux[2]),
                        aux[3],
                        Double.parseDouble(aux[4])));
            }
            salesManager.addSalesToListExport(new Sale(
                    aux[0],
                    getDataOfString(aux[1]),
                    Integer.parseInt(aux[2]),
                    aux[3],
                    Double.parseDouble(aux[4]),
                    Double.parseDouble(aux[4]),
                    Double.parseDouble(aux[4])));
        }
    }


    public LocalDate getDataOfString(String data){
        String temp [] = data.split("/");
        return LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
    }

    //Escritura archivo User

    public void exportFileUser(){
        try {
            writeFileTwo("resources/UserExport.txt", listWrite());
            writeFileOne("resources/SalesExport.txt", listWriteSale());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    private void writeFileOne(String nameFile, ArrayList<Sale> list) throws FileNotFoundException {
        File file = new File(nameFile);
        PrintWriter writerOut = new PrintWriter(file);
        for (int i = 0; i < list.size(); i++) {
            writerOut.println(list.get(i));
        }
        writerOut.close();
    }

    public static void writeFileTwo(String nameFile, ArrayList<User>list) throws FileNotFoundException {
        File file = new File(nameFile);
        PrintWriter writerOut = new PrintWriter(file);
        for (int i = 0; i < list.size(); i++) {
            writerOut.println(list.get(i));
        }
        writerOut.close();
    }

    public ArrayList<User> listWrite(){
        ArrayList<User> list = new ArrayList<User>();
        for (int i = 0; i < userManager.getListUserExport().size(); i++) {
            list.add(userManager.getListUserExport().get(i));
        }
        userManager.ordEmployeeForLastName(list);
        return list;
    }

    private ArrayList<Sale> listWriteSale() {
        ArrayList<Sale> list = new ArrayList<Sale>();
        for (int i = 0; i < salesManager.getListSaleExport().size(); i++) {
            list.add(salesManager.getListSaleExport().get(i));
        }
        salesManager.orderDateSales(list);
        return list;
    }



}
