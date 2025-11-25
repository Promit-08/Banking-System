package banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.security.MessageDigest;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public static String hashPIN(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Login() {

        setTitle("Dream Banking System");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(130, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to Dream Bank");
        text.setFont(new Font("Osward", Font.BOLD, 32));
        text.setBounds(250, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 30));
        cardno.setBounds(120, 144, 150, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 32));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            String cardNumber = cardTextField.getText();
            String pinNumber = String.valueOf(pinTextField.getPassword());
            String hashedPin = hashPIN(pinNumber);

            try {
                conn c = new conn();
                String query = "SELECT * FROM Signup3 WHERE cardnumber = '" + cardNumber + "' AND pinnumber = '" + hashedPin + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Dashboard(cardNumber, hashedPin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
