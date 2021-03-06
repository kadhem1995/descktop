package jarb;
import java.util.Scanner;
public class test {
static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
		int a;
		System.out.println("donner le premioer nombre");
		a=reader.nextInt();
		
		int b;
		System.out.println("donner le duxeme nombre");
		b=reader.nextInt();
		
		int s=a+b;
		int m=a-b;
		int f=a*b;
		double d=a/b;
		System.out.println("le resultat pour plus est "+s);
		System.out.println("le resultat pour moin est "+m);
		System.out.println("le resultat pour fois est "+f);
		System.out.println("le resultat pour div est "+d);
	}

}
