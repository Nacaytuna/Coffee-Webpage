package recipeBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame mainFrame;
	private JFrame previousFrame;

	public Add(JFrame previousFrame) {
		this.previousFrame = previousFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainFrame= this;
		
		JLabel lblNewLabel = new JLabel("New recipe added!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(95, 26, 216, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				if (previousFrame instanceof AddFrame) {
                    AddFrame addFrame = (AddFrame) previousFrame;
                    addFrame.setVisible(true);
				}	
			}
		});
		btnNewButton.setBounds(149, 66, 89, 23);
		contentPane.add(btnNewButton);
	}
}