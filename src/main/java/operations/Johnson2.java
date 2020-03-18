package operations;

import definitions.Tache;

import java.util.ArrayList;
import java.util.Comparator;

public class Johnson2 {
	private ArrayList<Tache> U = new ArrayList<>();
	private ArrayList<Tache> V = new ArrayList<>();
	private ArrayList<Tache> taches;
	private ArrayList<Tache> result;

	public Johnson2(ArrayList<Tache> taches) {
		super();
		this.taches = taches;
		this.result = new ArrayList<>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = {{3, 6}, {5, 2}, {1, 2}, {6, 6}, {7, 5}};
		ArrayList<Tache> taches = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			taches.add(new Tache(data[i][0], data[i][1]));
		}
		Johnson2 j = new Johnson2(taches);
		j.Manage();
		for (Tache t : j.getResult()) {
			System.out.println("p1=" + (t.getP1()) + ",p2=" + (t.getP2()));
		}

	}

	public ArrayList<Tache> getResult() {
		return result;
	}

	private void Manage() {
		for (Tache t : this.taches) {
			if (t.P1infP2()) this.U.add(t);
			else this.V.add(t);
		}
		this.U.sort(Comparator.comparingInt(Tache::getP1));
		this.V.sort((arg0, arg1) -> {
			// TODO Auto-generated method stub
			return arg1.getP2() - arg0.getP2();
		});
		this.result.addAll(U);
		this.result.addAll(V);
	}

}
