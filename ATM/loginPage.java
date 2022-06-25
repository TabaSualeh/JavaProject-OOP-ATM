package ATM;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

public class loginPage implements ActionListener{
	JFrame frmLaCasaDel = new JFrame();
	JButton enterButton = new JButton("Enter");
	JTextField userIDField = new JTextField();
	JLabel cstLabel = new JLabel("Customer Number ");
	JLabel messageLabel = new JLabel();
	JLabel pleaseLabel=new JLabel("Please Enter your Customer Number here");
	HashMap<Integer,account_info> login = new HashMap<Integer,account_info>();
		
	loginPage(HashMap<Integer,account_info> loginog){
		
		login= loginog;
		
		cstLabel.setBounds(90,100,150,25);
		 cstLabel.setFont(new Font("Times New Roman", Font.BOLD ,15));
	     cstLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userIDField.setBounds(227,100,100,26);
		userIDField.setForeground(Color.green);
		 userIDField.setFont(new Font("Times New Roman", Font.BOLD , 14));
	    pleaseLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		pleaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pleaseLabel.setBounds(10, 29, 450, 72);
		enterButton.setBounds(180,150,100,25);
		enterButton.setFont(new Font("Times New Roman", Font.BOLD , 14));
		enterButton.setFocusable(false);
		enterButton.addActionListener(this);

		frmLaCasaDel.getContentPane().add(pleaseLabel);
		frmLaCasaDel.getContentPane().add(cstLabel);
		frmLaCasaDel.getContentPane().add(userIDField);
		frmLaCasaDel.getContentPane().add(enterButton);
		frmLaCasaDel.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\TABA\\Downloads\\Logo.jpeg"));
		frmLaCasaDel.setTitle("La Casa del Dinero");
		frmLaCasaDel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLaCasaDel.setBounds(400, 225, 500, 300);
		frmLaCasaDel.getContentPane().setLayout(null);
		frmLaCasaDel.setVisible(true);
		frmLaCasaDel.setTitle("La Casa del Dinero");
		frmLaCasaDel.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\TABA\\Downloads\\Logo.jpeg"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource()==enterButton) {
			try {
			int customerNumber = Integer.parseInt(userIDField.getText());
			Iterator it=login.entrySet().iterator();
			while(it.hasNext()) {	
				Map.Entry pair =(Map.Entry)it.next();
				account_info acc=(account_info)pair.getValue();
				if(login.containsKey(customerNumber)) {
					if(  customerNumber==(acc.getcustomerNumber())) {
					    Pinpage pp =new Pinpage(acc);
 		                pp.setVisible(true);
 		                frmLaCasaDel.setVisible(false);					
 		                userIDField.setText("");
					}	
			}
				else {
					userIDField.setText("");
					JOptionPane.showMessageDialog(null, "Username not Found\nTry Again",null, JOptionPane.WARNING_MESSAGE);
				}
		}
	}	catch(NumberFormatException nfe) {
		userIDField.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Input\nTry Again",null, JOptionPane.ERROR_MESSAGE);
	}
}}}