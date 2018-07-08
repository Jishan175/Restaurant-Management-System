package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
class LoginForm extends JFrame implements ActionListener{
	/*creating a new comboBox*/
	JComboBox comboBox1=new JComboBox(new String[] {"--Select Member--","Admin","Customer","Employee"} );
	JLabel label1=new JLabel("Username");
	JLabel label2=new JLabel("Password");
	JTextField textField1=new JTextField();
	JPasswordField pass1=new JPasswordField();
	JButton button1=new JButton("Login");
	JButton button2=new JButton("Register");
	Border border1=BorderFactory.createLineBorder(Color.black,2);
	Border border2=BorderFactory.createLineBorder(Color.black,1);
	public LoginForm(){
		setTitle("Login");
		setSize(650,450);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setContentPane(new JLabel(new ImageIcon("burger.jpeg")));
		setVisible(true);
		comboBox1.setBounds(270,75,135,25);
		comboBox1.setBorder(border2);
		add(comboBox1);
		setLayout(null);
		label1.setBounds(170,130,100,30);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,20));
		add(label1);
		setLayout(null);
		label2.setBounds(170,170,100,30);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,20));
		add(label2);
		setLayout(null);
		textField1.setBounds(270,130,130,30);
		textField1.setBorder(border1);
		textField1.setBackground(Color.lightGray);
		textField1.setForeground(Color.blue);
		textField1.setFont(new Font("Arial",Font.BOLD,15));
		add(textField1);
		pass1.setBounds(270,170,130,30);
		pass1.setBorder(border1);
		pass1.setBackground(Color.lightGray);
		add(pass1);
		button1.setBounds(350,220,70,30);
		button1.setBorder(border1);
		add(button1);
		setLayout(null);
		button2.setBounds(250,220,85,30);
		button2.setBorder(border1);
		add(button2);
		setLayout(null);
		button1.addActionListener(this);
		button2.addActionListener(this);
		comboBox1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a){
		OrderInfo oi=new OrderInfo();
		String n=textField1.getText();
		String p=pass1.getText().toString();
		oi.setName(n);
		Object selected=comboBox1.getSelectedItem();
		if(a.getSource()==button2){//Registration for new user
			if(selected.toString().equals("Customer")){
				RegistrationForm r=new RegistrationForm();
				this.setVisible(false);
			}else if(selected.toString().equals("--Select Member--")){
				JOptionPane.showMessageDialog(this,"Please select member type first!");
			}else{
				JOptionPane.showMessageDialog(this,"You are not allowed to do registration!");
			}
		}else if(a.getSource()==button1){//Login condition for user
			if(selected.toString().equals("Admin") && textField1.getText().toString().equals("Admin") && pass1.getText().toString().
			equals("1234")){
				AdminForm af=new AdminForm();
				this.setVisible(false);
			}else if(selected.toString().equals("Customer")){//check comboBox selection
					DatabaseManager db=new DatabaseManager();
					db.customerLogin(n,p);
					db.orderInfo(oi);
					this.setVisible(false);
			}else if(selected.toString().equals("--Select Member--")){
				JOptionPane.showMessageDialog(this,"Please select member type first!");
			}else if(selected.toString().equals("Employee")){
					DatabaseManager db=new DatabaseManager();
					db.employeeLogin(n,p);
					this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this,"Username and password doesn't match!");
			}
		}
		
	}
}