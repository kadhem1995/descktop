package leoni;

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

public class Gestien extends JFrame{
	
	JButton searchBtn,deleteBtn,back;
	JTextField searchTextInput,deleteTextInput;
    JFrame frame;    
	Connection conn;
	PreparedStatement preparedStmt ;
        
	public Gestien () {
		frame =new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		searchBtn=new JButton("Recherche");
		back=new JButton("Back");
		searchBtn.setBackground(Color.PINK);
		searchTextInput=new JTextField();
		searchBtn.setBounds(30, 100, 100, 40);
		searchTextInput.setBounds(135, 106, 225, 30);
		deleteBtn=new JButton("Spprimer");
		deleteBtn.setBackground(Color.red);
		deleteTextInput=new JTextField();
		deleteBtn.setBounds(30, 200, 100, 40);
		deleteTextInput.setBounds(135, 206, 225, 30);
		back.setBounds(200, 250, 100, 30);
		frame.add(searchBtn);
		frame.add(deleteBtn);
		frame.add(back);
		frame.add(searchTextInput);
		frame.add(deleteTextInput);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setSize(500, 400);
		
		frame.setLayout(null);
		frame.setVisible(true);
                
                searchBtn.addActionListener(new Search());                
                deleteBtn.addActionListener(new Delete());
                back.addActionListener(new Back());
	}
        
     
        class Search implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                try{
                    //Connection to database
                    
                     Class.forName("com.mysql.jdbc.Driver");  

                     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leoni?useSSL=false","root", "");
                     
                     //Send request 
                     Statement  stmt =  conn.createStatement();
                     //Get response from the server
                     
                     ResultSet rs=stmt.executeQuery("select * from client where Num ="+searchTextInput.getText());  
                     
                     //Read respinse
                     while(rs.next())
                         
                     System.out.println("le Num de "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                     
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

                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leoni?useSSL=false","root", "");
                     
                    String query = "delete from client where Num = ?";

                    String Num = deleteTextInput.getText(); //get data from input

                    preparedStmt = conn.prepareStatement(query); // my query 

                    preparedStmt.setString(1,Num); 
                    
                    preparedStmt.execute(); //Execute my query (Delete record from database
                    
                    deleteTextInput.setText(""); // Delete data in deleteTextInput field
                    
                    System.out.println("le Client est supprimer !!"); 

                    conn.close();
                    
                }catch(SQLException ex){ System.out.println(ex);} catch (ClassNotFoundException ex) {
                    
                    Logger.getLogger(Gestien.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        }
       class Back  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		JFrame newframe = new client();
		newframe.setVisible(false);
			
		}

		
	    	  
	      }

        public static void main(String[] args) {
            new Gestien();
	}

}


