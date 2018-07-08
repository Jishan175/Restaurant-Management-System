package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class EmployeeRegistrationForm extends JFrame implements ActionListener{
	JLabel label1=new JLabel("Name");
	JLabel label2=new JLabel("UserID");
	JLabel label3=new JLabel("Address");
	JLabel label4=new JLabel("Gender");
	JLabel label5=new JLabel("Contact No.");
	JLabel label6=new JLabel("Password");
	JLabel label7=new JLabel("Repeat Password");
	JLabel label8=new JLabel("Email");
	JLabel label9=new JLabel("Salary");
	JTextField textfield1=new JTextField();
	JTextField textfield2=new JTextField();
	JTextField textfield3=new JTextField();
	JTextField textfield4=new JTextField();
	JTextField textfield5=new JTextField();
	JTextField textfield6=new JTextField();
	JPasswordField pass1=new JPasswordField();
	JPasswordField pass2=new JPasswordField();
	JRadioButton rButton1=new JRadioButton("Male");
	JRadioButton rButton2=new JRadioButton("Female");
	ButtonGroup bg1=new ButtonGroup();//creating a group for single radio button selection
	JButton button1=new JButton("Cancel");
	JButton button2=new JButton("Save");
	Border border1=BorderFactory.createLineBorder(Color.black,2);
	Border border2=BorderFactory.createLineBorder(Color.black,1);
	public EmployeeRegistrationForm(){
		setTitle("Registration Form");
		setSize(500,600);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setContentPane(new JLabel(new ImageIcon("bg15.jpg")));
		setVisible(true);
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
		label8.setBounds(85,370,110,30);
		label8.setForeground(Color.white);
		label8.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label8);
		setLayout(null);
		label9.setBounds(85,410,110,30);
		label9.setForeground(Color.white);
		label9.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,13));
		add(label9);
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
		add(textfield2);
		textfield3.setBounds(200,170,125,30);
		textfield3.setBorder(border1);
		textfield3.setBackground(Color.lightGray);
		textfield3.setForeground(Color.black);
		textfield3.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield3);
		rButton1.setBounds(200,210,80,30);
		rButton1.setContentAreaFilled(false);
		rButton1.setForeground(Color.white);
		rButton1.setFont(new Font("Arial",Font.BOLD,13));
		add(rButton1);
		rButton2.setBounds(280,210,80,30);
		rButton2.setContentAreaFilled(false);
		rButton2.setForeground(Color.white);
		rButton1.setFont(new Font("Arial",Font.BOLD,13));
		add(rButton2);
		bg1.add(rButton1);
		bg1.add(rButton2);
		textfield4.setBounds(200,250,125,30);
		textfield4.setBorder(border1);
		textfield4.setBackground(Color.lightGray);
		textfield4.setForeground(Color.black);
		textfield4.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield4);
		pass1.setBounds(200,290,125,30);
		pass1.setBorder(border1);
		pass1.setBackground(Color.lightGray);
		pass1.setForeground(Color.black);
		add(pass1);
		pass2.setBounds(200,330,125,30);
		pass2.setBorder(border1);
		pass2.setBackground(Color.lightGray);
		pass2.setForeground(Color.black);
		add(pass2);
		textfield5.setBounds(200,370,125,30);
		textfield5.setBorder(border1);
		textfield5.setBackground(Color.lightGray);
		textfield5.setForeground(Color.black);
		textfield5.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield5);
		textfield6.setBounds(200,410,125,30);
		textfield6.setBorder(border1);
		textfield6.setBackground(Color.lightGray);
		textfield6.setForeground(Color.black);
		textfield6.setFont(new Font("Arial",Font.BOLD,13));
		add(textfield6);
		button1.setBounds(150,465,90,30);
		button1.setBorder(border2);
		add(button1);
		setLayout(null);
		button2.setBounds(255,465,90,30);
		button2.setBorder(border2);
		add(button2);
		setLayout(null);
		button1.addActionListener(this);
		button2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1 ){
			EmployeeList el=new EmployeeList();
			this.setVisible(false);
		}else if(a.getSource()==button2){
			String gender;
			double salary=Double.parseDouble(textfield6.getText());
			if(rButton1.isSelected()){
				gender="Male";
			}else{
				gender="Female";
			}
			DatabaseManager db=new DatabaseManager();
			EmployeeInfo einf=new EmployeeInfo(textfield1.getText(),textfield2.getText(),textfield3.getText(),gender,textfield4.getText(),pass1.getText(),textfield5.getText(),salary);
			if(pass1.getText().toString().equals(pass2.getText())){
				db.setEmployeeInfo(einf);
			}else{
				JOptionPane.showMessageDialog(this,"Password doesn't match,try again !");
			}
			EmployeeList el=new EmployeeList();
			this.setVisible(false);
		}
	}
}