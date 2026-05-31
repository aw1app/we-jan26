import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableDemo {
    static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        System.out.print("--JDBC CreateTableDemo Demo--\n");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_jan_26", "root", "rootroot");

        Statement statement = connection.createStatement();

        boolean isQuery = statement.execute("CREATE TABLE employees(ID INT, NAME VARCHAR(80))");

        System.out.print("Created table employees successfully !! \n");

//        boolean isQuery = statement.execute("DROP TABLE employees");
//        System.out.printf("Deleted table employees successfully !! \n");

        connection.close();
    }
}