package models;

public final class Customer {
    
    private int id;
    private String firstName;
    private String lastName;
    
    	public Customer(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
        }
        
        public Customer(int Id, String firstName, String lastName){
                this.setId(Id);
                this.setFirstName(firstName);
                this.setLastName(lastName);
        }
        
        public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
        
        public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
        
        public String getLastName() {
		return lastName;
	}
        
        public void setLastName(String lastName) {
		this.lastName = lastName;
	}
        
        @Override
	public String toString() {
		return "id:" + id + " Customer name:" + firstName + " " + lastName;
	}
        
  
    
    
}