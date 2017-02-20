package jdbc_connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultQuery {

	public static void main(String[] args) throws SQLException {
		String Result = "select * from person order by id";
		
		JDBC JC = new JDBC();
		Connection con = null;
		try {
			con = JC.getConnection();
			System.out.println("Connection Successful");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Result);
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			System.out.println("End of Datas...");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		con.close();
		System.out.println("Connection Closed.....");

	}

}
