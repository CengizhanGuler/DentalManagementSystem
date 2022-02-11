import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.table.TableCellRenderer;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.SQLException;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PatientGUI extends JFrame {
	static Patient p = new Patient();
	Dentist d = new Dentist();
	DentistDate date = new DentistDate();
	Appointment a = new Appointment();
	private JPanel contentPane;
	private JTable dentistList;
	private JTextField searchField;
	private JTable dateList;
	private JTable appList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientGUI frame = new PatientGUI(p);
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
	public PatientGUI(Patient p) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Dentist Table Model Start
		DefaultTableModel DentistModel = new DefaultTableModel();
		Object[] columnName = new Object[2];
		columnName[0] = "ID";
		columnName[1] = "Dentist Name";
		DentistModel.setColumnIdentifiers(columnName);
		Object[] dentistData = new Object[4];
		for (int i = 0; i < d.getList().size(); i++) {
			dentistData[0] = d.getList().get(i).getId();
			dentistData[1] = d.getList().get(i).getName();
			DentistModel.addRow(dentistData);
		}
		// Dentist Table Model End

		// Date Table Model Start
		DefaultTableModel dateModel = new DefaultTableModel();
		Object[] columnDateName = new Object[3];
		columnDateName[0] = "Dentist ID";
		columnDateName[1] = "Dentist Name";
		columnDateName[2] = "Available Date";
		dateModel.setColumnIdentifiers(columnDateName);
		Object[] dateData = new Object[3];

		// Date Table Model End

		// Dentist Table Model Start
		DefaultTableModel AppModel = new DefaultTableModel();
		Object[] columnAppName = new Object[3];
		columnAppName[0] = "ID";
		columnAppName[1] = "Dentist Name";
		columnAppName[2] = "Date";
		AppModel.setColumnIdentifiers(columnAppName);
		Object[] appData = new Object[3];
		for (int i = 0; i < a.getListPatient(p.getId()).size(); i++) {
			appData[0] = a.getListPatient(p.getId()).get(i).getId();
			appData[1] = a.getListPatient(p.getId()).get(i).getDentist_name();
			appData[2] = a.getListPatient(p.getId()).get(i).getDate();
			AppModel.addRow(appData);
		}
		// Dentist Table Model End

		JLabel lblWelcomePatientPanel = new JLabel("Patient Panel");
		lblWelcomePatientPanel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		lblWelcomePatientPanel.setBounds(313, 12, 222, 23);
		contentPane.add(lblWelcomePatientPanel);

		JButton button = new JButton("Logout");
		button.setBackground(new Color(255, 182, 193));
		button.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		button.setBounds(712, 12, 112, 44);
		contentPane.add(button);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		tabbedPane.setBounds(0, 45, 834, 516);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.BLACK);
		tabbedPane.addTab("Make Appointment", null, panel, null);
		panel.setLayout(null);

		dentistList = new JTable();
		dentistList.setBounds(0, 76, 291, 406);
		dentistList.setModel(DentistModel);
		panel.add(dentistList);

		JScrollPane scrollPane = new JScrollPane(dentistList);
		scrollPane.setBounds(0, 44, 291, 438);
		panel.add(scrollPane);

		searchField = new JTextField();
		searchField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchField.setText(null);
			}
		});
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel search = (DefaultTableModel) dentistList.getModel();
				String searchKey = searchField.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(search);
				dentistList.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(searchKey));
				String text = searchField.getText();

			}
		});
		searchField.setText("Enter a keyword");
		searchField.setBounds(301, 155, 118, 30);
		panel.add(searchField);
		searchField.setColumns(10);

		JLabel lblDentistList = new JLabel("Dentist List");
		lblDentistList.setForeground(new Color(0, 0, 205));
		lblDentistList.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDentistList.setBounds(10, 11, 112, 22);
		panel.add(lblDentistList);

		JLabel lblSearchDentist = new JLabel("Search Dentist");
		lblSearchDentist.setForeground(new Color(0, 0, 128));
		lblSearchDentist.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblSearchDentist.setBounds(301, 122, 112, 22);
		panel.add(lblSearchDentist);

		JButton select_btn = new JButton("Select Dentist");
		select_btn.setBackground(new Color(255, 250, 250));
		select_btn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = dentistList.getSelectedRow();
				if (row >= 0) {
					String value = dentistList.getModel().getValueAt(row, 0).toString();
					String name = dentistList.getModel().getValueAt(row, 1).toString();

					DefaultTableModel clearModel = (DefaultTableModel) dateList.getModel();
					int id = Integer.parseInt(value);
					clearModel.setRowCount(0);
					try {
						for (int i = 0; i < date.getList(id).size(); i++) {
							dateData[0] = date.getList(id).get(i).getDentist_id();
							dateData[1] = name;
							dateData[2] = date.getList(id).get(i).getDate();
							dateModel.addRow(dateData);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dateList.setModel(dateModel);
				} else {
					JOptionPane.showMessageDialog(null, "Error! Please select dentist in list!");
				}

			}
		});
		select_btn.setBounds(301, 218, 118, 28);
		panel.add(select_btn);

		dateList = new JTable();
		dateList.setBounds(445, 44, 384, 438);
		dateList.setModel(dateModel);
		panel.add(dateList);
		JScrollPane scrollPane_1 = new JScrollPane(dateList);
		scrollPane_1.setBounds(439, 44, 390, 438);
		panel.add(scrollPane_1);

		JLabel lblDentistsAvailableDate = new JLabel("Dentist's Available Date");
		lblDentistsAvailableDate.setForeground(new Color(0, 0, 205));
		lblDentistsAvailableDate.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDentistsAvailableDate.setBounds(435, 11, 187, 22);
		panel.add(lblDentistsAvailableDate);

		JButton btnMakeAppointment = new JButton("Appointment");
		btnMakeAppointment.setBackground(new Color(255, 250, 250));
		btnMakeAppointment.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnMakeAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = dateList.getSelectedRow();
				if (row >= 0) {
					String id = dateList.getModel().getValueAt(row, 0).toString();
					String dentist_name = dateList.getModel().getValueAt(row, 1).toString();
					String date = dateList.getModel().getValueAt(row, 2).toString();
					try {
						boolean control = p.addAppointment(Integer.parseInt(id), p.getId(), date);
						if (control) {
							JOptionPane.showMessageDialog(null,
									"Success Appointment , You can see detail 'My Appointments' tabs !");
							p.updateDateStatus(Integer.parseInt(id), date);
							DefaultTableModel clearModel = (DefaultTableModel) dateList.getModel();
							clearModel.setRowCount(0);
							dateList.setModel(dateModel);

						} else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error! Please select date in list!");
				}
			}
		});
		btnMakeAppointment.setBounds(301, 301, 118, 28);
		panel.add(btnMakeAppointment);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		tabbedPane.addTab("My Appointments", null, panel_1, null);
		panel_1.setLayout(null);

		appList = new JTable();
		appList.setBounds(10, 59, 809, 412);
		appList.setModel(AppModel);
		panel_1.add(appList);

		JScrollPane scrollPane_2 = new JScrollPane(appList);
		scrollPane_2.setBounds(10, 60, 809, 411);
		panel_1.add(scrollPane_2);

		JLabel lblMyAppointmentsList = new JLabel("My Appointments List");
		lblMyAppointmentsList.setForeground(new Color(0, 0, 139));
		lblMyAppointmentsList.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblMyAppointmentsList.setBounds(10, 27, 185, 22);
		panel_1.add(lblMyAppointmentsList);

		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel clearModel = (DefaultTableModel) appList.getModel();
				clearModel.setRowCount(0);
				try {
					for (int i = 0; i < a.getListPatient(p.getId()).size(); i++) {
						appData[0] = a.getListPatient(p.getId()).get(i).getId();
						appData[1] = a.getListPatient(p.getId()).get(i).getDentist_name();
						appData[2] = a.getListPatient(p.getId()).get(i).getDate();
						AppModel.addRow(appData);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				appList.setModel(AppModel);
			}
		});
		btnNewButton.setBounds(730, 26, 89, 23);
		panel_1.add(btnNewButton);

		JLabel label = new JLabel(p.getName());
		label.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(10, 12, 222, 23);
		contentPane.add(label);
	}
}

class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {

	private static final long serialVersionUID = 1L;

	WordWrapCellRenderer() {
		setLineWrap(true);
		setWrapStyleWord(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText(value.toString());
		setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
		if (table.getRowHeight(row) != getPreferredSize().height) {
			table.setRowHeight(row, getPreferredSize().height);
		}
		return this;
	}
}