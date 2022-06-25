package ATM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Pinpage extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordpinNum;
	JLabel lblmsg = new JLabel();


	/**
	 * Create the frame.
	 */
	public Pinpage(account_info acc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\TABA\\Downloads\\Logo.jpeg"));
		setTitle("La Casa del Dinero");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 225, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblgreet = new JLabel("Hello "+acc.getcustomerName());
		lblgreet.setHorizontalAlignment(SwingConstants.CENTER);
		lblgreet.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 25));
		lblgreet.setBounds(10, 11, 461, 72);
		contentPane.add(lblgreet);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		     int pinNumber = Integer.parseInt(String.valueOf(passwordpinNum.getPassword()));
				if(pinNumber==(acc.getpinNumber())) {
					DashBoard db =new DashBoard(acc);
					db.setVisible(true);	
					contentPane.setVisible(false);
					dispose();
				}
				else {
				 JOptionPane.showMessageDialog(null, "Wrong Pin Number\n\tTry Again",null, JOptionPane.ERROR_MESSAGE);
				 passwordpinNum.setText("");
				}
			}
				catch(NumberFormatException nfe) {
					passwordpinNum.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Input\nTry Again",null, JOptionPane.WARNING_MESSAGE);
					}
				}
		});
		btnLogin.setBounds(297, 159, 89, 23);
		contentPane.add(btnLogin);
		
		passwordpinNum = new JPasswordField();
		passwordpinNum.setBounds(224, 128, 127, 20);
		contentPane.add(passwordpinNum);
		
		JLabel lblNewLabel = new JLabel("Pin Number");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(125, 126, 89, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Pin Number Here");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(109, 94, 277, 23);
		contentPane.add(lblNewLabel_1);
		lblmsg.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 22));
		lblmsg.setBounds(139, 233, 332, 76);	
		contentPane.add(lblmsg);		
	}
}
