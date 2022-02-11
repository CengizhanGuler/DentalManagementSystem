import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class DentistGUI extends JFrame {
	static Dentist dentist = new Dentist();
	DentistDate date = new DentistDate();
	Clinic h = new Clinic();
	DentistWork w = new DentistWork();
	Appointment a = new Appointment();
	private JPanel contentPane;
	private JTable dateTable;
	private JTextField deleteID;
	private JTable ourClinic;
	private JTable clinicList;
	private JTextField clinicID;
	private JTable appList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DentistGUI frame = new DentistGUI(dentist);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DentistGUI(Dentist d) throws SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Date Table Model Start
		DefaultTableModel dateModel = new DefaultTableModel();
		Object[] columnName = new Object[4];
		columnName[0] = "ID";
		columnName[1] = "Dentist Name";
		columnName[2] = "Available Date";
		columnName[3] = "Status";
		dateModel.setColumnIdentifiers(columnName);
		Object[] dateData = new Object[4];
		for (int i = 0; i < date.getList(d.getId()).size(); i++) {
			dateData[0] = date.getList(d.getId()).get(i).getId();
			dateData[1] = d.getName();
			dateData[2] = date.getList(d.getId()).get(i).getDate();
			dateData[3] = date.getList(d.getId()).get(i).getStatus();
			dateModel.addRow(dateData);
		}
		// Date Table Model End

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

		// DentistWork Table Model Start
		DefaultTableModel workModel = new DefaultTableModel();
		Object[] columnWorkName = new Object[2];
		columnWorkName[0] = "ID";
		columnWorkName[1] = "Clinic Name";
		workModel.setColumnIdentifiers(columnWorkName);
		Object[] workData = new Object[4];
		for (int i = 0; i < w.getList(d.getId()).size(); i++) {
			workData[0] = w.getList(d.getId()).get(i).getId();
			workData[1] = w.getList(d.getId()).get(i).getClinic_name();
			workModel.addRow(workData);
		}
		// DentistWork Table Model End
		
		// Patient Table Model Start
				DefaultTableModel AppModel = new DefaultTableModel();
				Object[] columnAppName = new Object[3];
				columnAppName[0] = "ID";
				columnAppName[1] = "Patient Name";
				columnAppName[2] = "Date";
				AppModel.setColumnIdentifiers(columnAppName);
				Object[] appData = new Object[3];
				for (int i = 0; i < a.getListDentist(d.getId()).size(); i++) {
					appData[0] = a.getListDentist(d.getId()).get(i).getId();
					appData[1] = a.getListDentist(d.getId()).get(i).getDentist_name();
					appData[2] = a.getListDentist(d.getId()).get(i).getDate();
					AppModel.addRow(appData);
				}
				// Patient Table Model End
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(102, 205, 170));
		tabbedPane.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		tabbedPane.setBounds(0, 45, 834, 516);
		contentPane.add(tabbedPane);

		JPanel clinics = new JPanel();
		clinics.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("Clinics", null, clinics, null);
		clinics.setLayout(null);

		clinicList = new JTable();
		clinicList.setColumnSelectionAllowed(true);
		clinicList.setBounds(413, 94, 406, 377);
		clinicList.setModel(clinicModel);
		clinics.add(clinicList);

		JLabel lblOurClinic = new JLabel("My Clinics");
		lblOurClinic.setForeground(new Color(0, 0, 205));
		lblOurClinic.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblOurClinic.setBounds(10, 60, 222, 23);
		clinics.add(lblOurClinic);

		JLabel lblCanWorkClinics = new JLabel("Can work Clinics List");
		lblCanWorkClinics.setForeground(new Color(0, 0, 255));
		lblCanWorkClinics.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblCanWorkClinics.setBounds(413, 60, 222, 23);
		clinics.add(lblCanWorkClinics);

		clinicID = new JTextField();
		clinicID.setBounds(10, 30, 142, 19);
		clinics.add(clinicID);
		clinicID.setColumns(10);

		ourClinic = new JTable();
		ourClinic.setBounds(10, 94, 385, 377);
		ourClinic.setModel(workModel);
		clinics.add(ourClinic);

		JButton btnNewButton_1 = new JButton("Add Clinic");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clinicID.getText().length() != 0) {
					try {
						boolean control = d.addClinic(d.getId(), Integer.parseInt(clinicID.getText()));
						if (control) {
							JOptionPane.showMessageDialog(null, "Completing add Clinic !");
							DefaultTableModel clearModel = (DefaultTableModel) ourClinic.getModel();
							clearModel.setRowCount(0);
							try {
								for (int i = 0; i < w.getList(d.getId()).size(); i++) {
									workData[0] = w.getList(d.getId()).get(i).getId();
									workData[1] = w.getList(d.getId()).get(i).getClinic_name();
									workModel.addRow(workData);
								}
								String t = null;
								clinicID.setText(t);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							ourClinic.setModel(workModel);

						} else {
							JOptionPane.showMessageDialog(null, "Error! add Clinic !");
						}
					} catch (NumberFormatException | SQLException e) {
						e.printStackTrace();
					}
				}

			}
		});
		btnNewButton_1.setBounds(162, 30, 106, 19);
		clinics.add(btnNewButton_1);

		JButton btnDeleteClinic = new JButton("Delete Clinic");
		btnDeleteClinic.setBackground(new Color(135, 206, 235));
		btnDeleteClinic.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDeleteClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clinicID.getText().length() != 0) {
					boolean controlDelete = w.deleteWork(Integer.parseInt(clinicID.getText()));
					if (controlDelete) {
						JOptionPane.showMessageDialog(null, "Completing delete Clinic !");
						DefaultTableModel clearModel = (DefaultTableModel) ourClinic.getModel();
						clearModel.setRowCount(0);
						try {
							for (int i = 0; i < w.getList(d.getId()).size(); i++) {
								workData[0] = w.getList(d.getId()).get(i).getId();
								workData[1] = w.getList(d.getId()).get(i).getClinic_name();
								workModel.addRow(workData);
							}
							String t = null;
							clinicID.setText(t);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						ourClinic.setModel(workModel);
					} else {
						JOptionPane.showMessageDialog(null, "Error delete Clinic !");

					}
				} else {
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}

			}
		});
		btnDeleteClinic.setBounds(272, 30, 132, 19);
		clinics.add(btnDeleteClinic);

		JScrollPane scrollPane_1 = new JScrollPane(clinicList);
		scrollPane_1.setBounds(413, 94, 406, 377);
		clinics.add(scrollPane_1);

		JLabel lblEnterClinicId = new JLabel("Enter Clinic ID");
		lblEnterClinicId.setForeground(new Color(255, 255, 240));
		lblEnterClinicId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblEnterClinicId.setBounds(10, 11, 168, 22);
		clinics.add(lblEnterClinicId);

		JScrollPane scrollPane_2 = new JScrollPane(ourClinic);
		scrollPane_2.setBounds(10, 94, 385, 377);
		clinics.add(scrollPane_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("My Appointments", null, panel, null);
		panel.setLayout(null);
		
		appList = new JTable();
		appList.setBounds(0, 48, 829, 434);
		appList.setModel(AppModel);
		panel.add(appList);

		JScrollPane scrollPane_3 = new JScrollPane(appList);
		scrollPane_3.setBounds(0, 48, 829, 434);
		panel.add(scrollPane_3);
		
		JLabel lblMyAppointmentsList = new JLabel("My Appointments List");
		lblMyAppointmentsList.setForeground(new Color(0, 0, 205));
		lblMyAppointmentsList.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblMyAppointmentsList.setBounds(10, 15, 191, 22);
		panel.add(lblMyAppointmentsList);
		
				JPanel availableDate = new JPanel();
				availableDate.setBackground(new Color(222, 184, 135));
				tabbedPane.addTab("Available Date", null, availableDate, null);
				availableDate.setLayout(null);
				
						JDateChooser dateChooser = new JDateChooser();
						dateChooser.getCalendarButton().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							}
						});
						dateChooser.setBounds(10, 32, 168, 30);
						availableDate.add(dateChooser);
						dateTable = new JTable();
						dateTable.setRowSelectionAllowed(false);
						dateTable.setBounds(10, 106, 809, 365);
						dateTable.setModel(dateModel);
						availableDate.add(dateTable);
						
								JScrollPane scrollPane = new JScrollPane(dateTable);
								scrollPane.setBounds(10, 106, 809, 365);
								availableDate.add(scrollPane);
								JButton addAvailable_btn = new JButton("Add List");
								addAvailable_btn.setBackground(new Color(175, 238, 238));
								addAvailable_btn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
								addAvailable_btn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										String selectDate = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
										if (selectDate.length() == 0) {
											JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
										} else {
											try {
												boolean control = d.addAvaibleDate(d.getId(), selectDate);
												if (control) {
													JOptionPane.showMessageDialog(null, "Completing add Date !");
													DefaultTableModel clearModel = (DefaultTableModel) dateTable.getModel();
													clearModel.setRowCount(0);
													for (int i = 0; i < date.getList(d.getId()).size(); i++) {
														dateData[0] = date.getList(d.getId()).get(i).getId();
														dateData[1] = d.getName();
														dateData[2] = date.getList(d.getId()).get(i).getDate();
														dateData[3] = date.getList(d.getId()).get(i).getStatus();
														dateModel.addRow(dateData);
													}
													dateTable.setModel(dateModel);
												} else {
													JOptionPane.showMessageDialog(null, "Error !");
												}

											} catch (SQLException e) {
												e.printStackTrace();
											}

										}
									}
								});
								addAvailable_btn.setBounds(216, 32, 156, 30);
								availableDate.add(addAvailable_btn);
								
										JLabel lblAvailableDateList = new JLabel("Available Date List");
										lblAvailableDateList.setForeground(new Color(0, 0, 205));
										lblAvailableDateList.setFont(new Font("Times New Roman", Font.BOLD, 17));
										lblAvailableDateList.setBounds(10, 73, 168, 22);
										availableDate.add(lblAvailableDateList);
										
												deleteID = new JTextField();
												deleteID.setToolTipText("");
												deleteID.setBounds(569, 32, 121, 30);
												availableDate.add(deleteID);
												deleteID.setColumns(10);
												
														JButton deleteDate_btn = new JButton("Delete Date");
														deleteDate_btn.setBackground(new Color(135, 206, 250));
														deleteDate_btn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
														deleteDate_btn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {
																if (deleteID.getText().length() != 0) {
																	boolean controlDelete = date.deleteDate(Integer.parseInt(deleteID.getText()));
																	if (controlDelete) {
																		JOptionPane.showMessageDialog(null, "Completing delete Date !");
																		DefaultTableModel clearModel = (DefaultTableModel) dateTable.getModel();
																		clearModel.setRowCount(0);
																		try {
																			for (int i = 0; i < date.getList(d.getId()).size(); i++) {
																				dateData[0] = date.getList(d.getId()).get(i).getId();
																				dateData[1] = d.getName();
																				dateData[2] = date.getList(d.getId()).get(i).getDate();
																				dateData[3] = date.getList(d.getId()).get(i).getStatus();
																				dateModel.addRow(dateData);
																			}
																			String t = null;
																			deleteID.setText(t);
																		} catch (SQLException e) {
																			// TODO Auto-generated catch block
																			e.printStackTrace();
																		}

																		dateTable.setModel(dateModel);
																	} else {
																		JOptionPane.showMessageDialog(null, "Error delete Date !");

																	}
																} else {
																	JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
																}

															}
														});
														deleteDate_btn.setBounds(569, 65, 107, 30);
														availableDate.add(deleteDate_btn);
														
																JLabel lblEnterDateId = new JLabel("Enter Date id");
																lblEnterDateId.setForeground(new Color(255, 255, 240));
																lblEnterDateId.setFont(new Font("Times New Roman", Font.ITALIC, 17));
																lblEnterDateId.setBounds(569, 11, 168, 22);
																availableDate.add(lblEnterDateId);
		
		
		JLabel lblWelcome = new JLabel("Dentist Panel");
		lblWelcome.setForeground(new Color(0, 0, 139));
		lblWelcome.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		lblWelcome.setBounds(342, 11, 222, 23);
		contentPane.add(lblWelcome);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(712, 12, 112, 44);
		contentPane.add(btnNewButton);

		JLabel getName = new JLabel(d.getName());
		getName.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		getName.setBounds(10, 11, 222, 23);
		contentPane.add(getName);
	}
}
