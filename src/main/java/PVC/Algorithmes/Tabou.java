package PVC.Algorithmes;

import PVC.Data.CityData;
import PVC.Definitions.City;
import PVC.Definitions.Route;
import PVC.Definitions.Tuple;
import PVC.Definitions.Voisin;

import java.util.ArrayList;

public class Tabou extends Algorithme {
    private ArrayList<Tuple<Integer, Integer>> T = new ArrayList<>();
    public Tabou(Route actualRoute) {
        super(actualRoute);
    }

    public Tabou(ArrayList<City> cities) {
        super(new Route(cities));
    }

    public Tabou(Route actualRoute, int it) {
        super(actualRoute, it);
    }

    public static void main(String[] args) {
        CityData Data = new CityData(30);
        Route initRoute = new Route(Data.getCities());

        Tabou t = new Tabou(initRoute, 100);
        System.out.println(t.getBestRoute());

        t.runtest();
        System.out.println(t.getBestRoute());
        System.out.println(t.getBestRoute().getTotalDistance());


        Recuit r = new Recuit(initRoute, 100, 10.0, 0.5);
        System.out.println(r.getBestRoute());

        r.runtest();
        System.out.println("The Best Route: " + r.getBestRoute());
        System.out.println("Min Distance : " + r.getBestRoute().getTotalDistance());
    }

    @Override
    public void runtest() {
        ArrayList<Double> logger = new ArrayList<>();

        while (this.iter-- > 0) {
            //System.out.println(this.iter);
            //logger.add(this.bestRoute.getTotalDistance());
            this.actualRoute = this.getMinRoute();
            this.upgradeT(this.actualRoute.getTransfert());
            if (this.actualRoute.getTotalDistance() < this.bestRoute.getTotalDistance()) {
                this.bestRoute = this.actualRoute;
            }
        }
    }

    protected void upgradeT(Tuple<Integer, Integer> trans) {
        if (T.size() > 5) {
            T.remove(0);
        }
        T.add(new Tuple<>(trans));
    }

    private Route getMinRoute() {
        Voisin actualVoisin = new Voisin(this.getActualRoute());
        return actualVoisin.getMinRoute(this.getT(), this.getActualRoute());
    }

    public ArrayList<Tuple<Integer, Integer>> getT() {
        return T;
    }
}
