package models;

public class Item {
	private Long id;
	private String itemName;
	private float itemValue;
	
	public Item(String itemName, float itemValue) {
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}
	
	public Item(Long id, String itemName, float itemValue) {
		this.setId(id);
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public float getItemValue() {
		return itemValue;
	}
	
	public void setItemValue(float itemValue) {
		this.itemValue = itemValue;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " item name:" + itemName + " value: £" + itemValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
