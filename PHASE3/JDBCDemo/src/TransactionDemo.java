import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class TransactionDemo {
    static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        System.out.print("Transactions Demo \n\n");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_jan_26", "root", "rootroot");

        // Enable manually commits
        connection.setAutoCommit(false);

        try {
            String insertSQL = "INSERT INTO products (name, price) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertSQL);

            stmt.setString(1, "HP AI PC 10");
            stmt.setFloat(2, 65000.0f);
            stmt.addBatch();

            stmt.setString(1, "HP AI PC 20");
            stmt.setFloat(2, 75000.0f);
            stmt.addBatch();

            stmt.setString(1,
                    "HP AI PC 30 QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
            stmt.setFloat(2, 67000.0f);
            stmt.addBatch();

            stmt.setString(1, "HP AI PC 40");
            stmt.setFloat(2, 76000.0f);
            stmt.addBatch();

            int[] counts = stmt.executeBatch();

            connection.commit();

            System.out.printf("%s products were inserted successfully", Arrays.toString(counts));

        } catch (Exception e) {
            System.err.println("Something went wrong!");
            System.err.println(e);

            try {
                connection.rollback();
                System.err.println("Rollback happened!");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            connection.close();
        }

    }
}
