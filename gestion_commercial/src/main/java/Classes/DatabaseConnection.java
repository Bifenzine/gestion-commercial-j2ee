package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
    	//System.out.println("gggggg");
     if (connection == null || connection.isClosed()) {
    	 //System.out.println("rrrrrr");
    		Class.forName("com.mysql.jdbc.Driver");
            connection =DriverManager.getConnection
            		 ("jdbc:mysql://localhost:3306/gestion_commercial","mohamed","123456");
        	//System.out.println("fgfgff");
        }
        return connection;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle any potential exceptions here, such as logging or rethrowing
                e.printStackTrace();
            }
        }
    }
}
