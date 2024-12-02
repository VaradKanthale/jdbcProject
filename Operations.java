package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class Operations {
	
	Connections connection=new Connections();
	
	Students student=new Students();


	public String Createtable() throws SQLException {

		String createTableSQL = "CREATE TABLE IF NOT EXISTS Students (" + "id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "name VARCHAR(50)," + "salary INT )";

			PreparedStatement statement = connection.getConnection().prepareStatement(createTableSQL);
			
				int executeUpdate = statement.executeUpdate();


		return "Table is Created Students";
	}
	
	public String Createtable2() throws SQLException {

		String createTableSQL2 = "CREATE TABLE IF NOT EXISTS Profile (" + "profileId INT PRIMARY KEY AUTO_INCREMENT,"
	    	+ "subject VARCHAR(50), "
				+ "password INT, " 
	    	 +"id INT, " +
                "FOREIGN KEY (id) REFERENCES Students(id) )";

			PreparedStatement statement = connection.getConnection().prepareStatement(createTableSQL2);
			
				int executeUpdate = statement.executeUpdate();


		return "Table is Created Profile";
	}
	
	public void FindById(Long  id) throws SQLException {

		String findById = "SELECT * FROM Students WHERE id = ?";

		
				PreparedStatement statement = connection.getConnection().prepareStatement(findById);

			statement.setLong(1, id);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3));
				/*st2.setId(result.getInt(1));
				st2.setName(result.getString(2));
				st2.setAge(result.getInt(3)); */
				

			}
	}

	public void FindStudentsWithName(String name) throws SQLException {


		String findWithName = "SELECT * FROM Students WHERE name LIKE ?";

		  PreparedStatement statement = connection.getConnection().prepareStatement(findWithName);

			statement.setString(1, name+"%");

			ResultSet result = statement.executeQuery();

			while (result.next()) {


				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3));
				/*st2.setId(result.getInt(1));
				st2.setName(result.getString(2));
				st2.setAge(result.getInt(3)); */

			}

	}
	
	public void FindStudentsWithGroupByName() throws SQLException {


		String findWithGroupByName = "SELECT name ,max(age) as age FROM Students GROUP BY name";

		 PreparedStatement statement = connection.getConnection().prepareStatement(findWithGroupByName);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				System.out.println(result.getString(1)+" "+result.getInt(2));
				/*st2.setId(result.getInt(1));
				st2.setName(result.getString(2));
				st2.setAge(result.getInt(3)); */

			}
	}
	public void FindStudentsWithProfileJoin() throws SQLException {


		String FindStudentsWithProfileJoin = "SELECT s.name AS name , s.salary AS salary , s1.name AS name2, s1.salary AS salary2 , (s.salary- s1.salary) AS Difference FROM students s JOIN students s1 ON s.id != s1.id; ";

		 PreparedStatement statement = connection.getConnection().prepareStatement(FindStudentsWithProfileJoin);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				System.out.println(result.getString(1) +" , "+result.getInt(2) +" , "+result.getString(3) +" , "+result.getInt(4) +" , "+result.getInt(5));
				/*st2.setId(result.getInt(1));
				st2.setName(result.getString(2));
				st2.setAge(result.getInt(3)); */

			}
	}
	
	public void Insertdata(String name, int salary) throws SQLException {

		String insertDataSQL = "INSERT INTO Students (name,salary) VALUES (? , ?)";

	
				PreparedStatement statement = connection.getConnection().prepareStatement(insertDataSQL);
			// statement.executeUpdate();

			statement.setString(1, name);
			statement.setInt(2, salary);
			statement.executeUpdate();

			System.out.println("insert record Sucessfully");
	}
	
	public void Insertdata2(String subject, int password, int id) throws SQLException {

		String insertDataSQL2 = "INSERT INTO Profile(subject , password , id) VALUES (? , ?, ? )";

	
				PreparedStatement statement = connection.getConnection().prepareStatement(insertDataSQL2);
			// statement.executeUpdate();

			statement.setString(1, subject);
			statement.setInt(2, password);
			statement.setInt(3, id);
			statement.executeUpdate();

			System.out.println("insert record Sucessfully");
	}


	public void Selectdata() throws SQLException {

		String selectAllSQL = "SELECT * FROM Students";

		PreparedStatement statement = connection.getConnection().prepareStatement(selectAllSQL);

		ResultSet result = statement.executeQuery();
		List<Students> st = new ArrayList<Students>();
		System.out.println("Data from the table:");
		while (result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			int age = result.getInt("age");

			Students st2 = new Students(id, name, age);
			st.add(st2);

		}
		Map<Object, Long> count = st.stream().collect(Collectors.groupingBy(x -> x.getName() ,Collectors.counting() ));
		System.out.println(count);
		
		/*for (Students res : st) {
			System.out.println(res.getId() + " " + res.getName() + " " + res.getAge());

		} */
	}

	public int Updatedata(String name, String name2) throws SQLException {
		String updateSql = "UPDATE Students SET name = ? WHERE name LIKE ?";

		PreparedStatement statement = connection.getConnection().prepareStatement(updateSql);

		statement.setString(1, name);
		
		statement.setString(2, name2+"%");
		int rowsUpdated = statement.executeUpdate();

		return rowsUpdated;
	}

	public int Deletedata(int id) throws SQLException {

		String deleteSql = "DELETE FROM Students WHERE id = ?";

		PreparedStatement statement = connection.getConnection().prepareStatement(deleteSql);

		statement.setInt(1, id);

		int executeUpdate = statement.executeUpdate();

		return executeUpdate;
	}

}
