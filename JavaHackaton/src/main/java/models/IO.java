package com.hackathon.command_line_stuff;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
	System.out.println("test");
	print(get_input("test"));
        database_connect();
    }
	
    public static void print(String to_print) {
        System.out.println(to_print);
    }

    public static String get_input(String entry) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(entry + ":");
        String to_return = myObj.nextLine();  // Read user input
        return (to_return);
    }
    
    public static void database_connect() {
        Connection conn = null;
        try {

            String dbURL = "jdbc:mysql://qa.cqkfae7mcclh.eu-west-2.rds.amazonaws.com";
            String user = "admin";
            String pass = "gyntEg-datmit-qycdy5";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
