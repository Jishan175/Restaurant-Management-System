//package declaration and import different java packages
package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
class AdminForm extends JFrame implements ActionListener{
	JPanel jp=new JPanel();
	JButton button1=new JButton("Employee List");
	JButton button2=new JButton("Update Menu");
	JButton button3=new JButton("Log Out");
	JTable jt=new JTable();
	Border border1=BorderFactory.createLineBorder(Color.black,2);//new border create
	Border border2=BorderFactory.createLineBorder(Color.black,1);
public AdminForm(){
		try{
			//get connecttion from Database
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
			
			DefaultTableModel dtm = new DefaultTableModel(data, column){//setting a model for jtable
			public boolean isCellEditable(int row,int column){//making jtable column non-editable
				if(column==0){
					return false;
				}else if(column==1){
					return false;
				}else if(column==2){
					return false;
				}
				return true;
			}
			};
			setSize(600,300);//setSize for jframe size
			setLocationRelativeTo(null);//set the frame at middle
			setResizable(false);//set the jframe non-resizable
			jt.setModel(dtm);
			jt.setFont(new Font("Arial",Font.ITALIC,15));//setting font for jtable
			jt.setBackground(Color.darkGray);
			jp.setForeground(Color.white);
			JScrollPane sp=new JScrollPane(jt);
			jt.setBackground(Color.white);
			add(sp,BorderLayout.CENTER);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		jp.setBackground(Color.darkGray);
		jp.add(button3);
		jp.add(button1);
		jp.add(button2);
		jp.setBackground(Color.cyan);
		add(jp,BorderLayout.SOUTH);//adding panel by layout
		setTitle("Admin");
		setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	/*Performing action against 
	different button by overriding*/
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1){
			EmployeeList ef=new EmployeeList();
			this.setVisible(false);
		}else if(a.getSource()==button3){
			LoginForm lf=new LoginForm();
			this.setVisible(false);	
		}else if(a.getSource()==button2){
			UpdateMenu um=new UpdateMenu();
			this.setVisible(false);
		}
		
	}
}