package recipeBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class PastryAddFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Recipe_Title;
	private JFrame mainFrame;
	private static JFrame previousFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PastryAddFrame frame = new PastryAddFrame(previousFrame);
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
	public PastryAddFrame(JFrame previousFrame) {
		this.previousFrame = previousFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainFrame = this;
		
		JLabel lblAdd = new JLabel("Add New Recipe For Pastry");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdd.setBounds(131, 10, 207, 27);
		contentPane.add(lblAdd);
		
		JLabel lblTitle = new JLabel("Name of the Recipe:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTitle.setBounds(10, 50, 112, 14);
		contentPane.add(lblTitle);
		
		JLabel lblMeasurements = new JLabel("Measurements:");
		lblMeasurements.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMeasurements.setBounds(10, 96, 79, 14);
		contentPane.add(lblMeasurements);
		
		JTextArea Recipe_Measurements = new JTextArea();
		Recipe_Measurements.setLineWrap(true);
		Recipe_Measurements.setWrapStyleWord(true);
		JScrollPane scrollPaneMeasure = new JScrollPane(Recipe_Measurements);
		scrollPaneMeasure.setBounds(131, 75, 220, 59);
		contentPane.add(scrollPaneMeasure);
		
		JLabel lblSteps = new JLabel("Steps:");
		lblSteps.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSteps.setBounds(10, 167, 79, 14);
		contentPane.add(lblSteps);
		
		JTextArea Recipe_Steps = new JTextArea();
		Recipe_Steps.setLineWrap(true);
		Recipe_Steps.setWrapStyleWord(true);
		JScrollPane scrollPaneSteps = new JScrollPane(Recipe_Steps);
		scrollPaneSteps.setBounds(131, 150, 220, 59);
		contentPane.add(scrollPaneSteps);
		
		Recipe_Title = new JTextField();
		Recipe_Title.setBounds(131, 47, 220, 20);
		contentPane.add(Recipe_Title);
		Recipe_Title.setColumns(10);
		
		JButton btnAdd = new JButton("Add Recipe");
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	mainFrame.setVisible(false);
		    	PastryAdd addRecipe = new PastryAdd(PastryAddFrame.this);
		        addRecipe.setVisible(true);
		        
		        String recipeTitle = Recipe_Title.getText();
		        String recipeSteps = Recipe_Steps.getText();
		        String recipeMeasurements = Recipe_Measurements.getText();

		        try {
		            // Establish connection to the PostgreSQL database
		            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Coffee Recipes", "postgres", "Nacaytunajoshua99");

		            // SQL statement to insert data into the table
		         // Generate a random 3-digit number
		            int randomId = (int) (Math.random() * 900) + 100; // Generates a number between 100 and 999

		            // SQL statement to insert data into the table
		            String sql = "INSERT INTO pastry (recipe_id, title, steps, measurements) VALUES (?, ?, ?, ?)";

		            // Creating a PreparedStatement to execute the SQL statement with parameters
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setInt(1, randomId); // Set the generated random number as recipe_id
		            preparedStatement.setString(2, recipeTitle);
		            preparedStatement.setString(3, recipeSteps);
		            preparedStatement.setString(4, recipeMeasurements);

		            // Execute the rest of the code for inserting data into the database...


		            // Executing the insert operation
		            int rowsAffected = preparedStatement.executeUpdate();
		            if (rowsAffected > 0) {
		                System.out.println("Recipe added successfully!");
		                // Optionally, add a success message or perform additional actions upon successful insertion
		            } else {
		                System.out.println("Failed to add recipe.");
		                // Optionally, handle the failure case
		            }

		            // Closing the PreparedStatement and database connection
		            preparedStatement.close();
		            connection.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            // Handle any SQL exceptions here
		        }
		    }
		});
		btnAdd.setBounds(183, 220, 112, 23);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setOpaque(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				if (previousFrame != null) {
                    previousFrame.setVisible(true);
				}

			}
		});
		btnBack.setBounds(-21, 0, 89, 23);
		contentPane.add(btnBack);
	}
}