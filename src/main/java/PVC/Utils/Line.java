package PVC.Utils;

import java.util.ArrayList;

public class Line {
    private ArrayList<Double> target=new ArrayList<>();
    private String label="label";

    public String getLabel() {
        return label;
    }

    public ArrayList<Double> getTarget() {
        return target;
    }

    public Line(ArrayList<Double> target, String label) {
        this.target = target;
        this.label = label;
    }

}
