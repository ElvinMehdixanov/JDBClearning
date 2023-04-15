package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class CarsJDBC implements CarsDAO{
    private Connection connection;
    public CarsJDBC(String url, String user, String password) throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(url, user, password);
    }
    public void addCars(Cars cars)throws SQLException{
        String sql = "insert into cars(marka, model, year, color, price)"+"values(?,?,?,?,?)";
        PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1,cars.getMarka());
        ps.setString(2, cars.getModel());
        ps.setInt(3, cars.getYear());
        ps.setString(4, cars.getColor());
        ps.setInt(5,cars.getPrice());

        ps.executeUpdate();

    }
    public void removeCars(Cars cars) throws SQLException {
        String sql = "delete from cars where model = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(2, cars.getModel());
        ps.executeUpdate();}
public Cars getCars(String marka) throws SQLException{
    ArrayList<Cars>array = getAllCars();
    for (Cars cars:array) {
        if (cars.getMarka().equals(marka)){
            return cars;
        }
    }
    return null;
    }
    public ArrayList<Cars> getAllCars() throws SQLException {
        ArrayList<Cars> array = new ArrayList<Cars>();
        ResultSet result = this.connection.prepareStatement("select * from cars").executeQuery();
        while (result.next()) {
            Cars cars = new Cars();
            cars.setMarka(result.getString("Hyundai"));
            cars.setModel(result.getNString("iX35"));
            cars.setYear(result.getInt(2020));
            cars.setColor(result.getString("Red"));
            cars.setPrice(result.getInt(24000));
            array.add(cars);
        }
        result.close();
        return array;
    }

}


