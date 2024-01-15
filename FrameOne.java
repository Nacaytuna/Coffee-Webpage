package recipeBook;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Image;
import javax.swing.ImageIcon;


public class FrameOne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameOne frame = new FrameOne();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameOne() {
		setBackground(new Color(255, 228, 181));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 520);
		contentPane = 	new JPanel();
		contentPane.setForeground(new Color(210, 180, 140));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainFrame = this;
		
		JButton btnCoffee = new JButton("View Recipe");
		btnCoffee.setBackground(new Color(245, 222, 179));
		btnCoffee.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCoffee.setForeground(new Color(0, 0, 0));
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				CoffeeFrame coffeeframe = new CoffeeFrame();
				coffeeframe.setVisible(true);
			}
		});
		btnCoffee.setBounds(84, 347, 168, 33);
		contentPane.add(btnCoffee);
		
		JButton btnMilktea = new JButton("View Recipe");
		btnMilktea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				MilkteaFrame milkteaframe = new MilkteaFrame();
				milkteaframe.setVisible(true);
			}
		});
		btnMilktea.setForeground(Color.BLACK);
		btnMilktea.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnMilktea.setBackground(new Color(245, 222, 179));
		btnMilktea.setBounds(334, 347, 168, 33);
		contentPane.add(btnMilktea);
		
		JButton btnPastries = new JButton("View Recipe");
		btnPastries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				PastriesFrame pastriesframe = new PastriesFrame();
				pastriesframe.setVisible(true);
			}
		});
		btnPastries.setForeground(Color.BLACK);
		btnPastries.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPastries.setBackground(new Color(245, 222, 179));
		btnPastries.setBounds(578, 347, 168, 33);
		contentPane.add(btnPastries);
		
		JLabel lblCoffee = new JLabel("Coffee");
		lblCoffee.setForeground(new Color(255, 128, 128));
		lblCoffee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCoffee.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoffee.setBounds(123, 325, 94, 14);
		contentPane.add(lblCoffee);
		
		JLabel lblMilktea = new JLabel("Milktea");
		lblMilktea.setForeground(new Color(255, 128, 128));
		lblMilktea.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilktea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMilktea.setBounds(375, 325, 94, 14);
		contentPane.add(lblMilktea);
		
		JLabel lblPastry = new JLabel("Pastry");
		lblPastry.setForeground(new Color(255, 128, 128));
		lblPastry.setHorizontalAlignment(SwingConstants.CENTER);
		lblPastry.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPastry.setBounds(618, 327, 94, 14);
		contentPane.add(lblPastry);
		
		JLabel imgcoffeebased = new JLabel("");
		Image coffeebased = new ImageIcon(this.getClass().getResource("/coffee.png")).getImage();
		imgcoffeebased.setIcon(new ImageIcon(coffeebased));
		imgcoffeebased.setBounds(77, 116, 190, 200);
		contentPane.add(imgcoffeebased);
		
		JLabel imgmilktea = new JLabel("");
		Image milktea = new ImageIcon(this.getClass().getResource("/milktea.png")).getImage();
		imgmilktea.setIcon(new ImageIcon(milktea));
		imgmilktea.setBounds(319, 116, 192, 200);
		contentPane.add(imgmilktea);
		
		JLabel imgpastries = new JLabel("");
		Image pastries = new ImageIcon(this.getClass().getResource("/pastry.png")).getImage();
		imgpastries.setIcon(new ImageIcon(pastries));
		imgpastries.setBounds(561, 116, 190, 200);
		contentPane.add(imgpastries);
		
		JButton btnBack = new JButton("Log out");
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				MainFrame fone = new MainFrame();
				fone.setVisible(true);
			}
		});
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setBounds(737, 450, 89, 23);
		contentPane.add(btnBack);
		
		JLabel wallpep = new JLabel("New label");
		Image secondphoto = new ImageIcon(this.getClass().getResource("/second.jpg")).getImage();
		wallpep.setIcon(new ImageIcon(secondphoto));
		wallpep.setBounds(0, -14, 839, 495);
		contentPane.add(wallpep);

		


	}
}
