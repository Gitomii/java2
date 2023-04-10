package railreservation;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class findr extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					findr frame = new findr();
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
	public findr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Railway No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(91, 90, 102, 31);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(234, 90, 205, 31);
		contentPane.add(t1);
		t1.setColumns(10);
		
		final JButton b1 = new JButton("FIND");
		b1.addActionListener(new ActionListener() {
			private JLabel t2;
			private JLabel t3;
			private JComboBox<?> cb;
			private JLabel t5;
			private JLabel t4;

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rail","root","srushti");
						
					PreparedStatement pq = con.prepareStatement("SELECT * FROM newrr where railno=?");
					pq.setString(1,t1.getText());
					ResultSet rs =pq.executeQuery();
					while(rs.next()){
						
					String railno=rs.getString(1); 
					t1.setText(railno); 
					
					String carriages=rs.getString(2);
					t2.setText(carriages); 
					
					String capacity=rs.getString(3);
					t3.setText(capacity);  
					
					String rout=rs.getString("route");
					cb.setSelectedItem(rout);
					
					String frequency=rs.getString(5);
					t4.setText(frequency);
					
					String date=rs.getString(6);
					t5.setText(date);

					}}
					catch(Exception p){
					System.out.println("NO");
					}}
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		b1.setBounds(208, 184, 113, 45);
		contentPane.add(b1);
	}
}
