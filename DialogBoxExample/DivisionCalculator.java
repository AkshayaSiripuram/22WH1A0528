package guipro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field;

    public DivisionCalculator() {
        setTitle("Division Calculator");
        setSize(300, 250); 
        setLayout(new FlowLayout());

        JLabel num1Label = new JLabel("Enter number 1:");
        num1Field = new JTextField(10);
        num1Field.setPreferredSize(new Dimension(300, 50)); 

        JLabel num2Label = new JLabel("Enter number 2:");
        num2Field = new JTextField(10);
        num2Field.setPreferredSize(new Dimension(300, 50)); 
        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(this);
        divideButton.setPreferredSize(new Dimension(300,50));

        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(divideButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            double result = num1 / num2;

            String resultMessage = "Result: " + result;
            JOptionPane.showMessageDialog(this, resultMessage, "Division Result", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            displayException("Invalid input. Please enter valid numbers.");
        } catch (ArithmeticException ex) {
            displayException("Error: Division by zero is not allowed.");
        } catch (Exception ex) {
            displayException("An error occurred: " + ex.getMessage());
        }
    }

    private void displayException(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DivisionCalculator calculator = new DivisionCalculator();
            calculator.setVisible(true);
        });
    }
}
