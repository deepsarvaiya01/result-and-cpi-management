import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Null Layout Example");
        frame.setLayout(null); // Set the layout to null

        // Set the size of the frame
        frame.setSize(700, 350);

        // Create the first button
        JButton button1 = new JButton("Student");
        button1.setBounds(240, 130, 100, 40); // Set bounds for the button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to perform when button 1 is clicked
                // System.out.println("Button 1 clicked");
                page7 abc= new page7();
                abc.setVisible(true);
                frame.dispose();
            }
        });
        frame.add(button1); // Add the button to the frame

        // Create the second button
        JButton button2 = new JButton("Faculty");
        button2.setBounds(400, 130, 100, 40); // Set bounds for the button
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to perform when button 2 is clicked
                // System.out.println("Button 2 clicked");
                page2 page2 = new page2();
                page2.setVisible(true);
            }
        });
        frame.add(button2); // Add the button to the frame

        // Make the frame visible
        frame.setVisible(true);
    }
}
