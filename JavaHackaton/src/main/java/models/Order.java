package classes;
import java.util.ArrayList;
import Items;

import java.util.ArrayList;
import java.util.List;

import databaseconnection.JdbcSQLServerConnection;
import models.Item;

public class Order {
    public int cost;
    public long orderID;
    public String customerID;

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public List<Item> getItems(){
        List<Item> result_item = new ArrayList<Item>();
        try {
            result_item = JdbcSQLServerConnection.QueryItem("Select i.id as id, i.name as name, i.value as value " +
                    "From Order o " +
                    "Inner join Item i on i.id = o.item_id Where o.id = '" + orderID + "';");
        }catch(Exception e){
            System.out.println("Get Item Error: " + e.getMessage());
        }

        return result_item;
    }

    public void addItem(Item item){
        List<Item> insert_item = new ArrayList<Item>();
        insert_item.add(item);
        try {
            JdbcSQLServerConnection.UpdateItem(insert_item, "insert");
        }catch(Exception e){
            System.out.println("Insert Item Error: " + e.getMessage());
        }
    }
}
