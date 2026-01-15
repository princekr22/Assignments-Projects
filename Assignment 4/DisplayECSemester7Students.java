import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayECSemester7Students {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "root"
            );

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM Students WHERE semester = 7 AND branch = 'EC'"
            );

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch") + " " +
                        rs.getInt("semester") + " " +
                        rs.getDouble("percentage") + " " +
                        rs.getInt("year")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }
}
