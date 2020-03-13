package PVC.Utils;

import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Plot {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ArrayList<Line> lines=new ArrayList<>();
    private String xlabel="X";
    private String ylabel="Y";
    private String title="title";

    public Plot(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public Plot(ArrayList<Line> lines, String xlabel, String ylabel, String title) {
        this.lines=lines;
        this.xlabel = xlabel;
        this.ylabel = ylabel;
        this.title = title;
    }

    public void show() throws IOException, PythonExecutionException {
        com.github.sh0nk.matplotlib4j.Plot plt= com.github.sh0nk.matplotlib4j.Plot.create();
        for(Line l:this.lines){
        plt.plot()
                .add(l.getTarget())
                .label(l.getLabel());}
        plt.xlabel(this.xlabel);
        plt.ylabel(this.ylabel);
        plt.text(0.5, 0.2, "text");
        plt.title(this.title);
        plt.legend();
        plt.show();
    }
}