package giaodien;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class ConnectDB {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public Connection connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getConstructor().newInstance();
			String connectionUrl = "jdbc:sqlserver://DESKTOP-TM4S549\\SQLEXPRESS:1433;databaseName=Student;user=sa;password=123456789";
			conn = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
/*	public int addNew(String sql) {
		int record=0;
		try {
			connect();
			stmt = conn.createStatement();
			record = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return record;
	}*/
	public int executeDB(String sql) { //insert, update, delete
		int record=0;
		try {
			connect();
			stmt = conn.createStatement();
			record = stmt.executeUpdate(sql); //so luong hang thay doi sau khi thuc hien 1 trong 3 cau lenh tren
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return record;
	}
	public ResultSet listAll(String sql) {
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				//conn.close();
				//stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return rs;
	
	}
	
	
}
/*JRadioButton rb1=new JRadioButton("A) Male");    
	JRadioButton rb2=new JRadioButton("B) Female");*/
/*	btSignUp.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	ConnectDB cnn = new ConnectDB();
	String gender ="";
	if(rbMale.isSelected()) gender= rbMale.getText();
	else gender = rbFemale.getText();
	cnn.executeDB(" Exec sp_AddAccount'"+tfFirst.getText()+"','"+pass.getText()+"','"+gender+"'");
	
}
});
btnUpdate.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	ConnectDB cnn = new ConnectDB();
	int record = cnn.executeDB("Update Account set pass ='"+pass.getText()+"'where username ='"+tfFirst.getText()+"'");
	if(record >0) JOptionPane.showMessageDialog(null, "Change Pass sucessfully!");
	else JOptionPane.showMessageDialog(null, "Error");
}
});
btDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	ConnectDB cnn = new ConnectDB();
	int record = cnn.executeDB("Delete Account where username ='"+rbFemale.getText()+"'");
	if(record >0) JOptionPane.showMessageDialog(null, "Delete Account sucessfully!");
	else JOptionPane.showMessageDialog(null, "Error");
}
});
btselect.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	ConnectDB cnn = new ConnectDB();
	int record = cnn.executeDB("Select gender from Account ='"+tfFirst.getText()+"'");
	if(record >0) JOptionPane.showMessageDialog(null, "Delete Account sucessfully!");
	else JOptionPane.showMessageDialog(null, "Error");
}
});
btlist.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
	ConnectDB cnn = new ConnectDB();
	String gender="";
	if(rbMale.isSelected()) gender=rbMale.getText();
	else gender = rbFemale.getText();
	rs = cnn.listAccount("exec [sp_SelAccount] '"+gender+"' ");
	try {
		while(rs.next()) {
			System.out.println("username ="+rs.getString("username"));
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}  }
);*/

