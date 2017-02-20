package jdbc_connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insertdata {
	Scanner input = new Scanner(System.in);
	
	String Grade = "null";
	
	JDBC JC = new JDBC();
	Connection con = null;
	
	insertdata() throws ClassNotFoundException, SQLException{
		System.out.println("Choose table from Following to Enter data..");
		System.out.println("1. Student.\n2. Course");
		System.out.print("Enter Your Choice: ");
		int choice = input.nextInt();
		input.nextLine();
		int sid, scid, Score;
		String Sname;
		int icid; 
		String Cname, Instructor;
		switch (choice){
			case 1: {
				System.out.print("Enter Student Name: ");
				Sname = input.nextLine();
				System.out.print("Enter Student Id: ");	
				sid = input.nextInt();
				System.out.print("Enter Course Id: ");	
				scid = input.nextInt();
				System.out.print("Enter Course Score: ");	
				Score = input.nextInt();
				this.insert_Student(sid, scid, Sname, Score, this.Grade);
				break;}
			case 2: {
				System.out.print("Enter Course Id: ");	
				icid = input.nextInt();
				input.nextLine();
				System.out.print("Enter Course Name: ");
				Cname = input.nextLine();
				System.out.print("Enter Instructor Name: ");
				Instructor = input.nextLine();
				this.insert_Course(icid, Cname, Instructor);
				break;
			}
		}

		
	}
	
	insertdata(int icid, String Cname, String Instructor) throws ClassNotFoundException, SQLException{

		this.insert_Course(icid, Cname, Instructor);
	}
	
	public void insert_Student(int sid, int scid, String Sname, int Score, String Grade) throws SQLException, ClassNotFoundException {
	
		String insert_Students = "insert into Students values("+sid+","+scid+",'"+Sname +"',"+Score+",'"+Grade+"')";
		
			con = JC.getConnection();
			System.out.println("Connection Successful");
			Statement stmt = con.createStatement();
			System.out.println("Inserting data into the Student table.....");
			stmt.executeUpdate(insert_Students);
			System.out.println("Data Inserted");
		
		con.close();
		System.out.println("Connection Closed.....\n");
		
	}
	
	public void insert_Course(int icid, String Cname, String instructor) throws SQLException, ClassNotFoundException {
		
		String insert_Course = "insert into Course values("+icid+",'"+Cname +"','"+instructor+"')";

			con = JC.getConnection();
			System.out.println("Connection Successful");
			Statement stmt = con.createStatement();
			System.out.println("Inserting data into the Course table.....");
			stmt.executeUpdate(insert_Course);
			System.out.println("Data Inserted");
		
		con.close();
		System.out.println("Connection Closed.....\n");


	}


}
