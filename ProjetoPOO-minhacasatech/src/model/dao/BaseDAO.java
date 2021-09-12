package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO{
	Connection conn = null;
	String url = "jdbc:mariadb://localhost:3306/sceptic";
	String user = "root";
	String senha = "root";
	public Connection getConnection(){
		if(conn==null) {
			try {
				conn= DriverManager.getConnection(url,user,senha);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return conn;
		}
		
		else return conn;
		
	}
}


