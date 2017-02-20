package jdbc_connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Tables {

	Create_Tables(Connection conn, String name) throws ClassNotFoundException, SQLException{
		CreateTable(conn, name);
	}
	public static void CreateTable(Connection Conn, String name) throws SQLException, ClassNotFoundException {
			System.out.println("Connection Successful");
			Statement stmt = Conn.createStatement();
			stmt.executeUpdate(name);
			System.out.println("Tables Created");
		
		Conn.close();

	}

}
