package giaodien;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;


public class facebookForm extends JFrame {
	JFrame f= new JFrame("The Frame");
	JLabel lbSignUp = new JLabel("Sign Up");
	JLabel lbuser = new JLabel ("Username");
	JTextField tfuser = new JTextField(10);
	JLabel lbpass = new JLabel ("Password");
	JTextField pass = new JTextField(10);
	JRadioButton rbMale=new JRadioButton("Male");    
	JRadioButton rbFemale=new JRadioButton("Female");
	ButtonGroup br= new ButtonGroup();
	JLabel lbDepart = new JLabel("Department");
	String Depart[] = {"VKU","DTU","DUT"};
	JComboBox cbdepart = new JComboBox(Depart);
	JCheckBox cbCS =  new JCheckBox("Computer Science");
	JCheckBox cbEC =  new JCheckBox("Economic");
	JButton btSignUp = new JButton("Sign Up");
	JButton btnUpdate = new JButton("Update pass");
	JButton btDelete = new JButton("Delete");
	JButton btselect = new JButton("Select");
	JButton btlist = new JButton("List");
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbAccount;
	public facebookForm() {
		//tao 1 continer de add cac component vao
		f.setLocation(500,500);
		f.setLayout(new GridLayout(8,2));
		//f.setLayout(getLayout());
		 Container cont =  f.getContentPane();
		//cont.add(lbSignUp);
		 cont.add(lbuser);
		cont.add(tfuser);
		cont.add(lbpass);
		cont.add(pass);
		br.add(rbMale);
		br.add(rbFemale);
		cont.add(rbMale);
		cont.add(rbFemale);
		cont.add(lbDepart);
		cont.add(cbdepart);
		cont.add(cbCS);
		cont.add(cbEC);
		cont.add(btSignUp);
		cont.add(btnUpdate);
		cont.add(btDelete);
		cont.add(btlist);
		btSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn =new ConnectDB();
				String gender ="";
				if(rbMale.isSelected()) gender = rbMale.getText();
				if(rbFemale.isSelected()) gender = rbFemale.getText();
				String depart = cbdepart.getSelectedItem().toString();
				String faculty ="";
				if(cbCS.isSelected()) faculty += cbCS.getText()+";";
				if(cbEC.isSelected()) faculty += cbEC.getText();
				int record = cn.executeDB("Insert into Account values ('"+tfuser.getText()+"','"+pass.getText()+"','"+gender+"','"+depart+"','"+faculty+"'");
				if(record >0) JOptionPane.showMessageDialog(null, "Success");
				else JOptionPane.showMessageDialog(null, "Fail");
				/*Object ob[] = {tfuser.getText(), pass.getText(), gender, depart, faculty};
				DefaultTableModel tm = new DefaultTableModel (ob, 0);
 				tm.addRow(ob);
				DisplayAccount();*/
			}
		});
		btlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn =new ConnectDB();
				String gender ="";
				if(rbMale.isSelected()) gender = rbMale.getText();
				if(rbFemale.isSelected()) gender = rbFemale.getText();
				String depart = cbdepart.getSelectedItem().toString();
				String faculty ="";
				if(cbCS.isSelected()) faculty += cbCS.getText()+";";
				if(cbEC.isSelected()) faculty += cbEC.getText();
				//String sql = "exec [sp_Account]'"+tfuser.getText()+"','"+pass.getText()+"','"+gender+"','"+depart+"','"+faculty+"'";
				//String sql = "exec sp_Account ?,?,?,?,?";
				//int record = cn.executeDB("exec [sp_Account]'"+tfuser.getText()+"','"+pass.getText()+"','"+gender+"','"+depart+"','"+faculty+"'");
				// dung preparestament
				conn = cn.connect();
			 try {
				// ps= conn.prepareStatement(sql);
				ps = conn.prepareStatement("exec sp_Account ?,?,?,?,? ");
				ps.setString(1, tfuser.getText());
				ps.setString(2, pass.getText());
				ps.setString(3, gender);
				ps.setString(4, depart);
				ps.setString(5, faculty);
				int record = ps.executeUpdate();
				if(record >0) JOptionPane.showMessageDialog(null, "Success");
				else JOptionPane.showMessageDialog(null, "Fail");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 	
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn =new ConnectDB();
				/*String gender ="";
				if(rbMale.isSelected()) gender = rbMale.getText();
				if(rbFemale.isSelected()) gender = rbFemale.getText();
				String depart = cbdepart.getSelectedItem().toString();
				String faculty ="";
				if(cbCS.isSelected()) faculty += cbCS.getText()+";";
				if(cbEC.isSelected()) faculty += cbEC.getText();*/
				//int record = cn.executeDB("Update Account set pass ='"+pass.getText()+"'where username ='"+tfuser.getText()+"'");
			//	String sql = "update Account set pass = ? where username = ?";
				conn = cn.connect();
				try {
					ps = conn.prepareStatement("exec sp_UPdpass ?,?");
				//	ps = conn.prepareStatement(sql);
					ps.setString(2, pass.getText());
					ps.setString(1, tfuser.getText());
					int record = ps.executeUpdate();
					if(record >0) JOptionPane.showMessageDialog(null, "Change Pass sucessfully!");
					else JOptionPane.showMessageDialog(null, "Error");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			});
	/*	btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn =new ConnectDB();
				int record = cn.executeDB("exec [sp_UPdpass] '"+tfuser.getText()+"','"+pass.getText()+"'");
				if(record >0) JOptionPane.showMessageDialog(null, "Change Pass sucessfully!");
				else JOptionPane.showMessageDialog(null, "Error");
			}
			});*/
		
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				/*int record = cn.executeDB("Delete Account where username ='"+rbFemale.getText()+"'");
				if(record >0) JOptionPane.showMessageDialog(null, "Delete Account sucessfully!");
				else JOptionPane.showMessageDialog(null, "Error");*/
				conn = cn.connect();
				try {
					//c1
					ps = conn.prepareStatement("exec sp_delete ?");
					
					ps.setString(1, tfuser.getText());
					int record = ps.executeUpdate();
					if(record >0) JOptionPane.showMessageDialog(null, "Delete sucessfully!");
					else JOptionPane.showMessageDialog(null, "Error");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
	
	        btlist.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent e) {
	                	/*  String gender ="";
	      				if(rbMale.isSelected()) gender = rbMale.getText();
	      				if(rbFemale.isSelected()) gender = rbFemale.getText();
	      				String depart = cbdepart.getSelectedItem().toString();
	      				String faculty ="";
	      				if(cbCS.isSelected()) faculty += cbCS.getText()+";";
	      				if(cbEC.isSelected()) faculty += cbEC.getText();*/
	                  ConnectDB connectDB = new ConnectDB();
	                  conn = connectDB.connect();
	                  String sql = "SELECT * FROM Account";
//	                   String sql = "CREATE PROCEDURE st_list AS SELECT * FROM Account";
	                   try{
	                	 /* ps = conn.prepareStatement("exec st_list ?,?,?,?,?");
	                	  ps.setString(1, tfuser.getText());
	                	  ps.setString(2, pass.getText());
	                	  ps.setString(3, gender);
	                	  ps.setString(4, depart);
	                	  ps.setString(5, faculty);*/
	                      ps = conn.prepareStatement(sql);
	                      ResultSet rs = ps.executeQuery();
	                      if (rs != null){
	                      while(rs.next()){
	                      String username = rs.getString("Username");
	                      String pass1 = rs.getString("Password");
	                      String gender = rs.getString("gender");
	                      tfuser.setText(username);
	                      pass.setText(pass1);

	                      }
	                      rs.close();
	                      }
	                      ps.close();
	                      } catch (SQLException ex) {
	                      ex.printStackTrace();
	                      }
	                 }
	        });
	     
			 DisplayAccount();
			JScrollPane sp = new JScrollPane(tbAccount);
			//JScrollPane la thanh cuon
			cont.add(sp);
		
		f.pack();
		f.setSize(250,250);
		f.setVisible(true);
		
	
	}

	


	public void DisplayAccount() {
		   ConnectDB conn = new ConnectDB();
	        rs= conn.listAccount("Select * from Account");
	       // DefaultTableModel tm = (DefaultTableModel)tbAccount.getModel();
	      String column[] = {"username", "pass"," gender"," Department"," Faculty"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("username"), rs.getString("pass"),rs.getString("gender"),rs.getString("Department"), rs.getString("Faculty")};    
					//String column[]={"ID","NAME","SALARY"};    
					//String column[] = {"username, pass, gender, Depart, Faculty"};
					tbAccount = new JTable(tm);
					tm.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	}
	public static void main(String agrs[]) {
		new facebookForm();
		
		
	}
	
}
