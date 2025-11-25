package banking.system;

import java.sql.*;
import java.util.*;
import java.io.*;

public class conn {

    Connection c;  
    Statement s;

    public conn() {
        try {
            
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/banking/system/config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            c = DriverManager.getConnection(url, user, password);
            s = c.createStatement();

            System.out.println("Database connected successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new conn();
    }
}
