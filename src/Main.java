import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, Integer> sizes;
    private static int amountEffort =200;

    public static void main(String[] args) {
        sizes = new HashMap<Integer, Integer>();
        sizes.put(1,10);
        sizes.put(2,15);
        sizes.put(3,20);
        sizes.put(4,25);
        sizes.put(5,0);


        int sizeNum;
        while (true) {
            System.out.println("Enter matrix size:");
            System.out.println("10x10: 1");
            System.out.println("15x15: 2");
            System.out.println("20x20: 3");
            System.out.println("25x25: 4");
            System.out.println("30x30: 5");
            Scanner in = new Scanner(System.in);

            sizeNum = in.nextInt();
            if (!sizes.containsKey(sizeNum)) {
                System.out.println("Error in entered size. Please enter one more time");
            }else {
                break;
            }
        }
        for (int i=1;i<=100;i++){
            int amountAppearance =0;
            for (int j = 0; j < amountEffort ; j++) {
                Graph graph = new Graph(sizes.get(sizeNum), i);
                //graph.show();
                if (graph.isAppearance()){
                    amountAppearance++;
                }
            }
            System.out.println(String.format("Filling : %d%% .Amount of appearances : %d. Percent %.1f%%", i, amountAppearance, (float)amountAppearance/amountEffort*100));
        }
    }


}
