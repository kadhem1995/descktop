package formation;

public class Simplecalc {
	private int x;
	private int y;
	public Simplecalc(){
		this.x=0;
		this.y=0;
	}
	public Simplecalc(int a,int b) {
		this.x=a;
		this.y=b;
		
	}
public int Add() {
	return this.x + this.y;
}
public int Sub() {
	return this.x-this.y;
}
public void setx(int i) {
	this.x=i;
	
}
public void sety(int i) {
	this.y=i;
}
public int getx() {
	return this.x;
}
public int gety() {
	return this.y;
}
}
