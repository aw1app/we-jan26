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

            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            double price = resultSet.getDouble("PRICE");
            String description = resultSet.getString("DESCRIPTION");

            System.out.printf("%d | %s  | %s  | %s \n", id, name, price, description);
        }


        // INSERT a new Record demo.
        //INSERT INTO products(NAME,PRICE,DESCRIPTION) VALUES('NOKIA', 15000.99, 'Great Phone for Elderly');
        String sqlInsert = "INSERT INTO products(NAME,PRICE,DESCRIPTION) VALUES('NOKIA-2', 15000.99, 'Great Phone for Elderly-2')";

//        int rows = stmt.executeUpdate(sqlInsert);
//        System.out.printf("Inserted %d row successfully \n!", rows);

        // DELETE demo
        String sqlDeletePrice700 = "DELETE FROM products WHERE PRICE=12000.99";
        int rowsDeleted = stmt.executeUpdate(sqlDeletePrice700);

        System.out.printf("Updated %d row(s) successfully! \n", rowsDeleted);

        // Updation demo
        String sqlUpdateName = "UPDATE products SET NAME='NOKIA - NEW GENERATION' WHERE NAME='NOKIA-2'";
        int rowsUpdatedCount = stmt.executeUpdate(sqlUpdateName);
        System.out.printf("Updated %d row(s) successfully! \n", rowsUpdatedCount);

        connection.close();
    }
}