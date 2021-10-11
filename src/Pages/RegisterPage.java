package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Arrays;

public class RegisterPage extends BasePage{

    final private JLabel usernameLabel = new JLabel("Username");
    private JTextField usernameTextField = new JTextField();

    final private JLabel passwordLabel = new JLabel("Password");
    private JPasswordField passwordField = new JPasswordField();

    final private JLabel confirmPasswordLabel = new JLabel("Confirm password");
    private JPasswordField confirmPasswordField = new JPasswordField();

    private JButton returnButton = new JButton("Return to login page");
    private JButton registerButton = new JButton("Register");

    final private GridLayout gridLayout = new GridLayout(5, 2);

    public RegisterPage() {
        super("Register");

        setLayout(gridLayout);

        add(usernameLabel);
        add(usernameTextField);

        add(passwordLabel);
        add(passwordField);

        add(confirmPasswordLabel);
        add(confirmPasswordField);

        returnButton.addActionListener(returnToLoginPage());
        add(returnButton);

        registerButton.addActionListener(registerNewUser());
        add(registerButton);

        setVisible(true);
    }

    private ActionListener returnToLoginPage(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        };
    }

    private ActionListener registerNewUser(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tryWritingToFile()){
                    usernameTextField.setText("");
                    passwordField.setText("");
                    confirmPasswordField.setText("");
                }
            }
        };
    }

    private boolean checkCredentials(){
        if(Arrays.equals(passwordField.getPassword(), confirmPasswordField.getPassword())){
            System.out.println("password are equals = " + Arrays.toString(passwordField.getPassword()) + " and " + Arrays.toString(confirmPasswordField.getPassword()));
            return true;
        } else{
            JOptionPane.showMessageDialog(null, "Passwords don't match");
            return false;
        }
    };

    private boolean tryWritingToFile(){
        try {
            FileWriter writer = new FileWriter("users.txt", true);
            if(checkCredentials()){
                writer.write(usernameTextField.getText());
                writer.write(",");
                writer.write(passwordField.getPassword());
                writer.write("\n");
                writer.close();
                return true;
            }
        } catch (Exception err){
            System.out.println(err.getMessage());
            JOptionPane.showMessageDialog(null, "Error!");
            return false;
        }

        return false;
    }
}
