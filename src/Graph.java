import java.util.*;

/**
 * Created by Milena on 13.12.2015.
 */
public class Graph {
    int[][] graph;
    int amountFull;
    int sizeNum;
    boolean appearance;


    private class Coordinates {
        private int i;
        private int j;

        public Coordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }


    ArrayList<Coordinates> unfilled;


    public Graph(int sizeNum, int prozent) {
        this.unfilled = new ArrayList<>();

        for (int i = 0; i < sizeNum; i++) {
            for (int j = 0; j < sizeNum; j++) {
                unfilled.add(new Coordinates(i, j));
            }
        }

        graph = new int[sizeNum][sizeNum];
        this.sizeNum = sizeNum;
        amountFull = (int) (((float) (sizeNum * sizeNum) / 100) * prozent);
        for (int i = 0; i < sizeNum; i++) {
            for (int j = 0; j < sizeNum; j++) {
                graph[i][j] = 0;
            }
        }
        makeGraph();
        defineAppearance();
    }

    private void makeGraph() {
        Random rand = new Random();
        int candidate;
        for (int i = 0; i < amountFull; i++) {
            Coordinates candidateCoord;
            candidate = rand.nextInt(unfilled.size());
            candidateCoord = unfilled.get(candidate);
            graph[candidateCoord.getI()][candidateCoord.getJ()] = 1;
            unfilled.remove(candidateCoord);
        }
    }

    public void defineAppearance() {
        int[] columni;
        int[] columnj;
        columni = new int[sizeNum];
        columnj =new int [sizeNum];
        for (int i = 0; i < sizeNum; i++) {
            columnj[i] = 0;
            for (int j = 0; j < sizeNum; j++) {
                columnj[i] = columnj[i]+graph[i][j];
            }
        }

        for (int j = 0; j < sizeNum; j++) {
            columni[j] = 0;
            for (int i = 0; i < sizeNum; i++) {
                columni[j] = columni[j]+graph[i][j];
            }
        }

        for (int i = 0; i < sizeNum ; i++) {
            if ((columnj[i]==1)||(columni[i]==1)){
                appearance = true;
                break;
            }
        }
    }

    public boolean isAppearance() {
        return appearance;
    }

    public void show() {
        for (int i = 0; i < sizeNum; i++) {
            for (int j = 0; j < sizeNum; j++) {
                System.out.print(graph[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }
}
