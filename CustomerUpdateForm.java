package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

class CustomerUpdateForm extends JFrame implements ActionListener{
	public static String name;
	public static String username;
	public static String address;
	public static String contactNo;
	public static String password;
	public static String email;
	
	public void setInfo(String username){
		this.username=username;
		try{
			Connection con=null;
			DatabaseManager db=new DatabaseManager();
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement st=null;
			st=con.createStatement();
			String sql="SELECT * FROM customer WHERE Username LIKE '"+username+"' ";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				this.name=rs.getString("Name");
				this.address=rs.getString("Address");
				this.contactNo=rs.getString("Contact No.");
				this.password=rs.getString("Password");
				this.email=rs.getString("Email");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	JLabel label1=new JLabel("Name");
	JLabel label2=new JLabel("Username");
	JLabel label3=new JLabel("Address");
	JLabel label4=new JLabel("Contact No.");
	JLabel label5=new JLabel("Password");
	JLabel label6=new JLabel("Repeat Password");
	JLabel label7=new JLabel("Email");
	JTextField textfield1=new JTextField();
	JTextField textfield2=new JTextField();
	JTextField textfield3=new JTextField();
	JTextField textfield4=new JTextField();
	JTextField textfield5=new JTextField();
	JPasswordField pass1=new JPasswordField();
	JPasswordField pass2=new JPasswordField();
	JButton button1=new JButton("Update Information");
	Border border1=BorderFactory.createLineBorder(Color.black,2);
	Border border2=BorderFactory.createLineBorder(Color.black,1);
	public void  updateForm(){
		setTitle("Update Information");
		setSize(500,600);
		setLocationRelativeTo(null);
		setResizable(false);
		/*setting a background
		image in the frame*/
		this.setContentPane(new JLabel(new ImageIcon("registrationform.jpg")));
		setVisible(true);//visible the jframe
		/*
			setting all Label and 
			Textfield to the jframe
		*/
		label1.setBounds(85,90,110,30);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label1);
		setLayout(null);
		label2.setBounds(85,130,110,30);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label2);
		setLayout(null);
		label3.setBounds(85,170,110,30);
		label3.setForeground(Color.white);
		label3.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label3);
		setLayout(null);
		label4.setBounds(85,210,110,30);
		label4.setForeground(Color.white);
		label4.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label4);
		setLayout(null);
		label5.setBounds(85,250,110,30);
		label5.setForeground(Color.white);
		label5.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label5);
		setLayout(null);
		label6.setBounds(85,290,110,30);
		label6.setForeground(Color.white);
		label6.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label6);
		setLayout(null);
		label7.setBounds(85,330,110,30);
		label7.setForeground(Color.white);
		label7.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label7);
		setLayout(null);
		textfield1.setBounds(200,90,125,30);
		textfield1.setBorder(border1);
		textfield1.setBackground(Color.lightGray);
		textfield1.setForeground(Color.black);
		textfield1.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield1);
		textfield2.setBounds(200,130,125,30);
		textfield2.setBorder(border1);
		textfield2.setBackground(Color.lightGray);
		textfield2.setForeground(Color.black);
		textfield2.setFont(new Font("Arial",Font.BOLD,13));
		textfield2.setEditable(false);
		add(textfield2);
		textfield3.setBounds(200,170,125,30);
		textfield3.setBorder(border1);
		textfield3.setBackground(Color.lightGray);
		textfield3.setForeground(Color.black);
		textfield3.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield3);
		textfield4.setBounds(200,210,125,30);
		textfield4.setBorder(border1);
		textfield4.setBackground(Color.lightGray);
		textfield4.setForeground(Color.black);
		textfield4.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield4);
		pass1.setBounds(200,250,125,30);
		pass1.setBorder(border1);
		pass1.setBackground(Color.lightGray);
		pass1.setForeground(Color.black);
		add(pass1);
		pass2.setBounds(200,290,125,30);
		pass2.setBorder(border1);
		pass2.setBackground(Color.lightGray);
		pass2.setForeground(Color.black);
		add(pass2);
		textfield5.setBounds(200,330,125,30);
		textfield5.setBorder(border1);
		textfield5.setBackground(Color.lightGray);
		textfield5.setForeground(Color.black);
		textfield5.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield5);
		button1.setBounds(180,380,120,30);
		button1.setBorder(border2);
		add(button1);
		setLayout(null);
		textfield1.setText(name);
		textfield2.setText(username);
		textfield3.setText(address);
		textfield4.setText(contactNo);
		pass1.setText(password);
		pass2.setText(password);
		textfield5.setText(email);
		button1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1){
			if(pass1.getText().toString().equals(pass2.getText())){//check repeat password is same or not
				DatabaseManager db=new DatabaseManager();
				db.setCustomerUpdate(textfield1.getText(),textfield2.getText(),textfield3.getText(),textfield4.getText(),pass1.getText(),textfield5.getText());
				JOptionPane.showMessageDialog(this,"Successfully Updated");
				CustomerForm cf=new CustomerForm();
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this,"Password doesn't match");
			}
		}
	}
}