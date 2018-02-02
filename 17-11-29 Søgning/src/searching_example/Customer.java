package searching_example;

public class Customer {
	private String name;
	private int number;
	private int purchase;
	
	public Customer(String name, int number, int purchase) {
		this.name = name;
		this.number = number;
		this.purchase = purchase;
	}
	
	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public int getPurchase() {
        return this.purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
		return name + " " + number + " " +  purchase;
	}

}
