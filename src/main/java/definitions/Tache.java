package definitions;

public class Tache {
	public Tache(int p1, int p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	private int p1;
	private int p2;
	public int getP1() {
		return p1;
	}
	public void setP1(int p1) {
		this.p1 = p1;
	}
	public int getP2() {
		return p2;
	}
	public void setP2(int p2) {
		this.p2 = p2;
	}
	public int min() {
		return this.p1<this.p2? p1:p2;
		
	}
	public boolean P1infP2() {
		return this.p1<this.p2;
	}
}
