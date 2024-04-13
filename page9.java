import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class page9 extends JFrame {

    public page9(String gr_no) {
        setSize(700, 700);
        setLayout(null);

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hemli", "root", "*********");

            // Select query to retrieve rows for the specified gr_no
            String query = "SELECT * FROM `sem2` WHERE gr_no = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, gr_no);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            int y = 50; // Initial Y position for labels

            // Iterate over the result set and display values in JLabels
            int row = 1;
            while (resultSet.next()) {
                String rowValues = "Row " + row + ": " +
                                   "GR_NO = " + resultSet.getString("gr_no") + "\n " +
                                   "Name = " + resultSet.getString("Name") + "\n " +
                                   "JAVA = " + resultSet.getString("java") + "\n " +
                                   "OS = " + resultSet.getString("os") + "\n " +
                                   "DM = " + resultSet.getString("dm") + "\n " +
                                   "ADA = " + resultSet.getString("ada") + "\n " +
                                   "CN = " + resultSet.getString("cn") + "\n " +
                                   "CGPA = " + resultSet.getString("cgpa");

                JLabel label = new JLabel(rowValues);
                label.setBounds(50, y, 600, 25);
                add(label);

                y += 30; // Increment Y position for next label
                row++;
            }

            // Close the connection
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error executing select query: " + ex.getMessage());
        }

        setVisible(true);
    }

 
}
