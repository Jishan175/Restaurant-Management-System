package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.event.*;
class EmployeeList extends JFrame implements ActionListener{
	JButton button1=new JButton("Add Employee");
	JButton button2=new JButton("Delete Employee");
	JButton button3=new JButton("Back");
	JButton button4=new JButton("Update Information");
	JLabel label1=new JLabel("Employee Name");
	JLabel label2=new JLabel("User ID");
	JLabel label3=new JLabel("Address");
	JLabel label4=new JLabel("Contact No");
	JLabel label5=new JLabel("Email");
	JLabel label6=new JLabel("Salary");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	JPanel jp=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel();
	JTable jt=new JTable();
	Border border1=BorderFactory.createLineBorder(Color.black,2);
	Border border2=BorderFactory.createLineBorder(Color.black,1);
	public EmployeeList(){
		try{
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			ResultSet rs=null;
			Statement st=null;
			String s;
			st=con.createStatement();
			s="select * from employee";
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
			DefaultTableModel dtm = new DefaultTableModel(data, column){
			public boolean isCellEditable(int row,int column){//setting the column non-editable
				if(column==0){
					return false;
				}else if(column==1){
					return false;
				}else if(column==2){
					return false;
				}else if(column==3){
					return false;
				}else if(column==4){
					return false;
				}else if(column==5){
					return false;
				}else if(column==7){
					return false;
				}
				return true;
			}
			};
			setSize(1050,300);
			setLocationRelativeTo(null);
			jt.setModel(dtm);
			jt.setFont(new Font("Arial",Font.ITALIC,15));
			jt.setBackground(Color.darkGray);
			jt.removeColumn(jt.getColumnModel().getColumn(5));
			jt.setBackground(Color.white);
			JScrollPane sp=new JScrollPane(jt);
			add(sp,BorderLayout.CENTER);
			jt.getSelectionModel().addListSelectionListener(new ListSelectionListener(){//add listener for jtable
            public void valueChanged(ListSelectionEvent e) {
                if(jt.getSelectedRowCount()==1){ //Only for single selection
                    int selectedRow = jt.getSelectedRow();//getting value from specific row
                    String name = jt.getValueAt(selectedRow, 0).toString();
                    String username = jt.getValueAt(selectedRow, 1).toString();
                    String address = jt.getValueAt(selectedRow, 2).toString();
					String contactNo = jt.getValueAt(selectedRow, 4).toString();
                    String email = jt.getValueAt(selectedRow, 5).toString();
					String salary = jt.getValueAt(selectedRow, 6).toString();
                    t1.setText(name);
                    t2.setText(username);
                    t3.setText(address);
					t4.setText(contactNo);
					t5.setText(email);
					t6.setText(salary);
                }
            }        	
        });
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		label3.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		label4.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		label5.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		label6.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		jp2.setLayout(new GridBagLayout());//creating a new layout 
		GridBagConstraints g=new GridBagConstraints();
		g.gridx=0;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.weightx=100;
		g.weighty=100;
		g.anchor=GridBagConstraints.CENTER;
		g.fill=GridBagConstraints.NONE;
		jp.setBackground(Color.darkGray);
		jp.add(button3);
		jp.add(button1);
		jp.add(button2);
		add(jp,BorderLayout.NORTH);
		jp3.setBackground(Color.cyan);
		jp2.add(label1,g);
		g.gridy+=3;
		jp2.add(label2,g);
		g.gridy+=3;
		jp2.add(label3,g);
		g.gridy+=3;
		jp2.add(label4,g);
		g.gridy+=3;
		jp2.add(label5,g);
		g.gridy+=3;
		jp2.add(label6,g);
		g.gridx++;
		g.gridy=1;
		jp2.add(t1,g);
		g.gridy+=3;
		jp2.add(t2,g);
		g.gridy+=3;
		jp2.add(t3,g);
		g.gridy+=3;
		jp2.add(t4,g);
		g.gridy+=3;
		jp2.add(t5,g);
		g.gridy+=3;
		jp2.add(t6,g);
		g.gridy+=6;
		jp2.add(button4,g);
		t1.setPreferredSize(new Dimension(150, 25));
		t2.setPreferredSize(new Dimension(150, 25));
		t3.setPreferredSize(new Dimension(150, 25));
		t4.setPreferredSize(new Dimension(150, 25));
		t5.setPreferredSize(new Dimension(150, 25));
		t6.setPreferredSize(new Dimension(150, 25));
		t1.setMinimumSize(t1.getPreferredSize());
		t2.setMinimumSize(t2.getPreferredSize());
		t3.setMinimumSize(t3.getPreferredSize());
		t4.setMinimumSize(t4.getPreferredSize());
		t5.setMinimumSize(t5.getPreferredSize());
		t6.setMinimumSize(t6.getPreferredSize());
		jp2.setPreferredSize(new Dimension(300, 220));
		jp3.add(jp2);
		add(jp3,BorderLayout.EAST);
		setTitle("Employee List");
		setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		t2.setEditable(false);
	}
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1){
			EmployeeRegistrationForm e=new EmployeeRegistrationForm();
			this.setVisible(false);
			
		}else if(a.getSource()==button3){
			AdminForm af=new AdminForm();
			this.setVisible(false);
		}else if(a.getSource()==button2){
			DeleteEmployee de=new DeleteEmployee();
			this.setVisible(false);
		}else if(a.getSource()==button4){
			DatabaseManager db=new DatabaseManager();
			db.updateEmployeeInfo(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText());
			this.setVisible(false);
		}
		
	}
}