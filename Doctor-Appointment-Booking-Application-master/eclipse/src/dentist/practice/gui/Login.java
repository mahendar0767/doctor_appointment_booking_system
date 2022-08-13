package dentist.practice.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class Login {

    private JFrame frame;
    private JTextField textUsername;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setForeground(Color.WHITE);
        
        // Set JFrame Properties
        frame.setTitle("Sheffield Dental Care"); // Set Title
        frame.setBackground(new Color(197, 216, 236)); // Set Color       
        frame.setSize(600, 400);
        
        // instance fields
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Set JFrame Size & Position
        Dimension screenDimensions = toolkit.getScreenSize();
        frame.setResizable(true);
        frame.setLocation(new Point(screenDimensions.width / 3, screenDimensions.height / 3));          
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.GREEN);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLogin.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                String username = textUsername.getText();
                String pass = passwordField.getText();
                if(textUsername.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    passwordField.setText(null);
                    textUsername.setText(null);
                    JOptionPane.showMessageDialog(null, "Please Enter Username and Password","Login Error",JOptionPane.ERROR_MESSAGE);
                } else if (username.contains("admin") && pass.contains("1234")) {
                    passwordField.setText(null);
                    textUsername.setText(null);
                    Admin admin = new Admin();
                    admin.setVisible(true);
                    frame.dispose();
                } else if (username.contains("dentist") && pass.contains("1234")) {
                    passwordField.setText(null);
                    textUsername.setText(null);
                    Dentist dentist = new Dentist();
                    dentist.setVisible(true);
                    frame.dispose();
                } else if (username.contains("hyg") && pass.contains("1234")) {
                    passwordField.setText(null);
                    textUsername.setText(null);
                    Hygienist hygienist = new Hygienist();
                    hygienist.setVisible(true);
                    frame.dispose();
                } else {
                    passwordField.setText(null);
                    textUsername.setText(null);
                    JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setBounds(96, 257, 167, 50);
        frame.getContentPane().add(btnLogin);
        
        JButton btnReset = new JButton("Reset");
        btnReset.setBackground(Color.PINK);
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textUsername.setText(null);
                passwordField.setText(null);
            }
        });
        btnReset.setBounds(315, 257, 167, 50);
        frame.getContentPane().add(btnReset);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblUsername.setBounds(71, 99, 148, 30);
        frame.getContentPane().add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblPassword.setBounds(71, 160, 148, 30);
        frame.getContentPane().add(lblPassword);
        
        textUsername = new JTextField();
        textUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textUsername.setBounds(231, 97, 222, 38);
        frame.getContentPane().add(textUsername);
        textUsername.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        passwordField.setBounds(231, 158, 222, 38);
        frame.getContentPane().add(passwordField);
        
        JSeparator separator1 = new JSeparator();
        separator1.setBounds(58, 217, 473, 12);
        frame.getContentPane().add(separator1);
        
        JSeparator separator2 = new JSeparator();
        separator2.setBounds(58, 73, 473, 12);
        frame.getContentPane().add(separator2);
        
        JLabel lblTitle = new JLabel("Sheffield Dental Care Management System");
        lblTitle.setFont(new Font("Tekton Pro", Font.BOLD, 26));
        lblTitle.setBounds(58, 27, 473, 33);
        frame.getContentPane().add(lblTitle);
        
        JCheckBox chckbxShowPass = new JCheckBox("Show");
        chckbxShowPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(chckbxShowPass.isSelected()){
                    passwordField.setEchoChar((char)0);
                }else{
                    passwordField.setEchoChar('●');
                }
            }
        });
        chckbxShowPass.setBackground(Color.LIGHT_GRAY);
        chckbxShowPass.setBounds(461, 168, 70, 25);
        frame.getContentPane().add(chckbxShowPass);
    }
}
