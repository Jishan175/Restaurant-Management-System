package ClassFile;
import java.sql.*;
class CustomerInfo{
	private String name;
	private String username;
	private String address;
	private String gender;
	private String contactNo;
	private String password;
	private String email;
	/*declaring  a constructor for setting information of user*/
	public CustomerInfo(String name,String username,String address,String gender,String contactNo,String password,String email){
		this.name=name;
		this.username=username;
		this.address=address;
		this.gender=gender;
		this.contactNo=contactNo;
		this.password=password;
		this.email=email;
	}
	/*set and get method for 
	set and get information 
	individually
	*/
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setUserName(String username){
		this.username=username;
	}
	public String getUserName(){
		return this.username;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return this.gender;
	}
	public void setContactNo(String contactNo){
		this.contactNo=contactNo;
	}
	public String getContactNo(){
		return this.contactNo;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return this.email;
	}

}