package org.example;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CarsDAO {

        public void addCars(Cars cars) throws SQLException;
        public void removeCars(Cars cars) throws SQLException;
        public Cars getCars(String name) throws SQLException;
        public ArrayList<Cars> getAllCars() throws SQLException;
    }


