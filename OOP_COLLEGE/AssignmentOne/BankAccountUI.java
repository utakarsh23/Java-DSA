package AssignmentOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccountUI extends JFrame {
    private BankAccount account;

    // UI Components
    private JTextField nameField, balanceField;
    private JPasswordField passField;
    private JButton createBtn, depositBtn, withdrawBtn, checkBtn, exitButton;
    private JTextArea outputArea;

    public BankAccountUI() {
        setTitle("Bank Account Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(110, 20, 180, 25);
        add(nameField);

        JLabel balanceLabel = new JLabel("Initial Balance:");
        balanceLabel.setBounds(20, 55, 100, 25);
        add(balanceLabel);

        balanceField = new JTextField();
        balanceField.setBounds(110, 55, 180, 25);
        add(balanceField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 90, 80, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(110, 90, 180, 25);
        add(passField);

        createBtn = new JButton("Create Account");
        createBtn.setBounds(20, 130, 150, 30);
        add(createBtn);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(20, 180, 100, 30);
        depositBtn.setEnabled(false);
        add(depositBtn);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(130, 180, 100, 30);
        withdrawBtn.setEnabled(false);
        add(withdrawBtn);

        checkBtn = new JButton("Check Balance");
        checkBtn.setBounds(240, 180, 140, 30);
        checkBtn.setEnabled(false);
        add(checkBtn);

        outputArea = new JTextArea();
        outputArea.setBounds(20, 230, 360, 70);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        add(outputArea);


        exitButton = new JButton("Exit Session");
        exitButton.setBounds(130, 200, 100, 30);
        exitButton.setEnabled(false);
        add(exitButton);

        // Button actions
        createBtn.addActionListener(e -> handleCreateAccount());
        depositBtn.addActionListener(e -> handleDeposit());
        withdrawBtn.addActionListener(e -> handleWithdraw());
        checkBtn.addActionListener(e -> handleCheckBalance());
        exitButton.addActionListener(e -> handleExit());
    }

    private void handleCreateAccount() {
        String name = nameField.getText().trim();
        String balanceText = balanceField.getText().trim();
        String passText = new String(passField.getPassword()).trim();

        if (name.isEmpty() || balanceText.isEmpty() || passText.isEmpty()) {
            outputArea.setText("Please fill out all fields to create an account.");
            return;
        }
        long balance;
        int pass;
        try {
            balance = Long.parseLong(balanceText);
            pass = Integer.parseInt(passText);
        } catch (NumberFormatException ex) {
            outputArea.setText("Invalid input: Balance and password must be numbers.");
            return;
        }

        account = new BankAccount(balance, name, pass);
        outputArea.setText("Account created for " + name + ".\nYou can now deposit, withdraw, or check balance.");
        depositBtn.setEnabled(true);
        withdrawBtn.setEnabled(true);
        checkBtn.setEnabled(true);

        // Disable account creation fields to prevent creating multiple accounts in one session
        nameField.setEnabled(false);
        balanceField.setEnabled(false);
        passField.setEnabled(false);
        createBtn.setEnabled(false);
    }

    private void handleExit() {
        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(e -> handleExit());
    }

    private void handleDeposit() {
        if (account == null) return;

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Amount:"));
        JTextField amountField = new JTextField();
        panel.add(amountField);
        panel.add(new JLabel("Password:"));
        JPasswordField passInput = new JPasswordField();
        panel.add(passInput);

        int result = JOptionPane.showConfirmDialog(this, panel, "Deposit Money", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String amountText = amountField.getText().trim();
            String passText = new String(passInput.getPassword()).trim();

            if (amountText.isEmpty() || passText.isEmpty()) {
                outputArea.setText("Amount and password required for deposit.");
                return;
            }

            int amount;
            short enteredPass;
            try {
                amount = Integer.parseInt(amountText);
                enteredPass = Short.parseShort(passText);
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input: Amount and password must be numbers.");
                return;
            }

            if (account.getPass() != enteredPass) {
                outputArea.setText("Wrong password. Deposit failed.");
                return;
            }
            account.currentBalance += amount;
            outputArea.setText("Deposited " + amount + ".\nCurrent Balance: " + account.currentBalance);
        }
    }

    private void handleWithdraw() {
        if (account == null) return;

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Amount:"));
        JTextField amountField = new JTextField();
        panel.add(amountField);
        panel.add(new JLabel("Password:"));
        JPasswordField passInput = new JPasswordField();
        panel.add(passInput);

        int result = JOptionPane.showConfirmDialog(this, panel, "Withdraw Money", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String amountText = amountField.getText().trim();
            String passText = new String(passInput.getPassword()).trim();

            if (amountText.isEmpty() || passText.isEmpty()) {
                outputArea.setText("Amount and password required for withdrawal.");
                return;
            }

            int amount;
            short enteredPass;
            try {
                amount = Integer.parseInt(amountText);
                enteredPass = Short.parseShort(passText);
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input: Amount and password must be numbers.");
                return;
            }

            if (account.getPass() != enteredPass) {
                outputArea.setText("Wrong password. Withdrawal failed.");
                return;
            }
            if (account.currentBalance < amount) {
                outputArea.setText("Insufficient funds for withdrawal.");
                return;
            }
            account.currentBalance -= amount;
            outputArea.setText("Withdrew " + amount + ".\nCurrent Balance: " + account.currentBalance);
        }
    }

    private void handleCheckBalance() {
        if (account == null) return;
        outputArea.setText("Current Balance: " + account.currentBalance);
    }

    // --- Helper: Expose password for validation (not recommended for real apps) ---
    static class BankAccount {
        public long currentBalance;
        public String ownerName;
        static String Bank = "ABX";
        private int pass;

        public BankAccount(long currentBalance, String ownerName, int pass) {
            this.currentBalance = currentBalance;
            this.ownerName = ownerName;
            this.pass = pass;
        }

        public int getPass() {
            return pass;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankAccountUI ui = new BankAccountUI();
            ui.setVisible(true);
        });
    }
}