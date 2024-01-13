package miscelleneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {

		//Create driver object and import from MySQL
		Driver driverRef = new Driver();

		//Step-1: Register the database/driver
		DriverManager.registerDriver(driverRef);

		//Step-2: Establish the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m4db","root","root");

		//Step-3: issue Create Statement
		Statement state = con.createStatement();

		//Step-4: execute an update 
		//executeUpdate() is used for all Non-Select queries- create, insert, update, delete, drop, truncate
		int result = state.executeUpdate("insert into customer_info values(13,'batman','california');");
		if(result==1) {
			System.out.println("Data added");
		}

		//Step-5: Close the DB
		con.close();

	}

}
