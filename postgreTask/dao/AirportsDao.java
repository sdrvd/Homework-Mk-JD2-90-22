package postgreTask.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;

public class AirportsDao {
    private DataSource ds;

    public void AirportsPoolDao(){
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");
        this.ds = pool;
    }


    public void airportsFromDataBase(String city) {
        ArrayList list = new ArrayList();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT\n" +
                            "    airport_code,\n" +
                            "    airport_name,\n" +
                            "    city,\n" +
                            "    timezone\n" +
                            "FROM\n" +
                            "    bookings.airports\n" +
                            "WHERE city = '" + city + "';"
            );
            while (resultSet.next()){
                System.out.println(resultSet.getString("airport_code"));
                System.out.println(resultSet.getString("airport_name"));
                System.out.println(resultSet.getString("city"));
                System.out.println(resultSet.getString("timezone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printAirports(ArrayList<ResultSet> list){
        for (int i = 1; i < list.size(); i++) {
            ResultSet print = list.get(i);
            try {
                System.out.println(print.getString("airport_code"));
                System.out.println(print.getString("airport_name"));
                System.out.println(print.getString("city"));
                System.out.println(print.getString("timezone"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
