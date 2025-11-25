package banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.security.MessageDigest;

public class Dashboard extends JFrame implements ActionListener {

    String cardNumber, pinNumber;
    JButton balance, deposit, withdraw, logout, profile;

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

    Dashboard(String cardNumber, String pinNumber) {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;

        setTitle("User Dashboard");
        setSize(600, 400);
        setLocation(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel welcome = new JLabel("Welcome to Your Account");
        welcome.setFont(new Font("Arial", Font.BOLD, 22));
        welcome.setBounds(150, 30, 300, 30);
        add(welcome);

        JLabel cardLabel = new JLabel("Card No: " + cardNumber);
        cardLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cardLabel.setBounds(180, 70, 300, 20);
        add(cardLabel);

        ImageIcon profileIcon = new ImageIcon(ClassLoader.getSystemResource("icon/profile icon.jpg"));
        Image image = profileIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(image);

        profile = new JButton(profileIcon);
        profile.setBounds(540, 20, 40, 40);
        profile.setContentAreaFilled(false);
        profile.setFocusPainted(false);
        profile.setToolTipText("Profile");
        profile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        profile.addActionListener(this);
        add(profile);

        balance = new JButton("Check Balance");
        balance.setBounds(200, 120, 180, 30);
        balance.addActionListener(this);
        add(balance);

        deposit = new JButton("Deposit");
        deposit.setBounds(200, 170, 180, 30);
        deposit.addActionListener(this);
        add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(200, 220, 180, 30);
        withdraw.addActionListener(this);
        add(withdraw);

        logout = new JButton("Logout");
        logout.setBounds(200, 270, 180, 30);
        logout.addActionListener(this);
        add(logout);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == balance) {
            try {
                conn c = new conn();
                String query = "SELECT balance FROM Signup3 WHERE cardnumber = '" + cardNumber + "' AND pinnumber = '" + pinNumber + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    String balanceValue = rs.getString("balance");
                    JOptionPane.showMessageDialog(null, "Your balance is: BDT." + balanceValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found or incorrect PIN.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fetching balance.");
            }
        } else if (e.getSource() == deposit) {
            String enteredPin = JOptionPane.showInputDialog("Enter your PIN to confirm:");
            if (!pinNumber.equals(hashPIN(enteredPin))) {
                JOptionPane.showMessageDialog(null, "Incorrect PIN. Deposit cancelled.");
                return;
            }

            String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
            try {
                double amount = Double.parseDouble(amountStr);
                if (amount <= 0) throw new NumberFormatException();

                conn c = new conn();
                String query = "UPDATE Signup3 SET balance = balance + " + amount +
                        " WHERE cardnumber = '" + cardNumber + "' AND pinnumber = '" + pinNumber + "'";
                int result = c.s.executeUpdate(query);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "BDT." + amount + " deposited successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Deposit failed. Account not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error during deposit.");
            }
        } else if (e.getSource() == withdraw) {
            String enteredPin = JOptionPane.showInputDialog("Enter your PIN to confirm:");
            if (!pinNumber.equals(hashPIN(enteredPin))) {
                JOptionPane.showMessageDialog(null, "Incorrect PIN. Withdrawal cancelled.");
                return;
            }

            String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
            try {
                double amount = Double.parseDouble(amountStr);
                if (amount <= 0) throw new NumberFormatException();

                conn c = new conn();
                String balanceQuery = "SELECT balance FROM Signup3 WHERE cardnumber = '" + cardNumber + "' AND pinnumber = '" + pinNumber + "'";
                ResultSet rs = c.s.executeQuery(balanceQuery);
                if (rs.next()) {
                    double currentBalance = rs.getDouble("balance");
                    if (currentBalance >= amount) {
                        String updateQuery = "UPDATE Signup3 SET balance = balance - " + amount +
                                " WHERE cardnumber = '" + cardNumber + "' AND pinnumber = '" + pinNumber + "'";
                        c.s.executeUpdate(updateQuery);
                        JOptionPane.showMessageDialog(null, "BDT." + amount + " withdrawn successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient balance.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error during withdrawal.");
            }
        } else if (e.getSource() == logout) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (e.getSource() == profile) {
            String userName = "User";

            try {
                conn c = new conn();

                String getFormQuery = "SELECT formno FROM Signup3 WHERE cardnumber = '" + cardNumber + "'";
                ResultSet rsForm = c.s.executeQuery(getFormQuery);

                if (rsForm.next()) {
                    String formno = rsForm.getString("formno");

                    String getNameQuery = "SELECT name FROM Signup1 WHERE formno = '" + formno + "'";
                    ResultSet rsName = c.s.executeQuery(getNameQuery);

                    if (rsName.next()) {
                        userName = rsName.getString("name");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel infoLabel = new JLabel("<html><b>Profile Details:</b><br/>Name: " + userName + "<br/>Card Number: " + cardNumber + "</html>");
            infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton changePinBtn = new JButton("Change PIN");
            changePinBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

            panel.add(infoLabel);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(changePinBtn);

            JDialog profileDialog = new JDialog(this, "Profile", true);
            profileDialog.setSize(300, 150);
            profileDialog.setLocationRelativeTo(this);
            profileDialog.setLayout(new BorderLayout());
            profileDialog.add(panel, BorderLayout.CENTER);

            changePinBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    profileDialog.dispose();

                    String currentPin = JOptionPane.showInputDialog(null, "Enter current PIN:");
                    if (currentPin == null || !pinNumber.equals(hashPIN(currentPin))) {
                        JOptionPane.showMessageDialog(null, "Incorrect current PIN.");
                        return;
                    }

                    String newPin = JOptionPane.showInputDialog(null, "Enter new PIN:");
                    if (newPin == null || newPin.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "New PIN cannot be empty.");
                        return;
                    }

                    String confirmPin = JOptionPane.showInputDialog(null, "Confirm new PIN:");
                    if (!newPin.equals(confirmPin)) {
                        JOptionPane.showMessageDialog(null, "PINs do not match.");
                        return;
                    }

                    try {
                        conn c = new conn();
                        String hashedNewPin = hashPIN(newPin);
                        String updateQuery = "UPDATE Signup3 SET pinnumber = '" + hashedNewPin + "' WHERE cardnumber = '" + cardNumber + "'";
                        int rows = c.s.executeUpdate(updateQuery);
                        if (rows > 0) {
                            pinNumber = hashedNewPin;
                            JOptionPane.showMessageDialog(null, "PIN changed successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update PIN.");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error updating PIN.");
                    }
                }
            });

            profileDialog.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dashboard("cardNumber", "hashedPin");
    }
}
