import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }


    public static void main(String[] args) throws Exception {
        String data = readFileAsString("/Users/aris/Desktop/test.txt");
        ArrayList<String> arrayList = new ArrayList<>(List.of(data.split("\\n")));

        int[][] forest = new int[arrayList.size()][5];
        Character[][] visibilityUp = new Character[arrayList.size()][5];
        Character[][] visibilityDown = new Character[arrayList.size()][5];
        for (int f = 0; f < 5; f++) {
            visibilityUp[0][f] = 'v';
            visibilityUp[f][0] = 'v';
            visibilityUp[f][4] = 'v';
            visibilityUp[4][f] = 'v';
            visibilityUp[1][0] = 'v';
            visibilityUp[0][0] = 'v';
            visibilityDown[0][f] = 'v';
            visibilityDown[f][0] = 'v';
            visibilityDown[f][4] = 'v';
            visibilityDown[4][f] = 'v';
            visibilityDown[1][0] = 'v';
            visibilityDown[0][0] = 'v';
        }

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < 5; j++) {
                forest[i][j] = Character.getNumericValue(arrayList.get(i).charAt(j));
                System.out.print(forest[i][j] + " ");
            }
            System.out.println();
        }

        for (int m = 1; m < 4; m++) {
            for (int i = 1; i < 4; i++) {
                if (forest[i][m] <= forest[i - 1][m] && forest[i][m] <= forest[i][m - 1])
                    visibilityUp[i][m] = 'o';
                else
                    visibilityUp[i][m] = 'v';

                if (forest[4 - i][4 - m] <= forest[4 - i][4 - m + 1] && forest[4 - i][4 - m] <= forest[4 - i + 1][4 - m])
                    visibilityDown[4 - i][4 - m] = 'o';
                else
                    visibilityDown[4 - i][4 - m] = 'v';

                if (forest[m][i] <= forest[m - 1][i] && forest[m][i] <= forest[m][i - 1])
                    visibilityUp[m][i] = 'o';
                else
                    visibilityUp[m][i] = 'v';

                if (forest[4 - m][4 - i] <= forest[4 - m + 1][4 - i] && forest[4 - m][4 - i] <= forest[4 - m][4 - i + 1])
                    visibilityDown[4 - m][4 - i] = 'o';
                else
                    visibilityDown[4 - m][4 - i] = 'v';
            }
        }
        int counter = 0;
        for (int h = 0; h < 5; h++) {
            for (int v = 0; v < 5; v++) {
                if (visibilityUp[h][v].equals('o') && visibilityDown[h][v].equals('o')) {
                    counter++;
                }
            }
        }


            for (int k = 0; k < arrayList.size(); k++) {
                for (int j = 0; j < 5; j++)
                    System.out.print(visibilityUp[k][j] + " ");
                System.out.println();
            }
            System.out.println("===============");
            for (int k = 0; k < arrayList.size(); k++) {
                for (int j = 0; j < 5; j++)
                    System.out.print(visibilityDown[k][j] + " ");
                System.out.println();
            }

            System.out.println(counter);
        }
    }