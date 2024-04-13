import javax.swing.*;
// import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class page12 extends JFrame {
    String value7 , value8 , value9 , value10 , value11;

     JTextField textField;
    private String gr_no1;
    private String newMark;
    String columnName;

    public page12(String gr_no) {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        gr_no1 = gr_no;

        JButton button1 = new JButton("Name");
        button1.setBounds(50, 50, 80, 30);
        button1.addActionListener(new ButtonActionListenerpage12("Name"));
        add(button1);

        JButton button2 = new JButton("JAVA");
        button2.setBounds(140, 50, 80, 30);
        button2.addActionListener(new ButtonActionListenerpage12("java"));
        add(button2);

        JButton save = new JButton("save");
        save.setBounds(110, 250, 80, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    newMark = textField.getText();
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hemli", "root", "********");
                    
                    String query = "UPDATE sem2 SET "+columnName+ " = ? WHERE gr_no = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, newMark);
                    preparedStatement.setString(2, gr_no1);
                    preparedStatement.executeUpdate();

                    String query2 = "SELECT * FROM sem2 WHERE gr_no = ?";
                    PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
                    preparedStatement2.setString(1, gr_no1);
                    ResultSet resultSet = preparedStatement2.executeQuery();
                    while (resultSet.next()) {
                     // Process result set for second query
                    System.out.println("Result: " + resultSet.getString("Name"));
                    System.out.println("Result: " + resultSet.getString("java"));
                    System.out.println("Result: " + resultSet.getString("os"));
                    System.out.println("Result: " + resultSet.getString("dm"));
                    System.out.println("Result: " + resultSet.getString("ada"));
                    System.out.println("Result: " + resultSet.getString("cn"));
                    
                    value7 = resultSet.getString("java");
                    value8 = resultSet.getString("os");
                    value9 = resultSet.getString("dm");
                    value10 = resultSet.getString("ada");
                    value11 = resultSet.getString("cn");
            }
            // String value7 = resultSet.getString("c");
            // String value8 = resultSet.getString("ds");
            // String value9 = resultSet.getString("dbms");
            // String value10 = resultSet.getString("python");
            // String value11 = resultSet.getString("ps");

            int sum;
                sum = Integer.parseInt(value7) + Integer.parseInt(value8)+ Integer.parseInt(value9)+Integer.parseInt(value10)+Integer.parseInt(value11);
                float sum2 = sum;
                float cgpa1 = (sum2/500)*9.5f;
                String cvalue = String.format("%.2f", cgpa1);
                System.out.println(cvalue);
                
            preparedStatement2.close();

            String query3 = "UPDATE sem2 SET cgpa = ? WHERE gr_no = ?";
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
        add(save);

        JButton button3 = new JButton("OS");
        button3.setBounds(230, 50, 80, 30);
        button3.addActionListener(new ButtonActionListenerpage12("os"));
        add(button3);

        JButton button4 = new JButton("DM");
        button4.setBounds(50, 100, 80, 30);
        button4.addActionListener(new ButtonActionListenerpage12("dm"));
        add(button4);

        JButton button5 = new JButton("ADA");
        button5.setBounds(140, 100, 80, 30);
        button5.addActionListener(new ButtonActionListenerpage12("ada"));
        add(button5);

        JButton button6 = new JButton("CN");
        button6.setBounds(230, 100, 80, 30);
        button6.addActionListener(new ButtonActionListenerpage12("cn"));
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
    class ButtonActionListenerpage12 implements ActionListener {
        private String myParameter;
    
        public ButtonActionListenerpage12(String parameter) {
            myParameter = parameter;
            System.out.println("Selected value1: " + myParameter);
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            page12 rTable = (page12) button.getTopLevelAncestor();
            rTable.columnName = myParameter;
           
            System.out.println("Selected value7: " + myParameter);
            System.out.println("Selected value8: " + rTable.columnName );
            rTable.textField.setVisible(true);

            // rTable.label10.setText("Your Selected Number is:"+String.valueOf(rTable.storedValue));
            // rTable.label10.setVisible(true);
    
    
    
        }
    }

