package giaodien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import giaodien.ConnectDB;

public class GK extends JFrame{
	JFrame f = new JFrame();
	JLabel lbID = new JLabel("Id");
	JTextField tfID = new JTextField(10);
	JLabel lbName = new JLabel("Name");
	JTextField tfName = new JTextField(10);
	JLabel lbBirthday = new JLabel("Birthday");
	//JTextField tfBirthday = new JTextField(10);
	JCalendar jcBirthday = new JCalendar();
	JLabel lbRate = new JLabel("Rate");
	JTextField tfRate = new JTextField(10);
	JLabel blDep = new JLabel("Department");
	String Depart[] = {"VKU","DTU","DUT"};
	JComboBox cbdepart = new JComboBox(Depart);
	JButton btSignUp = new JButton("Sign Up");
	JButton btselect = new JButton("Select");
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbgk;
	public GK() {
		f.setLocation(300,200);
		f.setLayout(new GridLayout(7,2));
		Container cont =  f.getContentPane();
		cont.add(lbID);
		cont.add(tfID);
		cont.add(lbName);
		cont.add(tfName);
		cont.add(lbBirthday);
		//cont.add(tfBirthday);
		cont.add(jcBirthday);
		cont.add(lbRate);
		cont.add(tfRate);
		cont.add(blDep);
		cont.add(cbdepart);
		cont.add(btSignUp);
		cont.add(btselect);
		f.pack();
		f.setSize(500,500);
		f.setVisible(true);
		btSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Department = cbdepart.getSelectedItem().toString();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
					try {
						Date selectedDate = (Date) jcBirthday.getDate();
						java.sql.Date birthday = convertUtilToSql(selectedDate);
						ConnectDB conn = new ConnectDB();
						
						int record = conn.executeDB("Insert into gk values('"+tfID.getText()+"','"+tfName.getText()+"','"+birthday+"','"+tfRate.getText()+"','"+cbdepart.getSelectedItem().toString()+"')");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		btselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ConnectDB connectDB = new ConnectDB();
                 conn = connectDB.connect();
                 String sql = "SELECT * FROM gk";
                 try {
					ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					if (rs != null){
	                      while(rs.next()){
	                      String ID = rs.getString("Id");
	                      String Name = rs.getString("Name");
	                      String depart = rs.getString("Department");
	                      Date birthday = rs.getDate("Birthday");
	                      float rate = rs.getFloat("Rate");
	                      System.out.println(ID+"\n"+Name+"\n"+depart+"\n"+birthday+"\n"+rate);
	                      
	                      }
	                      rs.close();
	                      }
	                      ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 
			}
		});
		Displaygk();
		JScrollPane sp = new JScrollPane(tbgk);
		cont.add(sp);
	}
	
	 private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
	        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	        return sDate;
	    }
	 public void Displaygk() {
		   ConnectDB conn = new ConnectDB();
	        rs= conn.listAll("Select * from gk");
	      String column[] = {"Id", "Name"," Birthday"," Rate"," Department"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("Id"), rs.getString("Name"),rs.getString("Birthday"),rs.getString("Rate"), rs.getString("Department")};    
				
					tbgk = new JTable(tm);
					tm.addRow(data);
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	}


	public static void main(String agrs[]) {
		new GK();
	}

}
