package operations;

import definitions.Node;

import java.util.ArrayList;

public class Bellman {
    public Bellman(ArrayList<Node> nodeList) {
        super();
        setNodeList(nodeList);
    }

    public ArrayList<Node> getNodeList() {
        return NodeList;
    }

    public void setNodeList(ArrayList<Node> nodeList) {
        NodeList = nodeList;
    }

    private ArrayList<Node> NodeList;
    private ArrayList<Node> result = new ArrayList<Node>();

    public void Manage() {
        ArrayList<Node> NonMarked = this.NodeList;
        ArrayList<Node> Marked = new ArrayList<Node>();
        while (NonMarked.size() != 0) {
            Node target = null;
            for (Node n : NonMarked) {
                if (isAllMarked(n.getPredecesseurs(), Marked)) {
                    target = n;
                    break;
                }
                System.out.println("Circles");
                System.exit(0);
            }
			target.setR(maxR(target.getPredecesseurs()));
			//target.setD(target.getR()+target.getP());
			for (Node n : target.getPredecesseurs()) {
				int fin = Math.min(n.getD(), target.getR());
				n.setD(fin);
			}
			Marked.add(target);
			NonMarked.remove(target);
		}
        int fin = maxR(Marked);
        for (Node n : Marked) {
            int cf = Math.min(fin, n.getD());
            n.setD(cf);
        }
        this.setResult(Marked);
    }

    public int maxR(ArrayList<Node> temp) {
        int res = 0;
        for (Node n : temp) {
            res = Math.max(res, (n.getR() + n.getP()));
        }
        return res;
    }

    public boolean isAllMarked(ArrayList<Node> temps, ArrayList<Node> M) {
        try {
            return M.containsAll(temps);
        } catch (NullPointerException e) {
            System.out.print("Error pointer");
            System.exit(0);
            return false;
        }
    }

    public ArrayList<Node> getResult() {
        return result;
    }

    public void setResult(ArrayList<Node> result) {
        this.result = result;
    }

    /*
     * --------------------------------
     * number	|	p	|	precedent
     * --------------------------------
     * 	0		|	1	|	null
     * --------------------------------
     * 	1		|	2	|	null
     * --------------------------------
     * 	2		|	2	|	0
     * --------------------------------
     * 	3		|	3	|	0,1
     * --------------------------------
     * 	4		|	2	|	1,2
     * --------------------------------
     * 	5		|	3	|	0,3
     * --------------------------------

     */
    public static ArrayList<Node> generate() {
        ArrayList<Node> res = new ArrayList<Node>();
        int[] p = {1, 2, 2, 3, 2, 3};
        int[][] pre = {{}, {}, {0}, {0, 1}, {1, 2}, {0, 3}};
        for (int i = 0; i < 6; i++) {
            res.add(new Node());
        }
        for (int i = 0; i < 6; i++) {
            res.get(i).setP(p[i]);
            ArrayList<Node> pre1 = new ArrayList<Node>();
            for (int j : pre[i]) {
                pre1.add(res.get(j));
            }
            res.get(i).setPredecesseurs(pre1);
        }
        return res;
    }

    public static String center(String input, int len) {
        if (input.length() >= len) {
            return input;
        } else {
            int prefix = (len - input.length()) / 2;
            while (prefix-- > 0) {
                input = " " + (input += " ");

            }
            return input;
        }
    }

    public static String center(int input_int, int len) {
        String input = String.format("%d", input_int);
        return center(input,len);
    }

    public static void main(String[] args) {
        Bellman b = new Bellman(generate());
        b.Manage();
        System.out.println("start--duree--fin");
        for (Node n : b.getResult()) {
            System.out.println(center(n.getR(), 5) + "--" + center(n.getP(), 5) + "--" + center(n.getD(), 5));
        }
    }


}
