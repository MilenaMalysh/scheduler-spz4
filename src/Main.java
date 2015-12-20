import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, Integer> sizes;
    private static int amountEffort = 200;
    private static String text;
    private static FileOutputStream newFile;
    private static byte[] buffer;
    public static final String tab = "\t";
    public static final String newRow = "\n";
    private static StringBuilder outputText;

    public static void main(String[] args) {
        sizes = new HashMap<Integer, Integer>();
        sizes.put(1, 10);
        sizes.put(2, 15);
        sizes.put(3, 20);
        sizes.put(4, 25);
        sizes.put(5, 30);



        while (true) {
            System.out.println("Choose mode:");
            System.out.println("One size: 1");
            System.out.println("Output to .xls file all sizes: 2");
            Scanner in_m = new Scanner(System.in);
            int mode = in_m.nextInt();
            if (!((mode == 2) || (mode == 1))) {
                System.out.println("Error in entered mode. Please enter one more time");
            } else {
                if (mode == 1) {
                    mode1();
                } else {
                    mode2();
                }
                break;
            }
        }

    }


    private static void mode1() {
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
            } else {
                break;
            }
        }
        processing(sizeNum,1);
    }

    private static void mode2() {
        try {
            newFile = new FileOutputStream("D:/WorkTable/Projects/SPO4/graph.xls");
        } catch (IOException e) {
            System.out.print("Error while creating file");
        }



        for (int i = 1; i <= sizes.size(); i++) {
            processing(i,2);
        }


        try {
            newFile.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }


    private static void processing(int sizeNum, int mode) {
        //System.out.println("Matrix size = " + sizes.get(sizeNum));
        for (int i = 1; i <= 100; i++) {
            int amountAppearance = 0;
            for (int j = 0; j < amountEffort; j++) {
                Graph graph = new Graph(sizes.get(sizeNum), i);
                //graph.show();
                if (graph.isAppearance()) {
                    amountAppearance++;
                }
            }
            if (mode==1) {
                System.out.println(String.format("Filling : %d%% .Amount of appearances : %d. Percent %.1f%%", i, amountAppearance, (float) amountAppearance / amountEffort * 100));
            }else {
                System.out.println(String.format("Filling : %d%% .Amount of appearances : %d. Percent %.1f%%", i, amountAppearance, (float) amountAppearance / amountEffort * 100));
                outputText = new StringBuilder();
                if (i ==1){
                    outputText.append(newRow);
                    outputText.append(newRow);
                }
                outputText.append(newRow).append(i).append(tab).append(Math.rint((float) amountAppearance / amountEffort * 100));
                buffer = outputText.toString().getBytes();
                try {
                    newFile.write(buffer, 0, buffer.length);

                } catch (IOException e) {
                    System.out.println("File not found");
                }
            }
        }

    }
}
