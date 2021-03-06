package leoni;

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


public class client extends JFrame{
	ImageIcon img;
	JFrame frame,fr;
	JLabel l4,l3,l,l1,l2;
	JTextField t,t1,t2,t3,t4,t5;
	JButton addBtn,cancel, goToSearchFrame;
	Connection conn;
	PreparedStatement preparedStmt ;
        
        
	public client () {
		frame =new JFrame();
		fr =new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		fr.getContentPane().setBackground(Color.CYAN);
		l=new JLabel("Num:");
		l1=new JLabel("nom :");
		l2=new JLabel("prenom:");
		l3=new JLabel("adresse_MC");
		l4=new JLabel("marque");
	
		t=new JTextField();
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		addBtn= new JButton("Enregistre");
		addBtn.setForeground(Color.white);
		addBtn.setBackground(Color.GREEN);
		cancel=new JButton("Annuler");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.red);
                goToSearchFrame=new JButton("Gestion");
                goToSearchFrame.setForeground(Color.white);
                goToSearchFrame.setBackground(Color.pink);
		
	
		addBtn.setBounds(20,300,100,40);
		cancel.setBounds(160,300,100,40);	
                goToSearchFrame.setBounds(300,300,100,40);		
	
		l.setBounds(20,5,100,100);
		l4.setBounds(150,-30,200,100);
		l1.setBounds(20,55,100,100);
		
		l2.setBounds(20,105,100,100);
		l3.setBounds(20,155,100,100);
		l4.setBounds(20,240,100,30);
		t.setBounds(100, 40, 200, 30);
		t1.setBounds(100, 90, 200, 30);
		t2.setBounds(100, 140, 200, 30);
		t3.setBounds(100, 190, 200, 30);
		t4.setBounds(100,240,200,30);
		frame.add(t);
		frame.add(t1);
		frame.add(t2);
		frame.add(t3);
		frame.add(t4);
		frame.add(l);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		
		frame.add(addBtn);
                frame.add(goToSearchFrame);
		frame.add(cancel);
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
		String Num=t.getText();
		String Nom=t1.getText();
		String Prenom=t2.getText();
		String adresse_Mc=t3.getText();
		String marque=t4.getText();
                        
                System.out.println(Num+" "+ Nom+ " "+Prenom+ " "+ adresse_Mc+" "+marque);
                        
                Class.forName("com.mysql.jdbc.Driver");  
                        
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leoni?useSSL=false","root", "");
                        
                String query = "INSERT INTO client(Num,Nom,Prenom,adresse_Mc,marque) VALUES(?,?,?,?,?)";
                        
		preparedStmt =conn.prepareStatement(query);
			
		preparedStmt.setString(1, Num);
		preparedStmt.setString(2, Nom);
		preparedStmt.setString(3, Prenom);
		preparedStmt.setString(4, adresse_Mc);
		preparedStmt.setString(5, marque);
                        
                preparedStmt.execute();
                
                
                System.out.println("Client est enregistrer ");
              
                conn.close();
		}catch (SQLException e2) {System.out.println("e"+e2);} 
                catch (Exception e1) {e1.printStackTrace();}
            }
        }
        
        class GotoSearchFrame implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame newframe = new Gestien();
                newframe.setVisible(false);
            }
        }
        
        class Cancel implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        }

	public static void main(String[] args) {
            new client ();
	}

	

}


