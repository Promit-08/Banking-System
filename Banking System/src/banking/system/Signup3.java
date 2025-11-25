package banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.security.MessageDigest;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

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

    Signup3(String formno) {
        this.formno = formno;

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setTitle("BANK ACCOUNT REGISTRATION FORM - PAGE 3");

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(280, 40, 400, 40);
        add(accountDetails);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Salary Account");
        r4 = new JRadioButton("Student Account");
        JRadioButton[] buttons = { r1, r2, r3, r4 };
        int y = 180;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(new Font("Raleway", Font.BOLD, 16));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setBounds(100 + (i % 2) * 250, y, 250, 20);
            if (i % 2 == 1) y += 40;
            add(buttons[i]);
        }

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 280, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 280, 300, 30);
        add(number);

        JLabel carddetails = new JLabel("Your 16 digit card number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 310, 300, 20);
        add(carddetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 350, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 350, 300, 30);
        add(pnumber);

        JLabel pindetails = new JLabel("Your 4 digit password");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 380, 300, 20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 430, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");
        JCheckBox[] checks = { c1, c2, c3, c4, c5, c6 };
        y = 480;
        for (int i = 0; i < checks.length; i++) {
            checks[i].setBackground(Color.WHITE);
            checks[i].setFont(new Font("Raleway", Font.BOLD, 16));
            checks[i].setBounds(100 + (i % 2) * 250, y, 200, 30);
            if (i % 2 == 1) y += 50;
            add(checks[i]);
        }

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 620, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 650, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 650, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Savings Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Salary Account";
            } else if (r4.isSelected()) {
                accountType = "Student Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 8833507000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String hashedPin = hashPIN(pinnumber);

            StringBuilder facility = new StringBuilder();
            if (c1.isSelected()) facility.append(" ATM CARD");
            if (c2.isSelected()) facility.append(" Internet Banking");
            if (c3.isSelected()) facility.append(" Mobile Banking");
            if (c4.isSelected()) facility.append(" EMAIL & SMS Alerts");
            if (c5.isSelected()) facility.append(" Cheque Book");
            if (c6.isSelected()) facility.append(" E-Statement");

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Please select account type");
                    return;
                }
                if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please confirm the declaration");
                    return;
                }

                conn c = new conn();
                String query1 = "insert into Signup3 (formno, accountType, cardnumber, pinnumber, facility, balance) " +
                        "VALUES ('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + hashedPin + "', '" + facility + "', 0.00)";
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);

                setVisible(false);
                new Login().setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Signup3("");
    }
}
