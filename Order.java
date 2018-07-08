package ClassFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
class Order extends JFrame implements ActionListener{
	JCheckBox c1=new JCheckBox();
	JPanel jp=new JPanel();
	public static String n;
	public static String p;
	public static String a;
	public static int count;
	public static int quantity;
	public static int i=0;
	public static String[] aa=new String[100];
	public static String[] qq=new String[100];
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField("0.00     ");
	JLabel l1=new JLabel("Name");
	JLabel l2=new JLabel("Phone No");
	JLabel l3=new JLabel("Address");
	JLabel l4=new JLabel("Total");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JButton b1=new JButton("OK");
	JButton b2=new JButton("Log Out");
	public static JTable jt=new JTable();
	//public Order(){}
	public void setInfo(OrderInfo oinfo){
		String name=oinfo.getName().toString();
		String phoneNo=oinfo.getPhoneNo();
		String addrs=oinfo.getAddress();
		this.n=name;
		this.p=phoneNo;
		this.a=addrs;
	}

	public void orderMenu(){
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
			Vector column=new Vector(count,2);
			for(int i=1; i<=count; i++){
				column.add(rsmt.getColumnName(i));
			}
			
			column.add("Quantity");
			column.add("Select Item");
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
            if(col == 4){
                return Boolean.class;
            }else if(col==3){
				return String.class;
			}else {
				return super.getColumnClass(col);
			}
            
			}
			public boolean isCellEditable(int row,int column){
				if(column==3){
					return true;
				}else if(column==4){
					return true;
				}
				return false;
			}
			};
			jt.setModel(dtm);
			jt.getColumnModel().getColumn(1).setPreferredWidth(200);
			for(int r = 0; r< jt.getRowCount(); r++){
				jt.setValueAt(1,r,3);
			}
			jt.setFont(new Font("Arial",Font.ITALIC,15));
			jp.setForeground(Color.white);
			JScrollPane sp=new JScrollPane(jt);
			
			jt.setBackground(Color.white);
			add(sp,BorderLayout.CENTER);
			setSize(670,300);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(true);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		
		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		l3.setForeground(Color.black);
		l4.setForeground(Color.black);
		l1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
		l2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
		l3.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
		l4.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
		t1.setFont(new Font("Arial",Font.PLAIN,15));
		t2.setFont(new Font("Arial",Font.PLAIN,15));
		t3.setFont(new Font("Arial",Font.PLAIN,15));
		t4.setFont(new Font("Arial",Font.PLAIN,15));
		p1.setBackground(Color.cyan);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		add(p1,BorderLayout.NORTH);
		p2.add(b2);
		p2.add(b1);
		p2.setBackground(Color.black);
		add(p2,BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		t1.setText(n);
		t2.setText(p);
		t3.setText(a);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		jt.getModel().addTableModelListener(new CheckBoxModelListener());
	}
	 public class CheckBoxModelListener implements TableModelListener {

        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
			String p=jt.getModel().getValueAt(row,2).toString();
			String q=jt.getModel().getValueAt(row,3).toString();
			String id=jt.getModel().getValueAt(row,0).toString();
			int price=Integer.parseInt(p);
			quantity=Integer.parseInt(q);
            if (column == 4) {
                TableModel model = (TableModel) e.getSource();
                String columnName = model.getColumnName(2);
                Boolean checked = (Boolean) model.getValueAt(row, column);
                if (checked) {
					count+=price*quantity;
                    t4.setText(Integer.toString(count));
					aa[i]=jt.getModel().getValueAt(row,0).toString()+"="+jt.getModel().getValueAt(row,3).toString();
					i++;
                } else {
					count-=price*quantity;
                     t4.setText(Integer.toString(count));
					 i--;
					
                }
            }
        }
    }
	public void actionPerformed(ActionEvent el){
		if(el.getSource()==b1){
			DatabaseManager db=new DatabaseManager();
			db.setOrderDetails(t1.getText(),t2.getText(),t3.getText(),aa,t4.getText());
		}else if(el.getSource()==b2){
			LoginForm lf=new LoginForm();
			this.setVisible(false);
		}
		
	}
	
}