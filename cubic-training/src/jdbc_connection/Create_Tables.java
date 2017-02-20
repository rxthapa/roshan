package jdbc_connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Tables {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String Students = "create table Students(Id number(3) not null, CourseID number(5), Student_Name varchar(20), Score number(3), Grade varchar(5))";
		String Course = "create table Course(ID number(5) not null, Name varchar(20), Instructor varchar(20))";
		JDBC JC = new JDBC();
		Connection con = null;
		
			con = JC.getConnection();
			System.out.println("Connection Successful");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(Students);
			stmt.executeUpdate(Course);
			System.out.println("Tables Created");
		
		con.close();

	}

}
