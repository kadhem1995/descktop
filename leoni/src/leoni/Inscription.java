package leoni;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import leoni.client.GotoSearchFrame;


public class Inscription extends JFrame  {
	ImageIcon img;
	JFrame f,f1 ;
	JLabel l,l1,l2,im;
	JTextField t,t1;
	JButton b,b1,b2;
	Connection conn;
	PreparedStatement preparedStmt ;
	public Object db;
	public Inscription() {
		 Font newFont = new Font("Aharoni", Font.LAYOUT_NO_START_CONTEXT, 40);
		 Font alwan = new Font("Arial", Font.BOLD, 18);
		f=new JFrame();
		b=new JButton("Connexion");
		b.setForeground(Color.white);
		b.setBackground(Color.BLACK);
		b1=new JButton("Criéer un compte");
		b1.setForeground(Color.white);
		b1.setBackground(Color.GREEN);
		b2=new JButton("Annuler");
		b2.setForeground(Color.black);
		b2.setBackground(Color.WHITE);
		t= new JTextField();
		t1= new JTextField();
		im=new JLabel();
		l=new JLabel("Inscription");
		l.setFont(newFont);
		l.setForeground(Color.WHITE);
		l1=new JLabel("Login        :");
		l1.setFont(alwan);
		l1.setForeground(Color.ORANGE);
		l2=new JLabel("Password ;");
		l2.setFont(alwan);
		l2.setForeground(Color.YELLOW);
		im.setIcon(new ImageIcon("C:\\Users\\lord\\Desktop\\background.jpg"));
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500, 400);
		f.add(im);
		im.add(l);
		im.add(l1);
		im.add(l2);
		im.add(t);
		im.add(t1);
		im.add(b);
		im.add(b1);
		im.add(b2);
		im.setBounds(0, 0, 500, 400);
		b.setBounds(100, 200, 100, 40);
		b2.setBounds(250, 200, 100, 40);
		b1.setBounds(150, 260, 150, 40);
		l.setBounds(170, 0, 200, 50);
		l1.setBounds(50, 70, 100, 55);
		t.setBounds(150, 80, 200, 30);
		t1.setBounds(150, 130, 200, 30);
		l2.setBounds(50, 100, 100, 100);
		 b.addActionListener(new GotoSearchFrame());
		 b2.addActionListener(new Cancel());
		 b1.addActionListener(new compte());
	}
	class GotoSearchFrame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	try {
        		String Login=t.getText();
        		String Password=t1.getText();
        		 System.out.println(Login+" "+ Password);
        		 
                 Class.forName("com.mysql.jdbc.Driver");  
                         
                 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leoni?useSSL=false","root", "");
                 Statement  stmt =  conn.createStatement();
                         
                 ResultSet rs=stmt.executeQuery("select Login,Password from Compte where Login=" +Login+ " and "+ "Password=" +Password );
                 if(rs.next()) {
                	 f.setVisible(false);
             		JFrame newframe = new client();
             		newframe.setVisible(false);
                 }
                  
                
        	}catch(ClassNotFoundException | SQLException ex){  JOptionPane.showMessageDialog(null, "Username or Password invalide", "Information Message", JOptionPane.INFORMATION_MESSAGE);} 
           
        
        			
            
	}
	}    
    
	class compte implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	 Compte frame = new Compte();
        	 f.setVisible(false);
             
        }
    }
	class Cancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
    }
	
	public static void main(String[] args) {
        new Inscription ();
}
}

