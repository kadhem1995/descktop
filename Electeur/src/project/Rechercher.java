package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Rechercher extends JFrame{
	
	JButton searchBtn,deleteBtn;
	JTextField searchTextInput,deleteTextInput;
        
	Connection conn;
	PreparedStatement preparedStmt ;
        
	public Rechercher() {
		super("Electeur");
		searchBtn=new JButton("Recherche");
		searchBtn.setBackground(Color.PINK);
		searchTextInput=new JTextField();
		searchBtn.setBounds(30, 100, 100, 40);
		searchTextInput.setBounds(135, 106, 225, 30);
		deleteBtn=new JButton("Spprimer");
		deleteBtn.setBackground(Color.red);
		deleteTextInput=new JTextField();
		deleteBtn.setBounds(30, 200, 100, 40);
		deleteTextInput.setBounds(135, 206, 225, 30);
		this.add(searchBtn);
		this.add(deleteBtn);
		this.add(searchTextInput);
		this.add(deleteTextInput);
		this.setSize(400, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.CYAN);
                
                searchBtn.addActionListener(new Search());                
                deleteBtn.addActionListener(new Delete());
	}
        
       
        class Search implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                try{
                    //Connection to database
                    
                     Class.forName("com.mysql.jdbc.Driver");  

                     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inscription?useSSL=false","root", "");
                     
                     //Send request 
                     Statement  stmt =  conn.createStatement();
                     //Get response from the server
                     
                     ResultSet rs=stmt.executeQuery("select * from electeur where cin ="+searchTextInput.getText());  
                     
                     //Read respinse
                     while(rs.next())
                         
                     System.out.println("le CIN de "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                     
                     conn.close();  
                     
                 }catch(ClassNotFoundException | SQLException ex){ System.out.println(ex);}     
            }
        }

        
       class Delete implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                try{  
                    
                    Class.forName("com.mysql.jdbc.Driver");  

                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inscription?useSSL=false","root", "");
                     
                    String query = "delete from electeur where cin = ?";

                    String cin = deleteTextInput.getText(); //get data from input

                    preparedStmt = conn.prepareStatement(query); // my query 

                    preparedStmt.setString(1,cin); 
                    
                    preparedStmt.execute(); //Execute my query (Delete record from database
                    
                    deleteTextInput.setText(""); // Delete data in deleteTextInput field
                    
                    System.out.println("le electeur est supprimer !!"); 

                    conn.close();
                    
                }catch(SQLException ex){ System.out.println(ex);} catch (ClassNotFoundException ex) {
                    
                    Logger.getLogger(Rechercher.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        }

        public static void main(String[] args) {
            new Rechercher();
	}

}
