package test_cases;

public class Item {

	float price;
	String item_name;
	
	public Item(float price, String item_name) 
	{
		this.price = price;
		this.item_name = item_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	public boolean change_item_price(float new_price) 
	{
		if (new_price > 0) 
		{
			this.price = new_price;
			return true;
		}else 
		{
			System.out.println("item price is not valid");
			return false;
		}

	}
	
}
