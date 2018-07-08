package ClassFile;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class DatabaseManager extends JFrame{
	static final String DB_URL ="jdbc:mysql://localhost:3306/restaurant";
	static final String username="root";
	 Connection con=null;
	 Statement st=null;
	public DatabaseManager(){
		getConnection();
	}
	/*get connection from database*/
	public void getConnection(){
		try{//connect to database
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DB_URL,username,"");
		}catch(SQLException se){
			JOptionPane.showMessageDialog(null,se);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	/*Inserting customer information in 
	the customer table in the database*/
	public void setCustomerInfo(CustomerInfo ci){
		try{
			st=con.createStatement();
			String sql= "INSERT INTO `customer` (`Name`, `Username`, `Address`, `Gender`, `Contact No.`, `Password`, `Email`) VALUES ('"+ci.getName()+"','"+ci.getUserName()+"','"+ci.getAddress()+"','"+ci.getGender()+"','"+ci.getContactNo()+"','"+ci.getPassword()+"','"+ci.getEmail()+"');";
			st.executeUpdate(sql);

		}catch(SQLException ex){
			System.out.println("Inserting Error ");
	}
	}
	/*Inserting employee information in 
	the employee table in the database*/
	public void setEmployeeInfo(EmployeeInfo ei){
		try{
			st=con.createStatement();
			String sql= "INSERT INTO `employee` (`Name`, `Username`, `Address`, `Gender`, `Contact No.`, `Password`, `Email`, `Salary`) VALUES ('"+ei.getName()+"','"+ei.getUserName()+"','"+ei.getAddress()+"','"+ei.getGender()+"','"+ei.getContactNo()+"','"+ei.getPassword()+"','"+ei.getEmail()+"','"+ei.getSalary()+"');";
			st.executeUpdate(sql);

		}catch(SQLException ex){
			System.out.println("Inserting Error ");
	}
	}
	/*Inserting menu information in 
	the menu table in the database*/
	public void setMenuInfo(MenuInfo mi){
		try{
			st=con.createStatement();
			String sql= "INSERT INTO `menu` (`Item ID`,`Item Name`, `Price`) VALUES ('"+mi.getMenuID()+"','"+mi.getMenuName()+"','"+mi.getMenuPrice()+"');";
			st.executeUpdate(sql);

		}catch(SQLException ex){
			System.out.println("Inserting Error ");
	}
	}
	/*Retrive cusotmer information from database
	and verify login */
	public void customerLogin(String username,String password){
		
		try{
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from customer where username= '"+username+"'and password='"+password+"';"); 
			int count=0;
					while(rs.next()){
						count=count+1;
					}
					if(count==1){
							CustomerUpdateForm cuf=new CustomerUpdateForm();
							cuf.setInfo(username);
							CustomerForm c=new CustomerForm();
							
						}else if(count==0){
						JOptionPane.showMessageDialog(null,"username and password doesn't match!");
						LoginForm lf=new LoginForm();
						this.setVisible(false);
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
		}
	}
	/*Retrive employee information from database
	and verify login */
	public void employeeLogin(String username,String password){
		try{
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from employee where username= '"+username+"'and password='"+password+"';"); 
			int count=0;
					while(rs.next()){
						count=count+1;
					}
					if(count==1){
							//this.setVisible(false);
							EmployeeDisplayForm ed=new EmployeeDisplayForm();
							
						}else if(count==0){
						JOptionPane.showMessageDialog(null,"Username and password doesn't match!");
						LoginForm lf=new LoginForm();
						this.setVisible(false);
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
		}
	}
	/*Deleting  employee information
	from database*/
	public void deleteEmployee(String name,String id){
		try{
			st=con.createStatement();
			String sql="delete  from employee where name= '"+name+"'and username='"+id+"';";
			st.executeUpdate(sql);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,ex);
		}
					
	}
	/*Deleting  menu information
	from database*/
	public void deleteMenuInfo(int itemID){
		try{
			st=con.createStatement();
			String sql="delete  from menu where `Item ID`= '"+itemID+"';";
			st.executeUpdate(sql);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,ex);
		}
	}
	/*Set information for cusotmer
	for order*/
	public void orderInfo(OrderInfo oii){
		String username=oii.getName();
		String pNo=null;
		String name=null;
		String address=null;
		try{
			st=con.createStatement();
			String sql="SELECT * FROM customer WHERE Username LIKE '"+username+"' ";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				pNo=rs.getString("Contact No.");
				name=rs.getString("Name");
				address=rs.getString("Address");
				oii.setName(name);
				oii.setPhoneNo(pNo);
				oii.setAddress(address);
				Order o=new Order();
				o.setInfo(oii);
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,ex);
		}
	}
	/*
	inserting order details into the database
	*/
	public void setOrderDetails(String name,String phone,String address,String[] a,String cost){
			String str=null;
			int i=0;
			str=a[0];
			while(a[i+1]!=null){
				str=str+";"+a[i+1];
				i++;
			}
			
		try{
			
			st=con.createStatement();
			String sql= "INSERT INTO `orderdetails` (`Customer Name`,`Customer Address`, `Customer PhoneNo.`, `Ordered Item & Quantity` , `Total`) VALUES ('"+name+"','"+address+"','"+phone+"','"+str+"','"+cost+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Order Successfull");
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,ex);
		}
	}
	/*
	updating employee information
	*/
	public void updateEmployeeInfo(String name,String username,String address,String contactNo,String email,String salary){
		double sal=Double.parseDouble(salary);
		try{
			st=con.createStatement();
			String sql="UPDATE `employee` SET `Name` = '"+name+"',`Address` = '"+address+"',`Contact No.` = '"+contactNo+"',`Email` = '"+email+"',`Salary` = '"+salary+"' WHERE `employee`.`Username` = '"+username+"';";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Updated Successfully");
			EmployeeList el=new EmployeeList();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,ex);
		}
	}
	/*
	updating menu information
	*/
	public void updateMenuInfo(String menuid,String menuname,String price){
		double p=Double.parseDouble(price);
		try{
			st=con.createStatement();
			String sql="UPDATE `menu` SET `Item Name` = '"+menuname+"',`Price` = '"+p+"' WHERE `menu`.`Item ID` = '"+menuid+"';";
			st.executeUpdate(sql);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	/*
	delete deliveredOrder information from database
	*/
	public void deliveredOrder(String[] a){
		int i=0;
		try{
		while(a[i]!=null){
			int serial=Integer.parseInt(a[i]);
			st=con.createStatement();
			String sql="delete  from orderdetails where `Order Number`= '"+serial+"';";
			st.executeUpdate(sql);
			i++;
		}
		JOptionPane.showMessageDialog(null,"Successfull");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	/*
	update cusotmer information from database
	*/
	public void setCustomerUpdate(String name,String username,String address,String contactNo,String password,String email){
		try{
			st=con.createStatement();
			String sql="UPDATE `customer` SET `Name` = '"+name+"',`Address` = '"+address+"',`Contact No.` = '"+contactNo+"',`Password` = '"+password+"',`Email` = '"+email+"' WHERE `customer`.`Username` = '"+username+"';";
			st.executeUpdate(sql);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	//close the database connection
	public void closeConnection(){
		try{
			if(st!=null){
				con.close();
			}
		}catch(SQLException se){

		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException se){

			}
	}

}
