package project;


import java.awt.Color;
import java.awt.Component;
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

import com.sun.prism.Image;

public class Electeur extends JFrame{
	ImageIcon img;
	JFrame frame;
	JLabel l,l1,l2,l3,l4,label;
	JTextField t,t1,t2,t3;
	JButton addBtn,cancel, goToSearchFrame;
	Connection conn;
	PreparedStatement preparedStmt ;
        
        
	public Electeur() {
		frame =new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		label=new JLabel();
		label.setIcon(new ImageIcon("C:\\Users\\lord\\Desktop\\177-5.jpg"));
		l=new JLabel("CIN:");
		l1=new JLabel("nom prenom:");
		l2=new JLabel("ville:");
		l3=new JLabel("beraux:");
		l4=new JLabel("Bienvenue  l lection 2019");
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
		addBtn.setBounds(20,300,100,40);
		cancel.setBounds(160,300,100,40);	
                goToSearchFrame.setBounds(300,300,100,40);		
	
		l.setBounds(20,5,100,100);
		l4.setBounds(150,-30,200,100);
		l1.setBounds(20,55,100,100);
		l2.setBounds(20,105,100,100);
		l3.setBounds(20,155,100,100);
		t.setBounds(100, 40, 200, 30);
		t1.setBounds(100, 90, 200, 30);
		t2.setBounds(100, 140, 200, 30);
		t3.setBounds(100, 190, 200, 30);
		frame.add(t);
		frame.add(t1);
		frame.add(t2);
		frame.add(t3);
		label.add(l);
		label.add(l1);
		label.add(l2);
		label.add(l3);
		label.add(l4);
		label.add(addBtn);
                label.add(goToSearchFrame);
		label.add(cancel);
		frame.setSize(500, 400);
		
		frame.setLayout(null);
		frame.setVisible(true);
		 
		addBtn.addActionListener(new AddNewOne());
                cancel.addActionListener(new Cancel());
                goToSearchFrame.addActionListener(new GotoSearchFrame());
	}
    
        class AddNewOne implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
           try {  
		String cin=t.getText();
		String nom=t1.getText();
		String ville=t2.getText();
		String beraux=t3.getText();
                        
                System.out.println(cin+" "+ nom+ " "+ ville+ " "+ beraux);
                        
                Class.forName("com.mysql.jdbc.Driver");  
                        
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inscription?useSSL=false","root", "");
                        
                String query = "INSERT INTO electeur(CIN,nom,ville,beraux) VALUES(?,?,?,?)";
                        
		preparedStmt =conn.prepareStatement(query);
			
		preparedStmt.setString(1, cin);
		preparedStmt.setString(2, nom);
		preparedStmt.setString(3, ville);
		preparedStmt.setString(4, beraux);
                        
                preparedStmt.execute();
                
                System.out.println("l'electeur est enregistrer ");
              
                conn.close();
		}catch (SQLException e2) {System.out.println("e"+e2);} 
                catch (Exception e1) {e1.printStackTrace();}
            }
        }
        
        class GotoSearchFrame implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame newframe = new Rechercher();
                newframe.setVisible(true);
            }
        }
        
        class Cancel implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        }

	public static void main(String[] args) {
            new Electeur();
	}

	

}

