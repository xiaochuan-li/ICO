package PVC.Algorithmes;

import PVC.Data.CityData;
import PVC.Definitions.Route;
import PVC.Definitions.Voisin;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;

public class Recuit extends Algorithme {

    public Recuit(Route actualRoute) {
        super(actualRoute);
    }

    public Recuit(Route actualRoute, int it) {
        super(actualRoute, it);
    }

    public static void main(String[] args) throws IOException, PythonExecutionException {
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
        return actualVoisin.getRandomRoute();
    }
}
