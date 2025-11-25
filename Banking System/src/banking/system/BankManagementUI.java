package banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankManagementUI extends JFrame implements ActionListener {
    
    JButton viewAccounts, addAccount, deleteAccount, transactions, exit;

    public BankManagementUI() {
        setTitle("Bank Management System");
        setSize(500, 400);
        setLocation(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Bank Management Dashboard");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(100, 30, 300, 30);
        add(heading);

        viewAccounts = new JButton("View Accounts");
        viewAccounts.setBounds(150, 80, 200, 30);
        viewAccounts.addActionListener(this);
        add(viewAccounts);

        addAccount = new JButton("Add New Account");
        addAccount.setBounds(150, 120, 200, 30);
        addAccount.addActionListener(this);
        add(addAccount);

        deleteAccount = new JButton("Delete Account");
        deleteAccount.setBounds(150, 160, 200, 30);
        deleteAccount.addActionListener(this);
        add(deleteAccount);

        transactions = new JButton("View Transactions");
        transactions.setBounds(150, 200, 200, 30);
        transactions.addActionListener(this);
        add(transactions);

        exit = new JButton("Exit");
        exit.setBounds(150, 240, 200, 30);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAccounts) {
            JOptionPane.showMessageDialog(null, "Showing account list...");
            // new ViewAccounts().setVisible(true); // link to another frame
        } else if (e.getSource() == addAccount) {
            new Signup3("1234"); // call the signup form you created
        } else if (e.getSource() == deleteAccount) {
            JOptionPane.showMessageDialog(null, "Delete account option selected.");
            // new DeleteAccount().setVisible(true);
        } else if (e.getSource() == transactions) {
            JOptionPane.showMessageDialog(null, "Transaction history window.");
            // new ViewTransactions().setVisible(true);
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new BankManagementUI();
    }
}
