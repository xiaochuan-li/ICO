package operations;

import definitions.Tache;

import java.util.ArrayList;


public class Johnson1 {
    final int MAXINT = 255;
    private ArrayList<Tache> taches;
    private ArrayList<Tache> result;

    public Johnson1(ArrayList<Tache> taches) {
        super();
        this.taches = taches;
        this.result = new ArrayList<>();
        for (int i = 0; i < taches.size(); i++) {
            this.result.add(null);
        }
    }

    public static void main(String[] args) {
        int[][] data = {{3, 6}, {5, 2}, {1, 2}, {6, 6}, {7, 5}};
        ArrayList<Tache> taches = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            taches.add(new Tache(data[i][0], data[i][1]));
        }
        Johnson1 j = new Johnson1(taches);
        j.Manage();
        for (Tache t : j.getResult()) {
            System.out.println("p1=" + (t.getP1()) + ",p2=" + (t.getP2()));
        }
    }

    public ArrayList<Tache> getResult() {
        return result;
    }

    public Tache min(ArrayList<Tache> temp) {
        Tache value = new Tache(MAXINT, MAXINT);
        for (Tache t : temp) {
            value = value.min() > t.min() ? t : value;
        }
        return value;
    }

    public void Manage() {
        ArrayList<Tache> temps = this.taches;
        int p = 0;
        int r = temps.size() - 1;
        while (!temps.isEmpty()) {
            Tache value = min(temps);
            if (value.P1infP2()) this.result.set(p++, value);
            else this.result.set(r--, value);
            temps.remove(value);
        }
    }
}
