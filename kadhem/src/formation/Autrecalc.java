package formation;

public class Autrecalc extends Simplecalc {
	public Autrecalc(int a,int b) {
		super(a,b);
	}
	public int Mul() {
		return this.getx() * this.gety();
	}
	public int Div() {
		int y=gety();
		if(y==0) {
			return 0;
		}
		return this.getx()/ y;
	}

}
