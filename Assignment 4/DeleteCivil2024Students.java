import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteCivil2024Students {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "root"
            );

            Statement st = con.createStatement();

            int rows = st.executeUpdate(
                    "DELETE FROM Students WHERE year = 2024 AND branch = 'Civil'"
            );

            System.out.println(rows + " records deleted");

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }
}
