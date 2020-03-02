package man;

import java.sql.*;
import javax.swing.*;
public class connection {
	
    Connection con=null;
	public static Connection dbConnector(){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/company","root","");  
        JOptionPane.showMessageDialog(null, "Connection Successful");
        return con;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
