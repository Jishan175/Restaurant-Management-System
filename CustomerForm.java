package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
class CustomerForm extends JFrame implements ActionListener{
	/*creating component*/
	JLabel label1=new JLabel("MENU");
	JLabel label2=new JLabel("PRICE");
	JLabel label3=new JLabel("QUANTITY");
	JLabel label4=new JLabel("Total Cost");
	JTextField textfield1=new JTextField();
	JPanel jp=new JPanel();
	JCheckBox cbox1=new JCheckBox("Home Delivery");
	Border border1=BorderFactory.createLineBorder(Color.black,2);
	Border border2=BorderFactory.createLineBorder(Color.black,1);
	JButton button1=new JButton("Order");
	JButton button2=new JButton("Log Out");
	JButton button3=new JButton("Update Information");
	public CustomerForm(){
		try{
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			ResultSet rs=null;
			Statement st=null;
			String s;
			st=con.createStatement();
			s="select * from menu";
			rs=st.executeQuery(s);
			ResultSetMetaData rsmt=rs.getMetaData();
			int count=rsmt.getColumnCount();
			/*creating a new Jtable by retriving 
			data from database*/
			Vector column=new Vector(count);
			for(int i=1; i<=count; i++){
				column.add(rsmt.getColumnName(i));
			}
			Vector data=new Vector();
			Vector row=new Vector();
			while(rs.next()){
				row=new Vector(count);
				for(int i=1; i<=count; i++){
					row.add(rs.getString(i));
				}
				data.add(row);
			}
			setSize(600,300);
			setLocationRelativeTo(null);
			JTable jt=new JTable(data,column);
			jt.setFont(new Font("Arial",Font.ITALIC,15));
			jt.setBackground(Color.darkGray);
			jp.setForeground(Color.white);
			JScrollPane sp=new JScrollPane(jt);
			jt.setBackground(Color.white);
			add(sp,BorderLayout.CENTER);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		jp.setBackground(Color.darkGray);
		jp.add(button2);
		jp.add(button1);
		jp.add(button3);
		add(jp,BorderLayout.NORTH);
		setVisible(true);
		setResizable(false);
		/*adding button to the addActionListener for performing action*/
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1){
			Order o=new Order();
			o.orderMenu();
			this.setVisible(false);
		}else if(a.getSource()==button2){
			LoginForm lf=new LoginForm();
			this.setVisible(false);
		}else if(a.getSource()==button3){
			CustomerUpdateForm cuf=new CustomerUpdateForm();
			cuf.updateForm();
			this.setVisible(false);
		}
		
	}
}