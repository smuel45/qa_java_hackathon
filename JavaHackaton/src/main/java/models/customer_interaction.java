package com.hackathon.command_line_stuff;

public class customer_interaction {

    public static void main(){
        print("what would you like to do?");
        print_menu();
        String user_input = "";
        int user_choice = 0;
        while (user_choice == 0){
            user_input = Main.get_input("Input: ");
            try{
                user_choice = Integer.parseInt(user_input);
            }
            catch(Exception ex){
                print("enter valid selection (1-14)");
            }   
        } 
        switch(user_choice){
            case(1):
                //add customer
                
                break;
            case(2):
                //view all customers
                break;
            case(3):
                //update customer
                break;
            case(4):
                //delete customer
                break;
            case(5):
                //add item
                break;
            case(6):
                //view all items
                break;
            case(7):
                //update item
                break;
            case(8):
                //delete item
                break;
            case(9):
                //create order
                break;
            case(10):
                //view all orders
                break;
            case(11):
                //delete order
                break;
            case(12):
                //add item to order
                break;
            case(13):
                //calculate cost for order
                break;
            case(14):
                //delete item in order
                break;
        }
    }
    
    public static void print_menu(){
        print("1. Add a customer to the system"); 
	print("2. View all customers in the system");
	print("3. Update a customer in the system");
	print("4. Delete a customer in the system");
	print("5. Add an item to the system");
	print("6. View all items in the system");
	print("7. Update an item in the system");
	print("8. Delete an item in the system"); 
	print("9. Create an order in the system");
	print("10. View all orders in the system"); 
	print("11. Delete an order in the system");
	print("12. Add an item to an order");
	print("13. Calculate a cost for an order"); 
	print("14. Delete an item in an order");
    }
    
    public static void print(String to_print){
        System.out.println(to_print);
    }
}
