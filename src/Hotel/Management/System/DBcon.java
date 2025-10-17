package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBcon {
    Connection connection;
    Statement statement;

    public DBcon(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS", "root", "kiranp555");
            // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS", "root", "Kirang555");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}