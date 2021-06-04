package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> listUser;
    private ArrayList<User> listUserExport;
    private int countMinors, countAdults, countElderly = 0;

    public UserManager(){
        listUser = new ArrayList<>();
        listUserExport = new ArrayList<>();
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public ArrayList<User> getListUserExport() {
        return listUserExport;
    }

    public void setListUserExport(ArrayList<User> listUserExport) {
        this.listUserExport = listUserExport;
    }

    public void addUser(User user){
        listUser.add(user);
    }


    public Double[] getAverageUserByAge(){
        return new Double[]{calculateAverageMinors(), calculateAverageAdults(), calculateAverageElderly()};

    }

    public double calculateAverageMinors(){
        double percentage = 0;
        for (int i = 0; i < listUser.size(); i++)
            if (determineAgeRange(listUser.get(i).getBirthDay()) < 18)
                countMinors++;
        percentage = (countMinors * 100)/ listUser.size();
        return percentage;

    }

    public double calculateAverageAdults(){
        double percentage = 0;
        for (int i = 0; i < listUser.size(); i++)
            if (determineAgeRange(listUser.get(i).getBirthDay()) > 18 && determineAgeRange(listUser.get(i).getBirthDay()) <= 40 )
                countAdults++;
        percentage = (countAdults * 100)/ listUser.size();
        return percentage;
    }

    private double calculateAverageElderly() {
        double percentage = 0;
        for (int i = 0; i < listUser.size(); i++)
            if (determineAgeRange(listUser.get(i).getBirthDay()) > 40 && determineAgeRange(listUser.get(i).getBirthDay()) <= 70)
                countElderly++;
        percentage = (countElderly * 100)/ listUser.size();
        return percentage;
    }

    public int determineAgeRange(LocalDate birthDate) {
        int age = 0;
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(birthDate, ahora);
        age = periodo.getYears();
        return age;
    }

    public void addUserToListExport(User user) {
        listUserExport.add(user);
    }

    public ArrayList<User> ordEmployeeForLastName(ArrayList<User> ordList) {
        for(int i = 0; i < ordList.size() - 1; ++i) {
            for(int j = i + 1; j < ordList.size(); ++j) {
                if (((User)ordList.get(i)).getLastName().compareToIgnoreCase(((User)ordList.get(j)).getLastName()) > 0) {
                    User aux = (User) ordList.get(i);
                    ordList.set(i, (User) ordList.get(j));
                    ordList.set(j, aux);
                }
            }
        }

        return ordList;
    }
}
