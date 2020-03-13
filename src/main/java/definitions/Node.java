package definitions;

import java.util.ArrayList;

public class Node {
	/*
	 * @param r: debut plus tot
	 * @param t: debut
	 * @param p: dure
	 * @param c: fin
	 * @param d: fin plus tard
	 */
	final int MININT=0;
	final int MAXINT=255;
	public Node() {
		this.r = MININT;
		this.t = MININT;
		this.p = 0;
		this.c = MAXINT;
		this.d = MAXINT;
	}
	public Node(ArrayList<Node> predecesseurs) {
		this();
		this.setPredecesseurs(predecesseurs);
	}
	private int r;
	private int t;
	private int p;
	private int c;
	private int d;
	private boolean marked=false;
	private ArrayList<Node> predecesseurs=new ArrayList<Node>();
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public static void main(String[] args) {
		Node n=new Node(null);
		System.out.print(n.c);
	}
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	public ArrayList<Node> getPredecesseurs() {
		return predecesseurs;
	}
	public void setPredecesseurs(ArrayList<Node> predecesseurs) {
		this.predecesseurs = predecesseurs;
	}
}
