package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class UpdateMenu extends JFrame implements ActionListener{
	JButton button1=new JButton("Add Item");
	JButton button2=new JButton("Delete Item");
	JButton button4=new JButton("Update");
	JButton button3=new JButton("Back");
	JLabel label1=new JLabel("Item Name");
	JLabel label2=new JLabel("Item Price");
	JLabel label3=new JLabel("Item ID");
	JTextField textfield1=new JTextField();
	JTextField textfield2=new JTextField();
	JTextField textfield3=new JTextField();
	public UpdateMenu(){
		setTitle("Update Menu");
		setSize(300,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		label3.setBounds(50,50,110,30);
		label3.setForeground(Color.black);
		label3.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		add(label3);
		label1.setBounds(50,95,110,30);
		label1.setForeground(Color.black);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		add(label1);
		label2.setBounds(50,140,110,30);
		label2.setForeground(Color.black);
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		add(label2);
		textfield3.setBounds(145,50,115,30);
		add(textfield3);
		textfield1.setBounds(145,95,115,30);
		add(textfield1);
		textfield2.setBounds(145,140,115,30);
		add(textfield2);
		button1.setBounds(160,190,95,30);
		add(button1);
		button2.setBounds(50,190,100,30);//
		add(button2);
		button3.setBounds(3,3,70,25);
		add(button3);
		button4.setBounds(90,230,90,25);
		add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1){
			double menuprice=Double.parseDouble(textfield2.getText());
			int menuid=Integer.parseInt(textfield3.getText());
			DatabaseManager db=new DatabaseManager();
			MenuInfo minf=new MenuInfo(menuid,textfield1.getText(),menuprice);
			db.setMenuInfo(minf);
			JOptionPane.showMessageDialog(this,"Item Added Successfully");
			textfield1.setText("");
			textfield2.setText("");
			textfield3.setText("");
		}else if(a.getSource()==button2){
			int menuid=Integer.parseInt(textfield3.getText());
			DatabaseManager db=new DatabaseManager();
			db.deleteMenuInfo(menuid);
			JOptionPane.showMessageDialog(this,"Item Deleted Successfully");
			textfield3.setText("");
		}else if(a.getSource()==button3){
			AdminForm af=new AdminForm();
			this.setVisible(false);
		}else if(a.getSource()==button4){
			DatabaseManager db=new DatabaseManager();
			db.updateMenuInfo(textfield3.getText(),textfield1.getText(),textfield2.getText());
			textfield1.setText("");
			textfield2.setText("");
			textfield3.setText("");
			JOptionPane.showMessageDialog(this,"Item Updated Successfully");
		}
	}
}
