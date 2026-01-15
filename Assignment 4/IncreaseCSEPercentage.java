import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class IncreaseCSEPercentage {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "root"
            );

            Statement st = con.createStatement();

            int rows = st.executeUpdate(
                    "UPDATE Students SET percentage = percentage * 1.05 WHERE branch = 'CSE'"
            );

            System.out.println(rows + " records updated");

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }
}
