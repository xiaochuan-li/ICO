package operations;

import definitions.Tache;

import java.util.ArrayList;
import java.util.Comparator;

public class Johnson2 {
	private ArrayList<Tache>U=new ArrayList<Tache>();
	private ArrayList<Tache>V=new ArrayList<Tache>();
	public Johnson2(ArrayList<Tache> taches) {
		super();
		this.taches = taches;
		this.result=new ArrayList<Tache>();
	}
	private ArrayList<Tache> taches;
	private ArrayList<Tache> result;;
	public ArrayList<Tache> getResult() {
		return result;
	}
	private void Manage() {
		for(Tache t:this.taches) {
			if(t.P1infP2()) this.U.add(t);
			else this.V.add(t);
		}
		this.U.sort(new Comparator<Tache>() {

			@Override
			public int compare(Tache arg0, Tache arg1) {
				// TODO Auto-generated method stub
				return arg0.getP1()-arg1.getP1();
			}			
		});
		this.V.sort(new Comparator<Tache>() {

			@Override
			public int compare(Tache arg0, Tache arg1) {
				// TODO Auto-generated method stub
				return arg1.getP2()-arg0.getP2();
			}			
		});
		this.result.addAll(U);
		this.result.addAll(V);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] data= {{3,6},{5,2},{1,2},{6,6},{7,5}};
		ArrayList<Tache> taches = new ArrayList<Tache>();
		for(int i=0;i<5;i++) {
			taches.add(new Tache(data[i][0],data[i][1]));
		}
		Johnson2 j=new Johnson2(taches);
		j.Manage();
		for(Tache t:j.getResult()) {
			System.out.println("p1="+(t.getP1())+",p2="+(t.getP2()));
		}

	}

}
