import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateAndInsertStudents {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "root"
            );

            Statement st = con.createStatement();

            String createTable =
                    "CREATE TABLE IF NOT EXISTS Students (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "branch VARCHAR(20)," +
                    "semester INT," +
                    "percentage DOUBLE," +
                    "year INT)";

            st.execute(createTable);

            st.executeUpdate(
                    "INSERT INTO Students VALUES " +
                    "(1,'Amit','CSE',7,75,2024)," +
                    "(2,'Ravi','EC',7,68,2023)," +
                    "(3,'Neha','Civil',6,70,2024)"
            );

            System.out.println("Table created and records inserted");

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }
}
