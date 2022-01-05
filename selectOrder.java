package giaodien;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import giaodien.ConnectDB;
public class selectOrder extends JFrame{
	JFrame f = new JFrame("Orderl");
	
	JLabel lbOrderDateStart = new JLabel("OrderDate Start");
	JCalendar jcOrderDateStart = new JCalendar();
	JLabel lbOrderDateEnd = new JLabel("OrderDate End");
	JCalendar jcOrderDateEnd = new JCalendar();
	
	JButton btSelect = new JButton("Select");
	
	JFrame f1 = new JFrame();
	
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbmonth = new JTable();
	JScrollPane sp = new JScrollPane(tbmonth);
	public selectOrder() {
		f.setLocation(250,250);
		f.setLayout(new GridLayout(4,2));
		Container cont =  f.getContentPane();
		
		cont.add(lbOrderDateStart);
		cont.add(jcOrderDateStart);
		cont.add(lbOrderDateEnd);
		cont.add(jcOrderDateEnd);
		cont.add(btSelect);
		f.pack();
		f.setSize(500,500);
		f.setVisible(true);
		
	
		btSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe2();
			}
		});
		
		
	}
	
	public void jframe2() {	
		
		f1.setLocation(250,250);
		f1.setLayout(new GridLayout(4,2));
		Container cont1 =  f1.getContentPane();
		
		cont1.add(sp);
		f1.pack();
		f1.setSize(200,200);
		f1.setVisible(true);
		DisplayOrder();
	}
	public void DisplayOrder() {
		   ConnectDB conn = new ConnectDB();
	        rs= conn.listAll("select gk.Id, gk.Name, Product.ProductID, Product.ProductName from gk, Orderl,Product\r\n"
	        		+ "where gk.Id = Orderl.Id and Product.ProductID = Orderl.ProductID and MONTH(OrderDate) =  1");
	      String column[] = {"Id", "Name"," ProductID"," ProductName"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("Id"), rs.getString("Name"),rs.getString("ProductID"),rs.getString("ProductName")};    
	
					tm.addRow(data);
					
				}
				tbmonth.setModel(tm);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new selectOrder();
		
	}

}
