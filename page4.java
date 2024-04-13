import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page4 extends JFrame {
    page4() {
        // Create a JFrame
    //    JFrame frame = new JFrame("Text Field Example");

        // Set the size of the frame
        setSize(800, 800);
        setLayout(null);

        JLabel label = new JLabel("GR_NO:");
        label.setBounds(50, 20, 100, 25); // Set bounds for the label
        add(label);

        // Create the first text field
        JTextField textField1 = new JTextField();
        textField1.setBounds(50, 50, 200, 25); // Set bounds for the text field
        add(textField1); // Add the text field to the frame

        // // Create the second text field
        // JTextField textField2 = new JTextField();
        // textField2.setBounds(50, 100, 200, 25); // Set bounds for the text field
        // frame.add(textField2); // Add the text field to the frame

        JButton sem1Button = new JButton("sem-1");
        sem1Button.setBounds(50, 150, 100, 25);
        add(sem1Button);

        JButton sem2Button = new JButton("sem-2");
        sem2Button.setBounds(50, 250, 100, 25);
       add(sem2Button);
        // Add an ActionListener to the button
        sem1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = textField1.getText();
                // String text2 = textField2.getText();
                System.out.println("Text 1: " + text1);
                // System.out.println("Text 2: " + text2);
               page5 a = new page5(text1);
               a.setVisible(true);
            //    frame.setSize(700, 700);
            //    frame.setLayout(null);
               
                
            }
        });
        sem2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = textField1.getText();
                // String text2 = textField2.getText();
                System.out.println("Text 1: " + text1);
                // System.out.println("Text 2: " + text2);
               page6 a = new page6(text1);
               a.setVisible(true);
               dispose();
            //    frame.setSize(700, 700);
            //    frame.setLayout(null);
               
                
            }
        });
        

        // Make the frame visible
        setVisible(true);
    }
}
