import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.SQLException;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;


public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JTable dentistList;
	Dentist d = new Dentist();
	static Admin a = new Admin();
	Clinic h = new Clinic();
	DentistWork w = new DentistWork();
	Appointment app = new Appointment();
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField deleteID;
	private JTable clinicList;
	private JTable dentists;
	private JTextField dentistID;
	private JTextField appID;
	private JTable appDentist;
	private JTable appList;
	private JTextField upID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public AdminGUI(Admin a) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Dentist Table Model Start
		DefaultTableModel DentistModel = new DefaultTableModel();
		Object[] columnName = new Object[4];
		columnName[0] = "ID";
		columnName[1] = "Dentist Name";
		columnName[2] = "User Name";
		columnName[3] = "Password";
		DentistModel.setColumnIdentifiers(columnName);
		Object[] dentistData = new Object[4];
		for (int i = 0; i < d.getList().size(); i++) {
			dentistData[0] = d.getList().get(i).getId();
			dentistData[1] = d.getList().get(i).getName();
			dentistData[2] = d.getList().get(i).getUserName();
			dentistData[3] = d.getList().get(i).getPassword();
			DentistModel.addRow(dentistData);
		}
		// Dentist Table Model End
		// Clinic Table Model Start
		DefaultTableModel clinicModel = new DefaultTableModel();
		Object[] columnClinicName = new Object[4];
		columnClinicName[0] = "ID";
		columnClinicName[1] = "Clinic Name";
		columnClinicName[2] = "Address";
		columnClinicName[3] = "Phone";
		clinicModel.setColumnIdentifiers(columnClinicName);
		Object[] ClinicData = new Object[4];
		for (int i = 0; i < h.getList().size(); i++) {
			ClinicData[0] = h.getList().get(i).getId();
			ClinicData[1] = h.getList().get(i).getName();
			ClinicData[2] = h.getList().get(i).getAdress();
			ClinicData[3] = h.getList().get(i).getPhone();
			clinicModel.addRow(ClinicData);
		}
		// Clinic Table Model End

		// Date Table Model Start
		DefaultTableModel dateModel = new DefaultTableModel();
		Object[] columnDateName = new Object[2];
		columnDateName[0] = "Dentist ID";
		columnDateName[1] = "Dentist Name";
		dateModel.setColumnIdentifiers(columnDateName);
		Object[] data = new Object[3];

		// Date Table Model End

		// App Dentist Table Model Start
		DefaultTableModel appDentistModel = new DefaultTableModel();
		Object[] columnDentistName = new Object[2];
		columnDentistName[0] = "ID";
		columnDentistName[1] = "Dentist Name";
		appDentistModel.setColumnIdentifiers(columnDentistName);
		Object[] appDentistData = new Object[2];
		for (int i = 0; i < d.getList().size(); i++) {
			appDentistData[0] = d.getList().get(i).getId();
			appDentistData[1] = d.getList().get(i).getName();
			appDentistModel.addRow(appDentistData);
		}
		// App Dentist Table Model End

		// App Table Model Start
		DefaultTableModel appModel = new DefaultTableModel();
		Object[] columnAppName = new Object[3];
		columnAppName[0] = "ID";
		columnAppName[1] = "Patient Name";
		columnAppName[2] = "Date";
		appModel.setColumnIdentifiers(columnAppName);
		Object[] appData = new Object[3];
		// App Table Model End

		JLabel lblWelcomeAdminPanel = new JLabel("Admin Panel");
		lblWelcomeAdminPanel.setForeground(new Color(95, 158, 160));
		lblWelcomeAdminPanel.setBounds(330, 29, 222, 23);
		lblWelcomeAdminPanel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		contentPane.add(lblWelcomeAdminPanel);

		JLabel label_1 = new JLabel(a.getName());
		label_1.setBounds(10, 0, 222, 23);
		label_1.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(label_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 63, 834, 498);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		tabbedPane.addTab("Dentists", null, panel, null);
		panel.setLayout(null);

		dentistList = new JTable();
		dentistList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = dentistList.getSelectedRow();
				upID.setText(dentistList.getModel().getValueAt(row, 0).toString());
				username.setText(dentistList.getModel().getValueAt(row, 2).toString());
				name.setText(dentistList.getModel().getValueAt(row, 1).toString());
				password.setText(dentistList.getModel().getValueAt(row, 3).toString());
			}
		});
		dentistList.setBounds(10, 59, 538, 400);
		dentistList.setModel(DentistModel);
		panel.add(dentistList);

		JScrollPane scrollPane = new JScrollPane(dentistList);
		scrollPane.setBounds(10, 59, 504, 400);
		panel.add(scrollPane);

		JLabel lblDentistList = new JLabel("Dentist List");
		lblDentistList.setForeground(new Color(0, 255, 255));
		lblDentistList.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDentistList.setBounds(10, 27, 168, 22);
		panel.add(lblDentistList);

		JLabel lblDentistName = new JLabel("Dentist Name");
		lblDentistName.setForeground(new Color(224, 255, 255));
		lblDentistName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDentistName.setBounds(524, 54, 168, 22);
		panel.add(lblDentistName);

		name = new JTextField();
		name.setBounds(524, 89, 137, 29);
		panel.add(name);
		name.setColumns(10);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(224, 255, 255));
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblUserName.setBounds(670, 55, 149, 22);
		panel.add(lblUserName);

		username = new JTextField();
		username.setColumns(10);
		username.setBounds(671, 89, 137, 29);
		panel.add(username);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(524, 175, 137, 29);
		panel.add(password);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(224, 255, 255));
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassword.setBounds(524, 142, 168, 22);
		panel.add(lblPassword);

		JButton btnNewButton = new JButton("Add Dentist");
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().length() != 0 && username.getText().length() != 0
						&& password.getText().length() != 0) {
					try {
						boolean control = a.addDentist(name.getText(), username.getText(), password.getText());
						if (control) {
							JOptionPane.showMessageDialog(null, "Success ! You added dentist");
							String t = null;
							name.setText(t);
							username.setText(t);
							password.setText(t);
							DefaultTableModel clearModel = (DefaultTableModel) dentistList.getModel();
							clearModel.setRowCount(0);
							for (int i = 0; i < d.getList().size(); i++) {
								dentistData[0] = d.getList().get(i).getId();
								dentistData[1] = d.getList().get(i).getName();
								dentistData[2] = d.getList().get(i).getUserName();
								dentistData[3] = d.getList().get(i).getPassword();
								DentistModel.addRow(dentistData);
							}
							dentistList.setModel(DentistModel);
						} else {
							JOptionPane.showMessageDialog(null, "Error! ");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
			}
		});
		btnNewButton.setBounds(616, 215, 137, 29);
		panel.add(btnNewButton);

		deleteID = new JTextField();
		deleteID.setColumns(10);
		deleteID.setBounds(616, 342, 137, 29);
		panel.add(deleteID);

		JLabel lblDentistId = new JLabel("Dentist ID");
		lblDentistId.setForeground(new Color(224, 255, 255));
		lblDentistId.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDentistId.setBounds(616, 309, 168, 22);
		panel.add(lblDentistId);

		JButton btnDeleteDentist = new JButton("Delete Dentist");
		btnDeleteDentist.setBackground(new Color(255, 218, 185));
		btnDeleteDentist.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDeleteDentist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deleteID.getText().length() != 0) {
					try {
						boolean control = a.deleteDentist(Integer.parseInt(deleteID.getText()));
						if (control) {
							JOptionPane.showMessageDialog(null, "Success ! You deleted dentist");
							String t = null;
							name.setText(t);
							username.setText(t);
							password.setText(t);
							DefaultTableModel clearModel = (DefaultTableModel) dentistList.getModel();
							clearModel.setRowCount(0);
							for (int i = 0; i < d.getList().size(); i++) {
								dentistData[0] = d.getList().get(i).getId();
								dentistData[1] = d.getList().get(i).getName();
								dentistData[2] = d.getList().get(i).getUserName();
								dentistData[3] = d.getList().get(i).getPassword();
								DentistModel.addRow(dentistData);
							}
							dentistList.setModel(DentistModel);
						} else {
							JOptionPane.showMessageDialog(null, "Error! ");
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
			}
		});
		btnDeleteDentist.setBounds(616, 380, 137, 29);
		panel.add(btnDeleteDentist);
		
		upID = new JTextField();
		upID.setColumns(10);
		upID.setBounds(671, 175, 137, 29);
		panel.add(upID);
		
		JLabel lblDentistId_1 = new JLabel("Dentist ID");
		lblDentistId_1.setForeground(new Color(224, 255, 255));
		lblDentistId_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDentistId_1.setBounds(671, 142, 168, 22);
		panel.add(lblDentistId_1);
		
		JButton btnUpdateDentist = new JButton("Update Dentist");
		btnUpdateDentist.setBackground(new Color(250, 235, 215));
		btnUpdateDentist.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnUpdateDentist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (upID.getText().length() != 0) {
					try {
						boolean control = d.updateDentist(Integer.parseInt(upID.getText()),name.getText(), username.getText(), password.getText());
						if (control) {
							JOptionPane.showMessageDialog(null, "Success ! You update dentist");
							String t = null;
							name.setText(t);
							username.setText(t);
							password.setText(t);
							upID.setText(t);
							DefaultTableModel clearModel = (DefaultTableModel) dentistList.getModel();
							clearModel.setRowCount(0);
							for (int i = 0; i < d.getList().size(); i++) {
								dentistData[0] = d.getList().get(i).getId();
								dentistData[1] = d.getList().get(i).getName();
								dentistData[2] = d.getList().get(i).getUserName();
								dentistData[3] = d.getList().get(i).getPassword();
								DentistModel.addRow(dentistData);
							}
							dentistList.setModel(DentistModel);
						} else {
							JOptionPane.showMessageDialog(null, "Error! ");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
			}
		});
		btnUpdateDentist.setBounds(616, 255, 137, 29);
		panel.add(btnUpdateDentist);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 139, 87));
		tabbedPane.addTab("Clinics", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblClinicList = new JLabel("Clinic List");
		lblClinicList.setForeground(new Color(0, 255, 255));
		lblClinicList.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblClinicList.setBounds(10, 17, 112, 22);
		panel_1.add(lblClinicList);

		clinicList = new JTable();
		clinicList.setBounds(0, 44, 352, 426);
		clinicList.setModel(clinicModel);
		panel_1.add(clinicList);

		
		JScrollPane scrollPane_1 = new JScrollPane(clinicList);
		scrollPane_1.setBounds(0, 44, 452, 426);
		panel_1.add(scrollPane_1);

		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.setBackground(new Color(250, 240, 230));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = clinicList.getSelectedRow();
				if (row >= 0) {
					String value = clinicList.getModel().getValueAt(row, 0).toString();
					DefaultTableModel clearModel = (DefaultTableModel) dentists.getModel();
					int id = Integer.parseInt(value);
					clearModel.setRowCount(0);
					try {
						for (int i = 0; i < d.getDentistList(id).size(); i++) {
							data[0] = d.getDentistList(id).get(i).getId();
							data[1] = d.getDentistList(id).get(i).getName();
							dateModel.addRow(data);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dentists.setModel(dateModel);
				} else {
					JOptionPane.showMessageDialog(null, "Error! Please select dentist in list!");
				}

			}
		});
		btnNewButton_1.setBounds(462, 144, 89, 23);
		panel_1.add(btnNewButton_1);

		JLabel lblSelectClinic = new JLabel("Select Clinic");
		lblSelectClinic.setForeground(new Color(224, 255, 255));
		lblSelectClinic.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSelectClinic.setBounds(462, 117, 112, 22);
		panel_1.add(lblSelectClinic);

		dentists = new JTable();
		dentists.setBounds(561, 44, 268, 426);
		panel_1.add(dentists);

		JLabel lblDentistList_1 = new JLabel("Dentist List");
		lblDentistList_1.setForeground(new Color(0, 255, 255));
		lblDentistList_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDentistList_1.setBounds(561, 17, 112, 22);
		panel_1.add(lblDentistList_1);

		JScrollPane scrollPane_2 = new JScrollPane(dentists);
		scrollPane_2.setBounds(561, 44, 268, 426);
		panel_1.add(scrollPane_2);

		dentistID = new JTextField();
		dentistID.setBounds(462, 224, 89, 20);
		panel_1.add(dentistID);
		dentistID.setColumns(10);

		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setBackground(new Color(250, 235, 215));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dentistID.getText().length() != 0) {
					int row = clinicList.getSelectedRow();
					if (row >= 0) {
						String clinic_id = clinicList.getModel().getValueAt(row, 0).toString();
						int id = Integer.parseInt(clinic_id);
						try {
							boolean control = d.addClinic(Integer.parseInt(dentistID.getText()),
									Integer.parseInt(clinic_id));
							if (control) {
								JOptionPane.showMessageDialog(null, "Success ! You added dentist");
								DefaultTableModel clearModel = (DefaultTableModel) dentists.getModel();
								clearModel.setRowCount(0);
								try {
									for (int i = 0; i < d.getDentistList(id).size(); i++) {
										data[0] = d.getDentistList(id).get(i).getId();
										data[1] = d.getDentistList(id).get(i).getName();
										dateModel.addRow(data);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								dentists.setModel(dateModel);
								String t = null;
								dentistID.setText(t);
							} else {
								JOptionPane.showMessageDialog(null, "Error ! You don't added dentist");
							}
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Error! Please select a clinic on list!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}

			}
		});
		btnNewButton_2.setBounds(462, 255, 89, 23);
		panel_1.add(btnNewButton_2);

		JLabel lblDelete = new JLabel("Dentist ID");
		lblDelete.setForeground(new Color(224, 255, 255));
		lblDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDelete.setBounds(462, 201, 112, 22);
		panel_1.add(lblDelete);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(250, 235, 215));
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dentistID.getText().length() != 0) {
					int row = clinicList.getSelectedRow();
					if (row >= 0) {
						String clinic_id = clinicList.getModel().getValueAt(row, 0).toString();
						int clinicID = Integer.parseInt(clinic_id);
						boolean control = a.deleteWork(clinicID, Integer.parseInt(dentistID.getText()));
						if (control) {
							JOptionPane.showMessageDialog(null, "Success ! You added dentist");
							DefaultTableModel clearModel = (DefaultTableModel) dentists.getModel();
							clearModel.setRowCount(0);
							try {
								for (int i = 0; i < d.getDentistList(clinicID).size(); i++) {
									data[0] = d.getDentistList(clinicID).get(i).getId();
									data[1] = d.getDentistList(clinicID).get(i).getName();
									dateModel.addRow(data);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							dentists.setModel(dateModel);
							String t = null;
							dentistID.setText(t);
						} else {
							JOptionPane.showMessageDialog(null, "Error ! You don't added dentist");
						}

					}

				} else {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
			}
		});
		btnDelete.setBounds(462, 282, 89, 23);
		panel_1.add(btnDelete);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(46, 139, 87));
		tabbedPane.addTab("Appointments", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblDentistList_2 = new JLabel("Dentist List");
		lblDentistList_2.setForeground(new Color(0, 255, 255));
		lblDentistList_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDentistList_2.setBounds(10, 17, 112, 22);
		panel_2.add(lblDentistList_2);

		appDentist = new JTable();
		appDentist.setBounds(0, 44, 452, 426);
		appDentist.setModel(appDentistModel);
		panel_2.add(appDentist);

		JScrollPane scrollPane_3 = new JScrollPane(appDentist);
		scrollPane_3.setBounds(0, 44, 252, 426);
		panel_2.add(scrollPane_3);

		JButton button_1 = new JButton("Select");
		button_1.setBackground(new Color(250, 235, 215));
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = appDentist.getSelectedRow();
				if (row >= 0) {
					String value = appDentist.getModel().getValueAt(row, 0).toString();
					DefaultTableModel clearModel = (DefaultTableModel) appList.getModel();
					int id = Integer.parseInt(value);
					clearModel.setRowCount(0);
					try {
						for (int i = 0; i < app.getListDentist(id).size(); i++) {
							appData[0] = app.getListDentist(id).get(i).getId();
							appData[1] = app.getListDentist(id).get(i).getDentist_name();
							appData[2] = app.getListDentist(id).get(i).getDate();
							appModel.addRow(appData);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					appList.setModel(appModel);
				} else {
					JOptionPane.showMessageDialog(null, "Error! Please select dentist in list!");
				}

			}
		});
		button_1.setBounds(265, 145, 89, 23);
		panel_2.add(button_1);

		JLabel lblSelectDentist = new JLabel("Select Dentist");
		lblSelectDentist.setForeground(new Color(224, 255, 255));
		lblSelectDentist.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSelectDentist.setBounds(265, 118, 112, 22);
		panel_2.add(lblSelectDentist);

		appID = new JTextField();
		appID.setColumns(10);
		appID.setBounds(265, 225, 89, 20);
		panel_2.add(appID);

		JLabel lblAppointmentId = new JLabel("Appointment ID");
		lblAppointmentId.setForeground(new Color(224, 255, 255));
		lblAppointmentId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAppointmentId.setBounds(265, 202, 112, 22);
		panel_2.add(lblAppointmentId);

		JButton button_3 = new JButton("Delete");
		button_3.setBackground(new Color(250, 235, 215));
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = appDentist.getSelectedRow();
				if (appID.getText().length() != 0 && row >= 0) {
					boolean control = a.deleteApp(Integer.parseInt(appID.getText()));
					if (control) {
						JOptionPane.showMessageDialog(null, "Success ! You deleted Appointments");
						String value = appDentist.getModel().getValueAt(row, 0).toString();
						int id = Integer.parseInt(value);
						DefaultTableModel clearModel = (DefaultTableModel) appList.getModel();
						clearModel.setRowCount(0);
						try {
							for (int i = 0; i < app.getListDentist(id).size(); i++) {
								appData[0] = app.getListDentist(id).get(i).getId();
								appData[1] = app.getListDentist(id).get(i).getDentist_name();
								appData[2] = app.getListDentist(id).get(i).getDate();
								appModel.addRow(appData);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						appList.setModel(appModel);
						String t = null;
						appID.setText(t);
					}
					else {
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
			}
		});
		button_3.setBounds(265, 253, 89, 23);
		panel_2.add(button_3);

		appList = new JTable();
		appList.setBounds(390, 45, 439, 425);
		panel_2.add(appList);

		JScrollPane scrollPane_4 = new JScrollPane(appList);
		scrollPane_4.setBounds(364, 44, 465, 426);
		panel_2.add(scrollPane_4);

		JLabel lblAppointmentList = new JLabel("Appointment List");
		lblAppointmentList.setForeground(new Color(0, 255, 255));
		lblAppointmentList.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAppointmentList.setBounds(364, 17, 174, 22);
		panel_2.add(lblAppointmentList);

		JButton button = new JButton("Logout");
		button.setBackground(new Color(255, 127, 80));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		button.setBounds(712, 11, 112, 44);
		contentPane.add(button);
	}
}
