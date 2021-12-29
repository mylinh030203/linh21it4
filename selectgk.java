package selectsql;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import giaodien.ConnectDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class selectgk extends JFrame {
	JFrame f = new JFrame();
	JLabel lblist = new JLabel ("List rate of human");
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbRate;
	JButton btnHighSalary = new JButton("HighSalary");
	public selectgk() {
		f.setLocation(300,200);
		f.setLayout(new GridLayout(2,1));
		Container cont =  f.getContentPane();
		cont.add(lblist);
		cont.add(btnHighSalary);
		f.pack();
		f.setSize(600,500);
		f.setVisible(true);
		btnHighSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				selectgk hs = new selectgk();
				f.setVisible(false);
				hs.setVisible(true); 
				
			}
			});
		DisplayRate();
		JScrollPane sp = new JScrollPane(tbRate);
		cont.add(sp);
	}
	 public void DisplayRate() {
		   ConnectDB conn = new ConnectDB();
	        rs= conn.listAll("SELECT *\r\n"
	        		+ "FROM gk\r\n"
	        		+ "WHERE Rate = (SELECT MAX(Rate) FROM gk);");
	      String column[] = {"Id", "Name"," Birthday"," Rate"," Department"};
	        DefaultTableModel listrate = new DefaultTableModel (column, 0);
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("Id"), rs.getString("Name"),rs.getString("Birthday"),rs.getString("Rate"), rs.getString("Department")};    
				
					tbRate = new JTable(listrate);
					listrate.addRow(data);
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new selectgk();
	}

}
