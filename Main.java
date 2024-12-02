package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Operations connection2 = new Operations();
		Connections connection=new Connections();
		
		
    	connection2.FindStudentsWithProfileJoin();
		
	//	connection2.FindStudentsWithGroupByName();

		connection.getConnection();
		String createtable = connection2.Createtable();
	//	System.out.println(createtable); 
		
		String createtable2 = connection2.Createtable2();
	//	System.out.println(createtable2); 
		
		String name ="siddhe";
		int salary= 25;
	//	connection2.Insertdata(name , salary); 
		
		
		String subject ="Hindi";
		int password=1234;
		int id=2;
	//	connection2.Insertdata2(subject ,password , id);


     //	connection2.Selectdata();

	/*	Scanner sc=new Scanner(System.in);
		String name=sc.next();
		String name2=sc.next();

		int updatedata = connection2.Updatedata(name , name2);
		System.out.println(updatedata); */

	//	int deletedata = connection2.Deletedata(5);
	//	System.out.println(deletedata);
		
	/*	Scanner sc=new Scanner(System.in);
		Long id=sc.nextLong();
		 connection2.FindById(id); */
		 
	/*	 Scanner sc=new Scanner(System.in);
			String name=sc.next();
			 connection2.FindStudentsWithName(name);*/
		
	/*	if( findById != null) {
			System.out.println(findById.getName()+" "+findById.getAge());
		} */

		// sc.close();
		connection.getConnection().close();
	}
}
