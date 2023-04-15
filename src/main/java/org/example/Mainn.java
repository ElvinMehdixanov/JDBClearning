package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public class Mainn {public static void main(String[] args) throws ClassNotFoundException, SQLException {
    String url = "jdbc:postgresql://localhost:5432/lcwaikiki";
    String user  = "postgres";
    String password = "1961";
    CarsJDBC pjdbs = new CarsJDBC(url,user,password);

    Cars cars = new Cars();

    cars.setMarka("Toyota");
    cars.setModel("Prius");
    cars.setColor("Grey");
    cars.setYear(2007);
    cars.setPrice(13000);

    pjdbs.addCars(cars);

    ArrayList<Cars> array = pjdbs.getAllCars();

    for (Cars i:array) {
        System.out.println(i.getMarka()+ ",you model is " + i.getModel()+", " +i.getYear() + ", " +i.getColor());

    }
    System.out.println(pjdbs.getCars("Prius").getModel());
    pjdbs.removeCars(cars);




}
}

