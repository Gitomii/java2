package railreservation;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class menu extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(134, 179, 381, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		t2 = new JPasswordField();
		t2.setBounds(188, 100, 158, 30);
		panel.add(t2);
		t2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel = new JLabel("USER NAME:");
		lblNewLabel.setBounds(20, 30, 158, 38);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 22));
		
		JLabel lblPassward = new JLabel("PASSWARD:");
		lblPassward.setBounds(20, 103, 158, 38);
		panel.add(lblPassward);
		lblPassward.setForeground(new Color(128, 0, 128));
		lblPassward.setFont(new Font("Sylfaen", Font.BOLD, 22));
		
		t1 = new JTextField();
		t1.setBounds(188, 28, 158, 28);
		panel.add(t1);
		t1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		t1.setColumns(10);
		
		JButton b1 = new JButton("LOGIN");
		b1.setForeground(new Color(0, 0, 0));
		b1.setBounds(20, 171, 149, 38);
		panel.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rail","root","srushti");
					Statement st = con.createStatement();
					
					@SuppressWarnings("deprecation")
					String sql="Select * from raill where name='"+t1.getText()+"' and pass='"+t2.getText().toString()+"'";
				    ResultSet rs = st.executeQuery(sql);
					if(rs.next()) 
						try {		
							login frame = new login();
							frame.setVisible(true);
							JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
							
						} catch (Exception p) {
							p.printStackTrace();
						}	
						else
						JOptionPane.showMessageDialog(null, "INCORRECT USERNAME OR PASSWORD","  ",JOptionPane.INFORMATION_MESSAGE);
						con.close();
					}
					catch(Exception x) {
						System.out.println(x);
			}
			}
		});
		b1.setFont(new Font("Sylfaen", Font.PLAIN, 22));
		
		JButton b2 = new JButton("CLEAR");
		b2.setFont(new Font("Sylfaen", Font.PLAIN, 22));
		b2.setBounds(197, 171, 149, 38);
		panel.add(b2);
		
		JLabel lblNewLabel_1 = new JLabel("RailwayReservation System");
		lblNewLabel_1.setForeground(new Color(255, 0, 255));
		lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		lblNewLabel_1.setBounds(146, 90, 362, 79);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\metro\\wp10424024-new-york-subway-wallpapers.jpg"));
		lblNewLabel_2.setBounds(-1150, 0, 1825, 543);
		contentPane.add(lblNewLabel_2);
	}
}
