import java.sql.*;

public class JDBCCallableStatementDemo {
    static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        System.out.printf("JDBC CallableStatement Demo \n\n");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_jan_26", "root", "rootroot");

        CallableStatement stmt = connection.prepareCall("{CALL GetAllProducts() }");

        ResultSet resultSet = stmt.executeQuery();

        // Loop through all the rows (records) returned by the database.
        System.out.printf(" QUERY  \n\n");
        System.out.println("ID | NAME         | PRICE     | DESCRIPTION");
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            double price = resultSet.getDouble("PRICE");
            String description = resultSet.getString("DESCRIPTION");

            System.out.printf("%d | %s  | %s  | %s \n", id, name, price, description);
        }

        // WITH an IN parameter
        CallableStatement stmt2 = connection.prepareCall("{CALL CountProductsByPrefix(?) }");
        stmt2.setString(1, "S");

        ResultSet resultSet2 = stmt2.executeQuery();
        // Loop through all the rows (records) returned by the database.
        System.out.printf(" CALL CountProductsByPrefix(?) demo  \n");
        while (resultSet2.next()) {
            int totalProducts = resultSet2.getInt("totalProducts");

            System.out.printf("%d products found \n", totalProducts);
        }

        // JDBC-TASK-3
        CallableStatement stmt3 = connection.prepareCall("{CALL FindLargestNumber(?,?) }");
        stmt3.setInt(1, 33);
        stmt3.setInt(2, 39);

        ResultSet resultSet3 = stmt3.executeQuery();
        System.out.printf(" CALL FindLargestNumber(?) demo  \n");
        while (resultSet3.next()) {
            int LargestNumber = resultSet3.getInt("LargestNumber");

            System.out.printf("%d is LargestNumber \n", LargestNumber);
        }

        connection.close();
    }
}