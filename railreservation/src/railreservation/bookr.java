package railreservation;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class bookr extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookr frame = new bookr();
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
	public bookr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(44, 59, 47, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTo.setBounds(44, 137, 47, 33);
		contentPane.add(lblTo);
		
		final JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"Choose Route", "Red", "Blue", "Pink", "Orange", "Yellow", "Violet"}));
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb1.setBounds(131, 59, 232, 25);
		contentPane.add(cb1);
		
		final JComboBox cb3 = new JComboBox();
		cb3.setModel(new DefaultComboBoxModel(new String[] {"Choose Route", "Red", "Blue", "Pink", "Orange", "Yellow", "Violet"}));
		cb3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb3.setBounds(131, 137, 232, 25);
		contentPane.add(cb3);
		
		final JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"Choose Route", "Maltan", "Lonand"}));
		cb2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb2.setBounds(407, 59, 232, 25);
		contentPane.add(cb2);
		
		final JComboBox cb4 = new JComboBox();
		cb4.setModel(new DefaultComboBoxModel(new String[] {"Choose Route", "Pune ", "Mumbai", "Daund", "Chennai"}));
		cb4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb4.setBounds(407, 137, 232, 25);
		contentPane.add(cb4);
		
		JButton b1 = new JButton("PROCEED");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String var1=(String)cb1.getSelectedItem();
					String var2=(String)cb2.getSelectedItem();
					String var3=(String)cb3.getSelectedItem();
					String var4=(String)cb4.getSelectedItem();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rail","root","srushti");
					String sql="INSERT INTO bookrr VALUES(?,?,?,?)";	
					PreparedStatement pq=con.prepareStatement(sql);
					pq.setString(1,var1);
					pq.setString(2,var2);	
					pq.setString(3,var3);	
					pq.setString(4,var4);
					
					pq.executeUpdate();
					System.out.println("YES");
				}
				
					catch(Exception m){
					System.out.println("NO");
					}
				
			JOptionPane.showMessageDialog(null, "DONE SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);	
		
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		b1.setBounds(275, 235, 151, 40);
		contentPane.add(b1);
	}
}
