import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	Admin a = new Admin();
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("User Name");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(10, 11, 108, 23);
		contentPane.add(label);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(10, 39, 201, 35);
		contentPane.add(username);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(244, 11, 108, 23);
		contentPane.add(label_1);
		
		password = new JPasswordField();
		password.setBounds(241, 39, 201, 35);
		contentPane.add(password);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		lblName.setBounds(213, 102, 108, 23);
		contentPane.add(lblName);
		
		JLabel lblUserTyoe = new JLabel("User Type");
		lblUserTyoe.setFont(new Font("Arial", Font.BOLD, 15));
		lblUserTyoe.setBounds(190, 208, 108, 23);
		contentPane.add(lblUserTyoe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(175, 238, 238));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"patient", "dentist"}));
		comboBox.setBounds(134, 243, 201, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(username.getText().length()!=0 && name.getText().length()!=0 && password.getText().length()!=0) {
					try {
						boolean add = a.addUser(name.getText(), username.getText(), password.getText(), comboBox.getSelectedItem().toString());
						if(add) {
							JOptionPane.showMessageDialog(null, "Success , register to systems! You can save on login page !");
							name.setText(null);
							username.setText(null);
							password.setText(null);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Please fill up all fields!");
				}
			}
		});
		btnNewButton.setBounds(134, 345, 201, 35);
		contentPane.add(btnNewButton);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.setBackground(new Color(233, 150, 122));
		btnBackToLogin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnBackToLogin.setBounds(134, 409, 201, 35);
		contentPane.add(btnBackToLogin);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(134, 136, 201, 35);
		contentPane.add(name);
	}
}
