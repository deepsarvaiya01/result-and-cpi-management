import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page3 extends JFrame {
    page3() {

        // JFrame frame = new JFrame("Null Layout Example");
        setLayout(null); // Set the layout to null

        // Set the size of the frame
        setSize(700, 350);

        // Create the first button
        JButton button1 = new JButton("ADD");
        button1.setBounds(100, 130, 100, 40); // Set bounds for the button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                page4 add = new page4();
                add.setSize(800,800);
                add.setVisible(true);
                dispose();

               
            }
        });
        add(button1); // Add the button to the frame

        // Create the second button
        JButton button2 = new JButton("VIEW");
        button2.setBounds(240, 130, 100, 40); // Set bounds for the button
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to perform when button 2 is clicked
                // System.out.println("Button 2 clicked");
                page7 abc= new page7();
                abc.setVisible(true);
                dispose();
            }
        });
        add(button2); // Add the button to the frame

        JButton button3 = new JButton("CHANGE");
        button3.setBounds(400, 130, 100, 40); // Set bounds for the button
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to perform when button 1 is clicked
                // System.out.println("Button 1 clicked");
                page10 add = new page10();
                // add.setSize(800,800);
                add.setVisible(true);
                dispose();

            }
        });
        add(button3); // Add the button to the frame

        // Make the frame visible
        setVisible(true);
    }
}
