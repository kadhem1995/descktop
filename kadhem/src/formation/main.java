package formation;

public class main {

	public static void main(String[] args) {
		Autrecalc calc=new Autrecalc(7,5);
		int r=calc.Sub();
		System.out.println(r);
		calc.setx(5);
		calc.sety(4);
		r=calc.Add();
		System.out.println(r);
		r=calc.Sub();
		System.out.println(r);
		r=calc.Mul();
		System.out.println(r);
		r=calc.Div();
		System.out.println(r);
	
	
		
		
		 

	}

	
	

}
