import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text field
        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 200, 25);

        // Create a button to add user input to the text field
        JButton button = new JButton("Add User Input");
        button.setBounds(50, 100, 100, 25);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the user input
                String text = JOptionPane.showInputDialog("Enter some text:");

                // Add the user input to the text field
                textField.setText(text);
            }
        });

        // Add the text field and button to the frame
        frame.add(textField);
        frame.add(button);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
