package databaseconnection;

import models.Item;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net
 *
 */
public class JdbcSQLServerConnection {

    private static Connection conn;

    public static void getConnection() {

        Connection conn = null;

        try {

            String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
            String user = "sa";
            String pass = "secret";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static List<Item> QueryItem(String sqlstatement) throws SQLException {
        Statement stmt = conn.createStatement();
        List<Item> items = new ArrayList<>();
        try (ResultSet resultSet = stmt.executeQuery(sqlstatement)) {
            while (resultSet.next()) {
                Item ite = new Item(resultSet.getLong("id"),
                        resultSet.getString("name") ,
                        resultSet.getFloat("value"));

                items.add(ite);
            }
        }
        return items;
    }

    private static boolean UpdateItem(List<Item> items, String action) throws SQLException {
        Statement stmt = conn.createStatement();

        int length = items.size();

        if(action == "insert"){
            for (int i = 0; i < length; i++) {
                String statement = "INSERT INTO item (id, name, value) " +
                        "VALUES (" + items.get(i).getId() + ", " + items.get(i).getItemName() + ", " + items.get(i).getItemValue() + ");";
                stmt.executeUpdate(statement);
            }
        }
        if(action == "update"){
            for (int i = 0; i < length; i++) {
                String statement = "UPDATE item " +
                        "SET name= '" + items.get(i).getItemName() + "', value= '" + items.get(i).getItemValue() + "'" +
                        "WHERE id = '" + items.get(i).getId() + "';";
                stmt.executeUpdate(statement);
            }
        }
        if(action == "delete"){
            for (int i = 0; i < length; i++) {
                String statement = "DELETE FROM item WHERE id = '" + items.get(i).getId() + "';";
                stmt.executeUpdate(statement);
            }
        }


        return true;
    }



}
