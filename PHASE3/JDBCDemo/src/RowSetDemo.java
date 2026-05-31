import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowSetDemo {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/we_jan_26";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";


    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        con.setAutoCommit(false);

        RowSetFactory factory = RowSetProvider.newFactory();

        try (CachedRowSet rowSet = factory.createCachedRowSet()) {
            loadInitialData(rowSet, con);

            rowSet.absolute(3); // go to fifth 3 row
            System.out.printf("%-4d  %-20s  %12.2f \n", rowSet.getInt("id"), rowSet.getString("name"),
                    rowSet.getFloat("price"));

            rowSet.absolute(7); // go to fifth 7 row
            System.out.printf("%-4d  %-20s  %12.2f \n", rowSet.getInt("id"), rowSet.getString("name"),
                    rowSet.getFloat("price"));

        } catch (Exception e) {
            System.out.println(e);
        }

        con.close();
    }

    private static void loadInitialData(CachedRowSet rowSet, Connection con) throws SQLException {
        rowSet.setTableName("products");
        rowSet.setKeyColumns(new int[] { 1 }); // id the primary
        rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);

        rowSet.setCommand("SELECT * FROM products");
        rowSet.execute(con);
    }

}
