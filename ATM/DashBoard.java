package ATM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class DashBoard extends  JFrame {


	private JPanel contentPane;
	private JTextField textwdamnt;
	private JTextField textdpamnt;
	/**
	 * Create the frame.
	 */
	public DashBoard(account_info acc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\TABA\\Downloads\\Logo.jpeg"));
		setTitle("La Casa del Dinero");
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 708, 474);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblcurrentaccount = new JLabel("CURRENT ACCOUNT");
		lblcurrentaccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrentaccount.setFont(new Font("Broadway", Font.ITALIC, 27));
		lblcurrentaccount.setBounds(0, 11, 692, 58);
		contentPane.add(lblcurrentaccount);
		
		JButton btncw = new JButton("WithDraw");
		btncw.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btncw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int amountwithdraw =Integer.parseInt(textwdamnt.getText());;
				if ((acc.getcurrentBalance() - amountwithdraw) >= 0 && amountwithdraw> 0) {
					acc.calcBalanceWithdraw(amountwithdraw);
					 textwdamnt.setText("");
					 JOptionPane.showMessageDialog(null, "Transaction Successful\nYou have Successfully Withdraw  "+amountwithdraw,null, JOptionPane.PLAIN_MESSAGE);
				}else if(amountwithdraw==0){
					JOptionPane.showMessageDialog(null, "Amount should be Greater than 0 ",null, JOptionPane.ERROR_MESSAGE);
				} 
				else {
					 JOptionPane.showMessageDialog(null, "Insufficient Balance ",null, JOptionPane.ERROR_MESSAGE);
					 textwdamnt.setText("");
				}
			}	catch(NumberFormatException nfe) {
				 textwdamnt.setText("");
				JOptionPane.showMessageDialog(null, "Must Enter a value",null, JOptionPane.WARNING_MESSAGE);
			}}
		});
		btncw.setBounds(10, 143, 137, 23);
		contentPane.add(btncw);
		
		JButton btnbq = new JButton("Balance Inquiry");
		btnbq.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnbq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, " Your Current Balance :  "+acc.getcurrentBalance(),null, JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnbq.setBounds(545, 143, 137, 23);
		contentPane.add(btnbq);
		
		JButton btnexit = new JButton("Exit");
		btnexit.setForeground(Color.RED);
		btnexit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if	(JOptionPane.showConfirmDialog(contentPane,"Are you sure you want to exit","Exit",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION )
				{
					System.exit(0);
				}
			}});
		btnexit.setBounds(563, 286, 119, 23);
		contentPane.add(btnexit);
		
		JButton btnCD = new JButton("Deposit");
		btnCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int amountdeposit =Integer.parseInt(textdpamnt.getText());
				if ((acc.getcurrentBalance() + amountdeposit) > 0 && amountdeposit >0) {
				   acc.calcBalanceDeposit(amountdeposit);
				   textdpamnt.setText("");
				   JOptionPane.showMessageDialog(null, "Transaction Successful\nYou have Successfully Deposit "+amountdeposit,null, JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Amount should be Greater than 0 ",null, JOptionPane.ERROR_MESSAGE);
					 textdpamnt.setText("");
				}
				}	catch(NumberFormatException nfe) {
					textdpamnt.setText("");
					JOptionPane.showMessageDialog(null, "Must Enter a Value",null, JOptionPane.WARNING_MESSAGE);
			}}
		});
		btnCD.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCD.setBounds(10, 286, 137, 23);
		contentPane.add(btnCD);
		
		textwdamnt = new JTextField();
		textwdamnt.setColumns(10);
		textwdamnt.setBounds(10, 100, 137, 20);
		contentPane.add(textwdamnt);
		
		textdpamnt = new JTextField();
		textdpamnt.setColumns(10);
		textdpamnt.setBounds(10, 242, 137, 20);
		contentPane.add(textdpamnt);
	}
}