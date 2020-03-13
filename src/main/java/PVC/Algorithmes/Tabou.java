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

public class Tabou {
    private Route bestRoute;
    private Route actualRoute;
    private ArrayList<Tuple<Integer, Integer>> T = new ArrayList<>();
    private int iter;
    private ArrayList<Line>lines=new ArrayList<>();

    public void run() throws IOException, PythonExecutionException {
        ArrayList<Double>logger=new ArrayList<>();
        while (this.iter-- > 0) {
            logger.add(this.bestRoute.getTotalDistance());
            Voisin actualVoisin = new Voisin(this.actualRoute);
            Route minRoute = actualVoisin.getMinRoute(this.T,this.actualRoute);
            this.actualRoute = minRoute;

            this.upgradeT(this.actualRoute.getTransfert());
            if (minRoute.getTotalDistance() < this.bestRoute.getTotalDistance()) {
                this.bestRoute = minRoute;
            }
        }
        this.lines.add(new Line(logger,"test"));
        
        Plot display=new Plot(this.lines);
        display.show();
    }

    public Tabou(Route actualRoute) {
        this.actualRoute = actualRoute;
        this.bestRoute = new Route(actualRoute);
        this.iter=100;
    }
    public Tabou(Route actualRoute, int it) {
        this(actualRoute);
        this.iter=it;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }

    private boolean checkT(Tuple<Integer, Integer> trans) {
        return T.contains(trans);
    }

    private void upgradeT(Tuple<Integer, Integer> trans) {
        if (T.size() > 5) {
            T.remove(0);
        }
        T.add(new Tuple<>(trans));
    }

    public static void main(String[] args) throws IOException, PythonExecutionException {
        CityData Data=new CityData(50);
        Route initRoute = new Route(Data.getCities());

        Tabou t = new Tabou(initRoute,1000);
        System.out.println(t.bestRoute);

        t.run();
        System.out.println(t.bestRoute);
        System.out.println(t.bestRoute.getTotalDistance());
    }
}
