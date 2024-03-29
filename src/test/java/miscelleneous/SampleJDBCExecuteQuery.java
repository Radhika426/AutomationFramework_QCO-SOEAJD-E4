package miscelleneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		//Create driver object and import from MySQL
		Driver driverRef = new Driver();
		
		//Step-1: Register the database/driver
		DriverManager.registerDriver(driverRef);
		
		//Step-2: Establish the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m4db","root","root");
		
		//Step-3: issue Create Statement
		Statement state = con.createStatement();
		
		//Step-4: execute a query
		//executeQuery() is used for Select queries
		ResultSet result = state.executeQuery("select * from customer_info;");
		if(result.next()) {
			System.out.println(result.getString(1)+"-"+result.getString(2)+"-"+result.getString(3));
		}
		
		//Step-5: Close the DB
		con.close();

	}

}
