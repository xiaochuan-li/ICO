package PVC.Algorithmes;

import PVC.Data.CityData;
import PVC.Definitions.Route;
import PVC.Definitions.Tuple;
import PVC.Definitions.Voisin;
import PVC.Utils.Line;
import PVC.Utils.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Algorithme {
    private int iter;
    private Route bestRoute;
    private Route actualRoute;
    private ArrayList<Tuple<Integer, Integer>> T = new ArrayList<>();
    private ArrayList<Line> lines = new ArrayList<>();

    public Algorithme(Route actualRoute) {
        this.actualRoute = actualRoute;
        this.bestRoute = new Route(actualRoute);
        this.iter = 100;
    }

    public Algorithme(Route actualRoute, int it) {
        this(actualRoute);
        this.iter = it;
    }

    public static void main(String[] args) throws IOException, PythonExecutionException {
        CityData Data = new CityData(50);
        Route initRoute = new Route(Data.getCities());
    }

    public void run() throws IOException, PythonExecutionException {
        ArrayList<Double> logger = new ArrayList<>();

        while (this.iter-- > 0) {
            logger.add(this.bestRoute.getTotalDistance());
            this.actualRoute = this.getMinRoute();
            this.upgradeT(this.actualRoute.getTransfert());
            if (this.actualRoute.getTotalDistance() < this.bestRoute.getTotalDistance()) {
                this.bestRoute = this.actualRoute;
            }
        }
        this.lines.add(new Line(logger, "test"));
        Plot display = new Plot(this.lines, "iterations", "distance", "Tabou");
        display.show();
    }

    private Route getMinRoute() {
        Voisin actualVoisin = new Voisin(this.actualRoute);
        return actualVoisin.getMinRoute(this.T, this.actualRoute);
    }

    public Route getActualRoute() {
        return actualRoute;
    }

    public ArrayList<Tuple<Integer, Integer>> getT() {
        return T;
    }

    public Route getBestRoute() {
        return bestRoute;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }

    private void upgradeT(Tuple<Integer, Integer> trans) {
        if (T.size() > 5) {
            T.remove(0);
        }
        T.add(new Tuple<>(trans));
    }
}
