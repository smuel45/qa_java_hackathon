package com.hackathon.command_line_stuff;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static Connection con = null;
    public static void main(String[] args) throws SQLException {
	System.out.println("test");
	print(get_input("test"));
        database_connect();
        ArrayList<ArrayList<String>> new_items = new ArrayList<>();
        ArrayList<String> record = new ArrayList<>();
        record.add(0, "1");
        record.add(1, "Bloggs,Joe");
        record.add(2, "10 downing street");
        new_items.add(record);
        record.clear();
        record.add(0, "2");
        record.add(1, "Smith, John");
        record.add(2, "buckingham palace, london");
        new_items.add(record);
        update_customer(new_items, "insert");
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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbName = "";
            String userName = "admin";
            String password = "gyntEg-datmit-qycdy5";
            String hostname = "qa.cqkfae7mcclh.eu-west-2.rds.amazonaws.com";
            String port = "3306";
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            print("Getting remote connection with connection string from environment variables.");
            con = DriverManager.getConnection(jdbcUrl);
            print("Remote connection successful.");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<String[]> query_item(String sqlstatement) throws SQLException {
        Statement stmt = con.createStatement();
        ArrayList<String[]> items = new ArrayList<>();
        try (ResultSet resultSet = stmt.executeQuery(sqlstatement)) {
            while (resultSet.next()) {
                String[] item = new String[3];
                item[0] = resultSet.getString("id");
                item[1] = resultSet.getString("name");
                item[2] = resultSet.getString("address");
                items.add(item);
            }
        }
        return items;
    }

    private static boolean update_customer(ArrayList<ArrayList<String>> items, String action) throws SQLException {
        Statement stmt = con.createStatement();

        int length = items.size();

        if(action.equals("insert")){
            for (int i = 0; i < length; i++) {
                String statement = "INSERT INTO customer (id, name, value) " +
                        "VALUES (" + items.get(i).get(0) + ", " + items.get(i).get(1) + ", " + items.get(i).get(2) + ");";
                stmt.executeUpdate(statement);
            }
        }
        if(action.equals("update")){
            for (int i = 0; i < length; i++) {
                String statement = "UPDATE customer " +
                        "SET name= '" + items.get(i).get(1) + "', value= '" + items.get(i).get(2) + "'" +
                        "WHERE id = '" + items.get(i).get(0) + "';";
                stmt.executeUpdate(statement);
            }
        }
        if(action.equals("delete")){
            for (int i = 0; i < length; i++) {
                String statement = "DELETE FROM customer WHERE id = '" + items.get(i).get(0) + "';";
                stmt.executeUpdate(statement);
            }
        }


        return true;
    }
}
