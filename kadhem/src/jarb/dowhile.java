package jarb;

public class dowhile {
String ch;
int a;
String es;
dowhile  (String ch){ this.ch=ch; }
	public static void main(String[] args) {
		int a=0;
		String es=new String(" ");
		String ch=new String("m o t o o") ;
		for(int i=0;i<ch.length();i++)
		{if (ch.charAt(i)!=es.charAt(0))  {
		 a++;	}
		}
		
			
			System.out.println(a);
			
		}
		
	}


