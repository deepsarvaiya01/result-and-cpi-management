import javax.swing.*;
// import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class page11 extends JFrame {
    String value2 , value3 , value4 , value5 , value6;

     JTextField textField;
    private String gr_no1;
    private String newMark;
    String columnName;

    public page11(String gr_no) {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        gr_no1 = gr_no;

        JButton button1 = new JButton("Name");
        button1.setBounds(50, 50, 80, 30);
        button1.addActionListener(new ButtonActionListenerpage11("Name"));
        add(button1);

        JButton button2 = new JButton("C");
        button2.setBounds(140, 50, 80, 30);
        button2.addActionListener(new ButtonActionListenerpage11("c"));
        add(button2);

        JButton save = new JButton("save");
        save.setBounds(110, 250, 80, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    newMark = textField.getText();
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hemli", "root", "*********");
                    
                    String query = "UPDATE sem1 SET "+columnName+ " = ? WHERE gr_no = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, newMark);
                    preparedStatement.setString(2, gr_no1);
                    preparedStatement.executeUpdate();

                    String query2 = "SELECT * FROM sem1 WHERE gr_no = ?";
                    PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
                    preparedStatement2.setString(1, gr_no1);
                    ResultSet resultSet = preparedStatement2.executeQuery();
                    while (resultSet.next()) {
                     // Process result set for second query
                    System.out.println("Result: " + resultSet.getString("Name"));
                    System.out.println("Result: " + resultSet.getString("c"));
                    System.out.println("Result: " + resultSet.getString("ds"));
                    System.out.println("Result: " + resultSet.getString("dbms"));
                    System.out.println("Result: " + resultSet.getString("python"));
                    System.out.println("Result: " + resultSet.getString("ps"));
                    
                    value2 = resultSet.getString("c");
                    value3 = resultSet.getString("ds");
                    value4 = resultSet.getString("dbms");
                    value5 = resultSet.getString("python");
                    value6 = resultSet.getString("ps");
            }
            // String value2 = resultSet.getString("c");
            // String value3 = resultSet.getString("ds");
            // String value4 = resultSet.getString("dbms");
            // String value5 = resultSet.getString("python");
            // String value6 = resultSet.getString("ps");

            int sum;
                sum = Integer.parseInt(value2) + Integer.parseInt(value3)+ Integer.parseInt(value4)+Integer.parseInt(value5)+Integer.parseInt(value6);
                float sum2 = sum;
                float cgpa1 = (sum2/500)*9.5f;
                String cvalue = String.format("%.2f", cgpa1);
                System.out.println(cvalue);
                
            preparedStatement2.close();

            String query3 = "UPDATE sem1 SET cgpa = ? WHERE gr_no = ?";
            PreparedStatement preparedStatement3 = conn.prepareStatement(query3);
            preparedStatement3.setString(1, cvalue);
            preparedStatement3.setString(2, gr_no1);
            preparedStatement3.executeUpdate();
            
                    conn.close();
                    JOptionPane.showMessageDialog(null, "Marks updated successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating marks: " + ex.getMessage());
                }
            }

    
        });

        // save.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         System.out.println("Second Action");
        //     }
        // });
        add(save);

        JButton button3 = new JButton("DS");
        button3.setBounds(230, 50, 80, 30);
        button3.addActionListener(new ButtonActionListenerpage11("ds"));
        add(button3);

        JButton button4 = new JButton("DBMS");
        button4.setBounds(50, 100, 80, 30);
        button4.addActionListener(new ButtonActionListenerpage11("dbms"));
        add(button4);

        JButton button5 = new JButton("Python");
        button5.setBounds(140, 100, 80, 30);
        button5.addActionListener(new ButtonActionListenerpage11("python"));
        add(button5);

        JButton button6 = new JButton("PS");
        button6.setBounds(230, 100, 80, 30);
        button6.addActionListener(new ButtonActionListenerpage11("ps"));
        add(button6);

        textField = new JTextField("");
        textField.setBounds(50, 150, 260, 30);
        textField.setVisible(false);
        add(textField);

        setVisible(true);
    }
}
    // private class ButtonActionListener implements ActionListener {
    //     public ButtonActionListener(meString colna) {
    //         columnName = colname;
    //     }

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         textField.setVisible(true);
    //     }
    // }
    class ButtonActionListenerpage11 implements ActionListener {
        private String myParameter;
    
        public ButtonActionListenerpage11(String parameter) {
            myParameter = parameter;
            System.out.println("Selected value1: " + myParameter);
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            page11 rTable = (page11) button.getTopLevelAncestor();
            rTable.columnName = myParameter;
           
            System.out.println("Selected value2: " + myParameter);
            System.out.println("Selected value3: " + rTable.columnName );
            rTable.textField.setVisible(true);

            // rTable.label10.setText("Your Selected Number is:"+String.valueOf(rTable.storedValue));
            // rTable.label10.setVisible(true);
    
    
    
        }
    }

