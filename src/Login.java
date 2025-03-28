package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setSize(400, 250);
        setLocation(500, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());

            // Validate the user against a simple condition
            boolean validUser = validateUser(username, password);

            // If the user is valid, insert data into the "login" table
            if (validUser) {
                try (Conn c = new Conn()) {
                    c.insertData(username, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new Project();
                JOptionPane.showMessageDialog(null, "User logged in successfully and data inserted into login table.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    // Simple validation logic (replace with actual authentication logic)
    private boolean validateUser(String username, String password) {
        return username.equals("admin") && password.equals("12345");
    }

    public static void main(String args[]) {
        new Login();
    }
}
