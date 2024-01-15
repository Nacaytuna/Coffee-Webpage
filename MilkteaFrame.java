
package recipeBook;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.EventQueue;


public class MilkteaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JTextField RecipeID;
	
	
	
	private void searchRecipeByID(String recipeID, JTextArea textArea) {
        String url = "jdbc:postgresql://localhost:5433/Coffee Recipes";
        String username = "postgres";
        String password = "Nacaytunajoshua99";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT recipe_id, title, measurements, steps FROM milktea WHERE recipe_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, recipeID);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if any data is found
            if (resultSet.next()) {
                String titleData = resultSet.getString("title");
                String measurementsData = resultSet.getString("measurements");
                String stepsData = resultSet.getString("steps");

                // Set the retrieved data to the text area
                textArea.setText("Recipe ID: " + recipeID + "\nTitle: " + titleData + "\nMeasurements: " + measurementsData + "\nSteps: " + stepsData);
            } else {
                textArea.setText("Recipe ID not found.");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeFrame frame = new CoffeeFrame();
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
	public MilkteaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 520);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		
		mainFrame = this;
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				MilkTeaAddFrame add = new MilkTeaAddFrame(mainFrame);
				add.setVisible(true);
			}
		});
		btnAdd.setBounds(10, 44, 85, 21);
		
		JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(94, 44, 85, 21);
        btnUpdate.setEnabled(false); // Initially disabled

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 72, 816, 151);
        contentPane.setLayout(null);
        contentPane.add(textArea);
        contentPane.add(btnUpdate);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                btnUpdate.setEnabled(true); // Enable button when text changes
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                btnUpdate.setEnabled(true); // Enable button when text changes
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                btnUpdate.setEnabled(true); // Enable button when text changes
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = textArea.getText();
                String[] inputLines = userInput.split("\n");

                String updatedRecipeID = RecipeID.getText().trim();
                String updatedTitle = "";
                String updatedSteps = "";
                String updatedMeasurements = "";

                // Skip the first line containing recipe_id
                for (int i = 1; i < inputLines.length; i++) {
                    String line = inputLines[i];

                    if (line.startsWith("Title:")) {
                        updatedTitle = line.substring("Title:".length()).trim();
                    } else if (line.startsWith("Steps:")) {
                        updatedSteps = line.substring("Steps:".length()).trim();
                    } else if (line.startsWith("Measurements:")) {
                        updatedMeasurements = line.substring("Measurements:".length()).trim();
                    }
                }

                String url = "jdbc:postgresql://localhost:5433/Coffee Recipes";
                String username = "postgres";
                String password = "Nacaytunajoshua99";

                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String updateSQL = "UPDATE milktea SET title = ?, steps = ?, measurements = ? WHERE recipe_id = ?";

                    PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
                    preparedStatement.setString(1, updatedTitle);
                    preparedStatement.setString(2, updatedSteps);
                    preparedStatement.setString(3, updatedMeasurements);
                    preparedStatement.setString(4, updatedRecipeID);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Update successful!");
                    } else {
                        System.out.println("Failed to update. Recipe ID might not exist.");
                    }

                    preparedStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


    

		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				MilkteaDeleteFrame delete = new MilkteaDeleteFrame(mainFrame);
				delete.setVisible(true);
			}
		});
		btnDelete.setBounds(94, 21, 85, 21);
		contentPane.setLayout(null);
		contentPane.add(btnAdd);
		contentPane.add(btnDelete);
		contentPane.add(btnUpdate);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setOpaque(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				FrameOne fone = new FrameOne();
				fone.setVisible(true);
			}
		});
		btnBack.setBounds(-21, 0, 89, 23);
		contentPane.add(btnBack);
		
		
		textArea.setBounds(10, 72, 816, 401);
		contentPane.add(textArea);
		
		JButton Refresh = new JButton("Refresh");
        Refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:postgresql://localhost:5433/Coffee Recipes";
                String username = "postgres";
                String password = "Nacaytunajoshua99";

                try {
                    // Establish the database connection
                    Connection connection = DriverManager.getConnection(url, username, password);

                    // Query to retrieve data
                    String query = "SELECT recipe_id, title, measurements, steps FROM milktea"; // Replace with your table name and column names

                    // Prepare and execute the query
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    // Clear the text area before appending refreshed data
                    textArea.setText("");

                    // Process the retrieved data and populate the textArea
                    while (resultSet.next()) {
                        String rIdData = resultSet.getString("recipe_id");
                        String titleData = resultSet.getString("title");
                        String measurementsData = resultSet.getString("measurements");
                        String stepsData = resultSet.getString("steps");

                        // Append data to the textArea
                        textArea.append("Recipe ID: " + rIdData + "\nTitle: " + titleData + "\nMeasurements: " + measurementsData + "\nSteps: " + stepsData + "\n\n");
                    }

                    // Close resources
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle exceptions appropriately
                }
            }
        });
        Refresh.setBounds(10, 21, 85, 21);
        contentPane.add(Refresh);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 72, 816, 401);
        contentPane.add(scrollPane);
        
        RecipeID = new JTextField();
        RecipeID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredRecipeID = RecipeID.getText().trim();
                searchRecipeByID(enteredRecipeID, textArea); // Call the search method with the entered Recipe ID
            }
        });

        RecipeID.setBounds(741, 45, 85, 19);
        contentPane.add(RecipeID);
        RecipeID.setColumns(10);
        
        JButton Done = new JButton("Search");
        Done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchedRecipeID = RecipeID.getText().trim();
                searchRecipeByID(searchedRecipeID, textArea); // Pass textArea to display the data
            }
        });
        Done.setBounds(654, 44, 85, 21);
        contentPane.add(Done);
    }
}