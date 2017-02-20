package jdbc_connection;

import java.sql.Connection;
import java.sql.SQLException;

public class testJDBC {

	public static void main(String[] args) throws SQLException {
		JDBC Jconn = new JDBC();
		Connection con = null;
		
		try {
			con = Jconn.getConnection();
			System.out.println("Connectiton Successful..");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to connect to Database..");	
		} catch (SQLException e){
			System.out.println("Unable to connect to Database..");	 
		}
		con.close();
		System.out.println("Connection Closed..");
		

	}

}
