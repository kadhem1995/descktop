import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	JFrame frame;
	JLabel l;
	JButton b,b1;
	Main(){
		frame=new JFrame();
		l=new JLabel("CIN");
		b=new JButton("kadhem");
		b.setBounds(100, 100, 100, 100);
		l.setBounds(50, 100, 100, 100);
		frame.add(l);
		frame.add(b);
		frame.setSize(400, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.GRAY);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Main();
	}

}
