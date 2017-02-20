package jdbc_connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCAssignment {
	static Scanner input = new Scanner(System.in);
	static JDBC JC = new JDBC();
	static Connection con = null;
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		while(true){
		
		System.out.print("1. Create Table\n2. Insert Data.\n3. View Data.\n4. Exit\nEnter your Choice: ");
		switch(input.nextInt()){
		case 1: {
				input.nextLine();
				System.out.print("Enter Create Table Command: ");
				con = JC.getConnection();
				String command = input.nextLine();
				Create_Tables newtable = new Create_Tables(con, command);
		}
		case 2: {
					do{
						insertdata data = new insertdata();
		
						System.out.print("Do You want to enter more Data? (Y/N) : "); 
					}while(input.next().charAt(0)=='y');
					
					System.out.println("\nTable updated...\n");
					break;
		}
		case 3: {
					JDBC JC = new JDBC();
					Connection con = null;
					con = JC.getConnection();
					String View;
					char again;
					do{
					System.out.println("1. Student.\n2. Course");
					System.out.print("Enter Your Choice: ");
					if (input.nextInt()==1){
						View = "select * from Students order by id";
						Statement stmt = con.createStatement();
						ResultSet result = stmt.executeQuery(View);
						System.out.println(String.format("\n%-8s%-12s%-18s%-8s%s","Std_ID","Course_ID","Student_Name","Score","Grade"));
						System.out.println("----------------------------------------------------");
						while(result.next()){
							System.out.println(String.format("%-8d%-12d%-18s%-8d%s",result.getInt(1),result.getInt(2),result.getString(3),result.getInt(4),result.getString(5)));
						}
					}
					else{
						View = "select * from Course order by id";
						Statement stmt = con.createStatement();
						ResultSet result = stmt.executeQuery(View);
						System.out.println(String.format("\n%-10s%-20s%s","CourseID","Course Name","Instructor"));
						System.out.println("----------------------------------------");
						while(result.next()){
							System.out.println(String.format("%-10d%-20s%s",result.getInt(1),result.getString(2),result.getString(3)));
						}
					}
					System.out.print("\nView Again ? (Y/N): ");
					again = input.next().charAt(0);
					System.out.println();
					}while(again =='y');
					con.close();
					break;
					
		}
		case 4: System.exit(0);
			
		}
		}	
	}

}
