package ATM;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Logopage extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Logopage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\TABA\\Downloads\\Logo.jpeg"));
		setTitle("La Casa del Dinero");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 225, 500, 300);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnproceed = new JButton("Proceed");
		btnproceed.setForeground(Color.GREEN);
		btnproceed.setBackground(Color.LIGHT_GRAY);
		btnproceed.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnproceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer info = new Customer();
				loginPage loginPage = new loginPage(info.getinfo());
				contentPane.setVisible(false);
				dispose();

			}
		});
		btnproceed.setBounds(315, 194, 146, 29);
		contentPane.add(btnproceed);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setForeground(Color.RED);
		btnexit.setBackground(Color.LIGHT_GRAY);
		btnexit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnexit.setBounds(29, 194, 146, 29);
		contentPane.add(btnexit);
		
		JLabel lblname = new JLabel(" La Casa del Dinero");
		lblname.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 30));
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		lblname.setBounds(164, 29, 310, 72);
		contentPane.add(lblname);
		
		JLabel lblwelcome = new JLabel("Welcome to");
		lblwelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblwelcome.setBounds(10, 29, 214, 68);
		contentPane.add(lblwelcome);
	}
}
