package railreservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class empr extends JFrame {

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
					empr frame = new empr();
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
	public empr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(56, 85, 102, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(56, 151, 102, 38);
		contentPane.add(lblPassword);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t1.setBounds(219, 85, 213, 31);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("CREATE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String var1=t1.getText();
					String var2=t2.getText();
					
				
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rail","root","srushti");
					String sql="INSERT INTO emprr VALUES(?,?)";	
					PreparedStatement pq=con.prepareStatement(sql);
					pq.setString(1,var1);
					pq.setString(2,var2);			
					
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
		b1.setBounds(180, 247, 130, 38);
		contentPane.add(b1);
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t2.setBounds(219, 151, 213, 31);
		contentPane.add(t2);
	}
}
