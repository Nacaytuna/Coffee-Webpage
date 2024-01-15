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

public class Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame mainFrame;
	private JFrame previousFrame;

	public Update(JFrame previousFrame) {
		this.previousFrame = previousFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainFrame = this;
		
		JLabel lblRecipeUpdated = new JLabel("Coffee Recipe updated!");
		lblRecipeUpdated.setBounds(95, 30, 224, 22);
		lblRecipeUpdated.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeUpdated.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblRecipeUpdated);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				if (previousFrame instanceof CoffeeFrame) {
                    CoffeeFrame updateFrame = (CoffeeFrame) previousFrame;
                    updateFrame.setVisible(true);
				}	
			}
		});
		btnNewButton.setBounds(165, 62, 89, 23);
		contentPane.add(btnNewButton);
	}
}