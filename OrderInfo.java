package ClassFile;
class OrderInfo{
	private String name;
	private String phoneNo;
	private String itemID;
	private int quantity;
	private String address;
	/*
	setting order information for a customer
	*/
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setPhoneNo(String phoneNo){
		this.phoneNo=phoneNo;
	}
	public String getPhoneNo(){
		return this.phoneNo;
	}
	public void setItemID(String itemID){
		this.itemID=itemID;
	}
	public String getItemID(){
		return this.itemID;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public int getQuantity(){
		return this.quantity;
	}
}