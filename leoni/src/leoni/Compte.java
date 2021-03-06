package leoni;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Compte {
	ImageIcon img;
	JFrame frame;
	JLabel l,l1,l2,l3,l4,label;
	JTextField t,t1,t2,t3;
	JButton addBtn,cancel, goToSearchFrame;
	Connection conn;
	PreparedStatement preparedStmt ;
        
        
	public Compte() {
		frame =new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		label=new JLabel();
		 Font newFont = new Font("Aharoni", Font.LAYOUT_NO_START_CONTEXT, 25);
		 Font alwan = new Font("Arial", Font.BOLD, 18);
		label.setIcon(new ImageIcon("C:\\Users\\lord\\Desktop\\plan.jpg"));
		l=new JLabel("Login");
		l.setFont(alwan);
		l.setForeground(Color.ORANGE);
		l1=new JLabel("Password:");
		l1.setFont(alwan);
		l1.setForeground(Color.ORANGE);
		l2=new JLabel("Nom");
		l2.setFont(alwan);
		l2.setForeground(Color.ORANGE);
		l3=new JLabel("Prenom");
		l3.setFont(alwan);
		l3.setForeground(Color.ORANGE);
		l4=new JLabel("Crieer un compte");
		l4.setFont(newFont);
		l4.setForeground(Color.WHITE);
		t=new JTextField();
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		addBtn= new JButton("Enregistre");
		addBtn.setForeground(Color.white);
		addBtn.setBackground(Color.GREEN);
		cancel=new JButton("Annuler");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.red);
                goToSearchFrame=new JButton("Gestion");
                goToSearchFrame.setForeground(Color.white);
                goToSearchFrame.setBackground(Color.pink);
		frame.add(label);
		label.setBounds(0, 0, 500, 400);
		addBtn.setBounds(120,250,100,40);
		cancel.setBounds(250,250,100,40);	
               		
	
		l.setBounds(20,5,100,100);
		l4.setBounds(150,-30,200,100);
		l1.setBounds(20,55,100,100);
		l2.setBounds(20,105,100,100);
		l3.setBounds(20,155,100,100);
		t.setBounds(150, 40, 200, 30);
		t1.setBounds(150, 90, 200, 30);
		t2.setBounds(150, 140, 200, 30);
		t3.setBounds(150, 190, 200, 30);
		label.add(t);
		label.add(t1);
		label.add(t2);
		label.add(t3);
		label.add(l);
		label.add(l1);
		label.add(l2);
		label.add(l3);
		label.add(l4);
		label.add(addBtn);        
		label.add(cancel);
		frame.setSize(500, 400);
		
		frame.setLayout(null);
		frame.setVisible(true);
		 
		addBtn.addActionListener(new AddNewOne());
        cancel.addActionListener(new Cancel());
               
	}
	 class AddNewOne implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
        try {  
		String Login=t.getText();
		String Password=t1.getText();
		String Nom=t2.getText();
		String Prenom=t3.getText();
		
                     
             System.out.println(Login+" "+ Password+ " "+Nom+ " "+ Prenom);
                     
             Class.forName("com.mysql.jdbc.Driver");  
                     
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leoni?useSSL=false","root", "");
                     
             String query = "INSERT INTO Compte(Login,Password,Nom,Prenom) VALUES(?,?,?,?)";
                     
		preparedStmt =conn.prepareStatement(query);
			
		preparedStmt.setString(1, Login);
		preparedStmt.setString(2, Password);
		preparedStmt.setString(3, Nom);
		preparedStmt.setString(4, Prenom);
                     
             preparedStmt.execute();
             
             
             System.out.println("compte est enregistrer ");
           
             conn.close();
		}catch (SQLException e2) {System.out.println("e"+e2);} 
             catch (Exception e1) {e1.printStackTrace();}
         }
     }
	 class Cancel implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           System.exit(0);
	        }
	    }
	public static void main(String[] args) {
        new Compte ();
}	
}
