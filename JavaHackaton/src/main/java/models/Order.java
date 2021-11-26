package classes;
import java.util.ArrayList;
import Items;

public class Order {
    public int cost;
    ArrayList<Items> items = new ArrayList<Items>();

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public ArrayList<Items> getItems(ArrayList<Items> items){
        return items;
    }

    public void ArrayList<Items> addItem(Item item){
        this.items = this.items.add(item);
    }
}
