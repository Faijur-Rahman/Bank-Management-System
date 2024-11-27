package bankManagement;

import java.sql.*;

public class conn {

    Connection connection;
    Statement statement;
    public conn() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","username","pass");
            statement = connection.createStatement();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
