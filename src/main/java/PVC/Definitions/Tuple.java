package PVC.Definitions;

public class Tuple <A,B>{
    public final A first;
    public final B second;

    public Tuple(A a, B b) {
        this.first = a;
        this.second = b;
    }
    public Tuple(Tuple<Integer,Integer> t){
        this.first=(A) t.second;
        this.second=(B)t.first;
    }
}
