package recipeBook;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.sql.*;
import javax.swing.JTextArea;

public class MilkteaDeleteFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JFrame mainFrame;
    private static JFrame previousFrame;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteFrame frame = new DeleteFrame(previousFrame);
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
    public MilkteaDeleteFrame(JFrame previousFrame) {
        this.previousFrame = previousFrame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 408, 305);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        mainFrame = this;
        
        JLabel search = new JLabel("Recipe ID:");
        search.setFont(new Font("Tahoma", Font.PLAIN, 15));
        search.setBounds(39, 53, 80, 14);
        contentPane.add(search);
		
        JFormattedTextField ftfName = new JFormattedTextField();
        ftfName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = ftfName.getText().trim();

                if (!searchText.isEmpty()) {
                    performSearch(searchText);
                } else {
                    // Handle empty search field if needed
                }
            }
        });
        
        ftfName.setBounds(112, 51, 138, 20);
        contentPane.add(ftfName);
        
        JButton btnDeleteRecipe = new JButton("Delete Recipe");
        btnDeleteRecipe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = ftfName.getText().trim();

                if (!searchText.isEmpty()) {
                    performDelete(searchText);
                } else {
                    // Handle empty deletion field if needed
                }
            }
        });
        btnDeleteRecipe.setBounds(225, 215, 129, 23);
        contentPane.add(btnDeleteRecipe);
        
        JLabel lblDeleteRecipe = new JLabel("Delete MilkTea Recipe");
        lblDeleteRecipe.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeleteRecipe.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDeleteRecipe.setBounds(90, 19, 174, 24);
        contentPane.add(lblDeleteRecipe);
        
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
        
        textArea = new JTextArea();
        textArea.setBounds(39, 77, 315, 128);
        contentPane.add(textArea);
        
        JButton Search = new JButton("Search");
        Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = ftfName.getText().trim();

                if (!searchText.isEmpty()) {
                    performSearch(searchText);
                } else {
                    // Handle empty search field if needed
                }
            }
        });
        Search.setBounds(258, 50, 96, 21);
        contentPane.add(Search);
    }

    // Method to perform the database search
    private void performSearch(String searchText) {
        String url = "jdbc:postgresql://localhost:5433/Coffee Recipes";
        String username = "postgres";
        String password = "Nacaytunajoshua99";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT recipe_id, title, measurements, steps FROM milktea WHERE recipe_id LIKE ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Use LIKE for text comparison
            pstmt.setString(1, "%" + searchText + "%");

            ResultSet resultSet = pstmt.executeQuery();

            textArea.setText(""); // Clear the text area before appending searched data

            // Displaying the search results in the textArea
            while (resultSet.next()) {
                int rIdData = resultSet.getInt("recipe_id");
                String titleData = resultSet.getString("title");
                String measurementsData = resultSet.getString("measurements");
                String stepsData = resultSet.getString("steps");

                textArea.append("Recipe ID: " + rIdData + ", Title: " + titleData + "\n");
                textArea.append("Measurements: " + measurementsData + "\n");
                textArea.append("Steps: " + stepsData + "\n\n");
            }

            resultSet.close();
            pstmt.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // Method to perform deletion
    private void performDelete(String searchText) {
        String url = "jdbc:postgresql://localhost:5433/Coffee Recipes";
        String username = "postgres";
        String password = "Nacaytunajoshua99";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "DELETE FROM milktea WHERE recipe_id LIKE ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Use LIKE for text comparison
            pstmt.setString(1, "%" + searchText + "%");

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                textArea.setText("Data deleted successfully.");
            } else {
                textArea.setText("No data matching the search.");
            }

            pstmt.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exceptions appropriately
        }
    
    }}