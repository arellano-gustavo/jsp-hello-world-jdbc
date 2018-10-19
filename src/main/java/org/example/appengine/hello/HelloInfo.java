package org.example.appengine.hello;

import java.sql.*;

public class HelloInfo {
    String error = "";
    private Connection c = null;
    private static HelloInfo instance = null;

    public static HelloInfo getInstance() {
        if (instance == null) {
            instance = new HelloInfo();
        }
        return instance;
    }

    private HelloInfo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            error = "ERROR: failed to load HSQLDB JDBC driver.";
        }
        try {
            this.c = DriverManager.getConnection("jdbc:mysql://13.56.211.236:3306/goose?autoReconnect=true", "oscar", "oscar");
            Statement stmt = c.createStatement();
            stmt.execute("CREATE TABLE PERSON(id int primary key, user varchar(255), password varchar(255))");
            stmt.execute("INSERT INTO PERSON(id, user, password) VALUES(1, 'Anju', 'Anju')");
            stmt.execute("INSERT INTO PERSON(id, user, password) VALUES(2, 'Sonia', 'Sonia')");
            stmt.execute("INSERT INTO PERSON(id, user, password) VALUES(3, 'Asha', 'Asha')");

            String sql = "SELECT * FROM PERSON";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }

            stmt.close();
            c.commit();
        } catch (Exception e) {
            error = "ERROR: failed to make a connection to the db:" + e.getMessage();
        }
        if (error.length() > 0)
            System.out.println(error);
    }

    public boolean consulta(String user, String password) {
        try {
            Statement stmt = c.createStatement();
            String sql = "SELECT * FROM PERSON WHERE user = '" + user + "' and password = '" + password + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            boolean flag = false;
            while (rs.next()) {
                System.out.println(rs.getString(2) + " " + rs.getString(3));
                flag = true;
            }

            if (flag) {
                System.out.println("si hay");
                return true;
            } else {
                System.out.println("chinnnn");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static String getInfo() {
        return "Version: " + 
                System.getProperty("java.version") + " OS: " + 
                System.getProperty("os.name") + " User: "+ 
                System.getProperty("user.name");
    }
}
