import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        System.out.printf("JDBC Demo \n\n");


        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_jan_26", "root", "rootroot");

        Statement stmt = connection.createStatement();

        ResultSet resultSet = stmt.executeQuery("select * from products");

        // Loop through all the rows (records) returned by the database.
        System.out.println("ID | NAME         | PRICE     | DESCRIPTION");
        while (resultSet.next()) {
            // ID | NAME         | PRICE     | DESCRIPTION

            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            double price = resultSet.getDouble("PRICE");
            String description = resultSet.getString("DESCRIPTION");


            System.out.printf("%s | %s  | %s  | %s \n", id, name, price, description);
        }

        connection.close();
    }
}