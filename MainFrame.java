package recipeBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFName;
	private JPasswordField txtFPass;
	private JPasswordField passwordField;
	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainFrame = this;
		
		JLabel lblTitle = new JLabel("BREWOLOGY CAFE");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setBackground(new Color(205, 133, 63));
		lblTitle.setFont(new Font("Gadugi", Font.BOLD, 34));
		lblTitle.setBounds(120, 68, 310, 40);
		contentPane.add(lblTitle);
		
		JLabel lblAdminLog = new JLabel("Admin Log-in");
		lblAdminLog.setForeground(new Color(0, 0, 0));
		lblAdminLog.setBackground(new Color(200, 157, 115));
		lblAdminLog.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdminLog.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblAdminLog.setBounds(74, 122, 146, 36);
		contentPane.add(lblAdminLog);
		
		
		
		JLabel lblBtb = new JLabel("Begin the brew!");
		lblBtb.setHorizontalAlignment(SwingConstants.LEFT);
		lblBtb.setForeground(Color.BLACK);
		lblBtb.setFont(new Font("Gadugi", Font.PLAIN, 13));
		lblBtb.setBackground(new Color(200, 157, 115));
		lblBtb.setBounds(74, 151, 146, 18);
		contentPane.add(lblBtb);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(74, 198, 45, 13);
		contentPane.add(lblName);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPass.setBounds(74, 256, 91, 13);
		contentPane.add(lblPass);
		
		txtFName = new JTextField();
		txtFName.setBounds(74, 221, 175, 21);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		txtFPass = new JPasswordField();
        txtFPass.setBounds(74, 279, 175, 21);
        contentPane.add(txtFPass);
        
        
		
		 JButton btnLogin = new JButton("Proceed to Log in");
	        btnLogin.setBackground(new Color(205, 133, 63));
	        btnLogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String enteredUsername = txtFName.getText();
	                String enteredPassword = new String(txtFPass.getPassword());

	                // Store admin credentials in a Map
	                Map<String, String> adminCredentials = new HashMap<>();
	                adminCredentials.put("joshua", "nacaytuna");
	                adminCredentials.put("francen", "sellote");
	                adminCredentials.put("jessa", "daloro");
	                adminCredentials.put("nicko jay", "tan");

	                // Check if entered credentials match any admin credentials
	                boolean isAdmin = false;
	                for (Map.Entry<String, String> entry : adminCredentials.entrySet()) {
	                    if (entry.getKey().equals(enteredUsername) && entry.getValue().equals(enteredPassword)) {
	                        isAdmin = true;
	                        break;
	                    }
	                }

	                if (isAdmin) {
	                    FrameOne frameOne = new FrameOne(); // Assuming FrameOne is a class representing your existing frame
	                    frameOne.setVisible(true);

	                    JOptionPane.showMessageDialog(contentPane, "Logged in as admin!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);

	                    mainFrame.dispose();
	                    System.out.println("Logged in as admin!");
	                } else {
	                    JOptionPane.showMessageDialog(contentPane, "Incorrect username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
	                    System.out.println("Incorrect username or password");
	                }
	            }
	        });
	        
	        getRootPane().setDefaultButton(btnLogin);





		btnLogin.setBounds(74, 328, 175, 21);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(245, 255, 250));
		btnExit.setBounds(74, 370, 175, 21);
		contentPane.add(btnExit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 371, 7, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Joshua Nacaytuna\\eclipse-workspace\\Final_OOP\\bin\\Coffe Image.png"));
		lblNewLabel.setBounds(66, 52, 53, 66);
		contentPane.add(lblNewLabel);
		
		JLabel wallpeps = new JLabel("New label");
		Image secondphoto = new ImageIcon(this.getClass().getResource("/haha.png")).getImage();
		wallpeps.setIcon(new ImageIcon(secondphoto));
		wallpeps.setBounds(0, -14, 839, 495);
		contentPane.add(wallpeps);

		
		
	}
}