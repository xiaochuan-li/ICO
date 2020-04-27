package PVC;

import PVC.Algorithmes.GeneticAlgorithm;
import PVC.Algorithmes.Recuit;
import PVC.Algorithmes.Tabou;
import PVC.Data.CityData;
import PVC.Definitions.Route;

public class TestAlgo {
    public static void main(String[] args) {

        CityData Data = new CityData(50);
        Route initRoute = new Route(Data.getCities());

        Tabou t = new Tabou(initRoute, 1000);
        Recuit r = new Recuit(initRoute, 1000);
        GeneticAlgorithm g = new GeneticAlgorithm(initRoute, 1000);

        t.runtest();
        r.runtest();
        g.runtest();

        System.out.println(t.getResult());
        System.out.println(r.getResult());
        System.out.println(g.getResult());

    }
}
