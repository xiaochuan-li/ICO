package PVC.Definitions;

import java.util.ArrayList;

public class Voisin {
    private ArrayList<Route> voisins=new ArrayList<>();
    public Voisin(Route r){
        int citySize=r.getCities().size();
        for(int i=0;i<citySize;i++){
            for(int j=i+1;j<citySize;j++){
                this.voisins.add(new Route(r,i,j));
            }
        }
    }
    public Route getMinRoute(ArrayList<Tuple<Integer,Integer>> T, Route actualRoute){
        Route minRoute=new Route(this.voisins.get(0));
        for(Route r:this.voisins){
            if(r.getTotalDistance()<minRoute.getTotalDistance() && (!T.contains(r.getTransfert()) || A(actualRoute,r))){
                minRoute=new Route(r);
            }
        }
        return minRoute;
    }
    public boolean A(Route actualRoute, Route candidate){
        double coe=0.8;
        return candidate.getTotalDistance()<=coe*actualRoute.getTotalDistance();
    }

}
