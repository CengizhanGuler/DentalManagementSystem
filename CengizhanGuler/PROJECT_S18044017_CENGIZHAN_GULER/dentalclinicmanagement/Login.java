import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;


public class Login extends JFrame {
	Conn conn = new Conn();
	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pass;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Dental Clinic Management System");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(176, 59, 442, 56);
		contentPane.add(lblNewLabel);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(255, 69, 0));
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUserName.setBounds(218, 160, 108, 23);
		contentPane.add(lblUserName);

		uname = new JTextField();
		uname.setBounds(155, 188, 201, 35);
		contentPane.add(uname);
		uname.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 69, 0));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(446, 160, 108, 23);
		contentPane.add(lblPassword);

		JButton login_btn = new JButton("Login");
		login_btn.setBackground(new Color(152, 251, 152));
		login_btn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uname.getText().length() == 0 && pass.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				} else {

					try {
						Connection con = conn.connDb();
						Statement stmt = con.createStatement();
					//Selects all tuples in the user table.
						ResultSet rs = stmt.executeQuery("SELECT * FROM user;");
						int key = 0;
						while (rs.next()) {
							if (uname.getText().equals(rs.getString("username"))
									&& pass.getText().equals(rs.getString("password"))) {

								key = 1;
								if (rs.getString("type").equals("admin")) {
									Admin a = new Admin(rs.getInt("id"),rs.getString("name"),rs.getString("username"),rs.getString("password"),"admin");
									AdminGUI admin = new AdminGUI(a);
									admin.setVisible(true);
									dispose();
								}
								else if(rs.getString("type").equals("dentist")) {
									 Dentist d = new Dentist (rs.getInt("id"),rs.getString("name"),rs.getString("username"),rs.getString("password"),"dentist");
									 DentistGUI dentist = new DentistGUI(d);
					            	 dentist.setVisible(true);
					            	 dispose();
								}
								else if(rs.getString("type").equals("patient")) {
									Patient p = new Patient (rs.getInt("id"),rs.getString("name"),rs.getString("username"),rs.getString("password"),"patient");
									PatientGUI patient = new PatientGUI(p);
									patient.setVisible(true);
									dispose();
								}
							}

						}
						if (key != 1)
							JOptionPane.showMessageDialog(null, "Error! No such user found! Try Again");

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				}
			}
		});
		login_btn.setBounds(284, 260, 201, 60);
		contentPane.add(login_btn);
		pass = new JPasswordField();
		pass.setBounds(377, 188, 201, 35);
		contentPane.add(pass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 248, 220));
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register reg = new Register();
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(284, 348, 201, 60);
		contentPane.add(btnRegister);
	}
}
