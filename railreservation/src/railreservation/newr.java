package railreservation;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class newr extends JFrame {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField t1;
	 JTextField t2;
JTextField t3;
JTextField t4;
JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newr frame = new newr();
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
	public newr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Railway No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(89, 77, 111, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNoOfCarriages = new JLabel("No. of carriages");
		lblNoOfCarriages.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoOfCarriages.setBounds(89, 123, 137, 25);
		contentPane.add(lblNoOfCarriages);
		
		JLabel lblCarryingCapacity = new JLabel("Carrying capacity");
		lblCarryingCapacity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCarryingCapacity.setBounds(89, 165, 139, 25);
		contentPane.add(lblCarryingCapacity);
		
		JLabel lblRoute = new JLabel("Route");
		lblRoute.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoute.setBounds(89, 207, 111, 25);
		contentPane.add(lblRoute);
		
		JLabel lblFrequency = new JLabel("Frequency");
		lblFrequency.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFrequency.setBounds(89, 254, 111, 25);
		contentPane.add(lblFrequency);
		
		JLabel lblStartedOnDate = new JLabel("Started on date");
		lblStartedOnDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStartedOnDate.setBounds(89, 300, 137, 25);
		contentPane.add(lblStartedOnDate);
		
		t1 = new JTextField();
		t1.setBounds(250, 80, 232, 25);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(250, 123, 232, 25);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(250, 165, 232, 25);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(250, 254, 232, 25);
		contentPane.add(t4);
		
		final JComboBox cb = new JComboBox();
		cb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb.setModel(new DefaultComboBoxModel(new String[] {"Choose Route", "Red", "Blue", "Pink", "Orange", "Yellow", "Violet"}));
		cb.setBounds(250, 207, 232, 25);
		contentPane.add(cb);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(250, 300, 232, 25);
		contentPane.add(t5);
		
		JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				try{
					String var1=t1.getText();
					String var2=t2.getText();
					String var3=t3.getText();	
					String var4=(String)cb.getSelectedItem();
					String var5=t4.getText();
					String var6=t5.getText();
				
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rail","root","srushti");
					String sql="INSERT INTO newrr VALUES(?,?,?,?,?,?)";	
					PreparedStatement pq=con.prepareStatement(sql);
					pq.setString(1,var1);
					pq.setString(2,var2);	
					pq.setString(3,var3);	
					pq.setString(4,var4);
					pq.setString(5,var5);
					pq.setString(6,var6);	
				
					pq.executeUpdate();
					System.out.println("YES");
				}
				
					catch(Exception m){
					System.out.println("NO");
					}
				
			JOptionPane.showMessageDialog(null, "DONE SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);	
		
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		b1.setBounds(232, 388, 139, 52);
		contentPane.add(b1);
	}
}
