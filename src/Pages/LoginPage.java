package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends BasePage {

    final private JLabel usernameLabel = new JLabel("Username");
    private JTextField usernameTextField = new JTextField();

    final private JLabel passwordLabel = new JLabel("Password");
    private JPasswordField passwordField = new JPasswordField();

    final private GridLayout gridLayout = new GridLayout(3, 2);

    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");

    public LoginPage(){
        super("Login Page");

        setLayout(gridLayout);

        add(usernameLabel);
        add(usernameTextField);

        add(passwordLabel);
        add(passwordField);

        loginButton.addActionListener(loginUser());
        add(loginButton);

        registerButton.addActionListener(goToRegisterPage());
        add(registerButton);

        setVisible(true);
    }

    private ActionListener goToRegisterPage() {
        return new ActionListener() {
            int timesClicked = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                timesClicked++;
                System.out.println("RegisterButton clicked " + timesClicked + " times.");
            }
        };
    }

    private ActionListener loginUser() {
        return event -> {
            String username = usernameTextField.getText();
            System.out.println("Username = " + username);

            String password = String.valueOf(passwordField.getPassword());
            System.out.println("Password = " + password);
        };
    }


}
