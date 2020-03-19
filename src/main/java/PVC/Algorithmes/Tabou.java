package PVC.Algorithmes;

import PVC.Data.CityData;
import PVC.Definitions.City;
import PVC.Definitions.Route;
import PVC.Definitions.Voisin;

import java.util.ArrayList;

public class Tabou extends Algorithme {
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
        CityData Data = new CityData(50);
        Route initRoute = new Route(Data.getCities());

        Tabou t = new Tabou(initRoute, 1000);
        System.out.println(t.getBestRoute());

        t.run();
        System.out.println(t.getBestRoute());
        System.out.println(t.getBestRoute().getTotalDistance());
    }

    private Route getMinRoute() {
        Voisin actualVoisin = new Voisin(this.getActualRoute());
        return actualVoisin.getMinRoute(this.getT(), this.getActualRoute());
    }
}
