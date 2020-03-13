package PVC.Definitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Route {
    private ArrayList<City> cities=new ArrayList<>();
    private Tuple<Integer,Integer> transfert=new Tuple<>(0,0);
    public String toString(){
        return Arrays.toString(cities.toArray());
    }

    public Route(ArrayList<City> cities) {
        this.cities.addAll(cities);
        Collections.shuffle(this.cities);
    }
    public Route(Route route){
        this.cities.addAll(route.getCities());
        this.transfert=route.transfert;
    }
    public Route(Route route, int a, int b){
        this(route);
        this.cities.set(a,route.getCities().get(b));
        this.cities.set(b,route.getCities().get(a));
        this.transfert=new Tuple<>(a,b);
    }
    public ArrayList<City> getCities() {
        return cities;
    }

    public Tuple<Integer,Integer> getTransfert() {
        return transfert;
    }

    public double getTotalDistance(){
        double res=0;
        int citySize=this.cities.size();
        for (int pointer=0;pointer<citySize-1;pointer++){
            res+=this.cities.get(pointer).measureDistance(this.cities.get(pointer+1));
        }
        res+=this.cities.get(citySize-1).measureDistance(this.cities.get(0));
        return res;
    }
}
