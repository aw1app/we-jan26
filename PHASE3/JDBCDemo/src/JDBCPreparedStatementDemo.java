import java.sql.*;

public class JDBCPreparedStatementDemo {
    static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        System.out.printf("JDBCPreparedStatementDemo \n\n");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_jan_26", "root", "rootroot");

        PreparedStatement stmt = connection.prepareStatement("select * from products WHERE name like ? and price > ? ");

        stmt.setString(1,"S%");
        stmt.setDouble(2,30000.0d);

        ResultSet resultSet = stmt.executeQuery();

        // Loop through all the rows (records) returned by the database.
        System.out.println("ID | NAME         | PRICE     | DESCRIPTION");
        while (resultSet.next()) {

            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            double price = resultSet.getDouble("PRICE");
            String description = resultSet.getString("DESCRIPTION");

            System.out.printf("%d | %s  | %s  | %s \n", id, name, price, description);
        }


        connection.close();
    }
}