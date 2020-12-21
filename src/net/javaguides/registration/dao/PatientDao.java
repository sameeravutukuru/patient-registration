package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Patient;

public class PatientDao {
	
	public int registerPatient(Patient patient)throws ClassNotFoundException{
		String INSERT_USERS_SQL = "INSERT INTO patient" + 
	" (pid, first_name, last_name, username, password, address, contact) VALUES" +
	"(?, ?, ?, ?, ?, ?, ?);";
		
		int result= 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false","root","Admin123456!");
			
			// step 2:Create a statement using connection object	
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setInt(1,1);
			preparedStatement.setString(2,patient.getFirstname());
			preparedStatement.setString(3,patient.getLastname());
			preparedStatement.setString(4,patient.getUsername());
			preparedStatement.setString(5,patient.getPassword());
			preparedStatement.setString(6,patient.getAddress());
			preparedStatement.setString(7,patient.getContact());
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
		
		}catch(SQLException e) {
			// process sql exception
			e.printStackTrace();
		}
		return result;
	} 
}
