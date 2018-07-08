package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class DeleteEmployee extends JFrame implements ActionListener{
	/*
	component declaration
	*/
	JButton button1=new JButton("Cancel");
	JButton button2=new JButton("Delete");
	JLabel label1=new JLabel("Name");
	JLabel label2=new JLabel("User ID");
	JTextField textfield1=new JTextField();
	JTextField textfield2=new JTextField();
	public DeleteEmployee(){
		setTitle("Update Employee");
		setSize(300,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		label1.setBounds(50,50,70,30);
		label1.setForeground(Color.black);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		add(label1);
		label2.setBounds(50,95,80,30);
		label2.setForeground(Color.black);
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		add(label2);
		textfield1.setBounds(120,50,100,30);
		add(textfield1);
		textfield2.setBounds(120,95,100,30);
		add(textfield2);
		button1.setBounds(60,140,90,30);
		add(button1);
		button2.setBounds(160,140,90,30);
		add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1){
			EmployeeList el=new EmployeeList();
			this.setVisible(false);
		}else if(a.getSource()==button2){
			this.setVisible(false);
			DatabaseManager db=new DatabaseManager();
			db.deleteEmployee(textfield1.getText(),textfield2.getText());
			JOptionPane.showMessageDialog(this,"Deleted Successfully");
			EmployeeList el=new EmployeeList();
		}
	}
}