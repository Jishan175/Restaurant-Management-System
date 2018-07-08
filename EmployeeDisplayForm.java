package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

class EmployeeDisplayForm extends JFrame implements ActionListener{
	public static String phone;
	public static String name;
	public static String[] aOrder=new String[50];
	public static int i=0;
	JButton button1=new JButton("Log out");
	JButton button2=new JButton("OK");
	public static JTable jt=new JTable();
	JPanel jp=new JPanel();
	Border border1=BorderFactory.createLineBorder(Color.black,2);
	Border border2=BorderFactory.createLineBorder(Color.black,1);
	public EmployeeDisplayForm(){
		try{
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			ResultSet rs=null;
			Statement st=null;
			String s;
			st=con.createStatement();
			s="select * from orderdetails";
			rs=st.executeQuery(s);
			ResultSetMetaData rsmt=rs.getMetaData();
			int count=rsmt.getColumnCount();
			Vector column=new Vector(count,2);
			for(int i=1; i<=count; i++){
				column.add(rsmt.getColumnName(i));
			}
			
			column.add("Select");
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
				public Class<?> getColumnClass(int col) {
            if(col == 6){
                return Boolean.class;
            }else {
				return super.getColumnClass(col);
			}
            
			}
			public boolean isCellEditable(int row,int column){
				if(column==6){
					return true;
				}
				return false;
			}
			};
			jt.setModel(dtm);//set a model for jtable
			/*
			setting size for jtable column
			*/
			jt.getColumnModel().getColumn(0).setPreferredWidth(100);
			jt.getColumnModel().getColumn(1).setPreferredWidth(90);
			jt.getColumnModel().getColumn(2).setPreferredWidth(120);
			jt.getColumnModel().getColumn(3).setPreferredWidth(130);
			jt.getColumnModel().getColumn(4).setPreferredWidth(160);
			jt.getColumnModel().getColumn(5).setPreferredWidth(50);
			jt.setFont(new Font("Arial",Font.ITALIC,15));
			jp.setBackground(Color.cyan);
			JScrollPane sp=new JScrollPane(jt);
			jp.add(button1);
			jp.add(button2);
			jt.setBackground(Color.white);
			add(sp,BorderLayout.CENTER);
			add(jp,BorderLayout.SOUTH);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		setSize(800,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jt.getModel().addTableModelListener(new CheckBoxModelListener());
	}
	
	public class CheckBoxModelListener implements TableModelListener {

        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column==6) {
                TableModel model = (TableModel) e.getSource();
                //String columnName = model.getColumnName(2);
                Boolean checked = (Boolean) model.getValueAt(row,column);
                if (checked) {
					aOrder[i]=jt.getModel().getValueAt(row,0).toString();
					i++;
                }else{
					i--;
				}
            }
        }
    }
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button1){
			LoginForm lf=new LoginForm();
			this.setVisible(false);
		}else if(a.getSource()==button2){
			DatabaseManager db=new DatabaseManager();
			db.deliveredOrder(aOrder);
			EmployeeDisplayForm ef=new EmployeeDisplayForm();
			this.setVisible(false);
		}
	}
}