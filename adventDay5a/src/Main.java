import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("/Users/aris/Desktop/testday5.txt");
        String[] arr = data.split("\n");
        String[] arr1 = new String[arr.length];
        String[] s1 = new String[9];
        String movPart = new String();

        int size = 0;
        int from = 0;
        int to = 0;
        s1[0] = "NBDTVGZJ";
        s1[1] = "SRMDWPF";
        s1[2] = "VCRSZ";
        s1[3] = "RTJZPHG";
        s1[4] = "TCJNDZQF";
        s1[5] = "NVPWGSFM";
        s1[6] = "GCVBPQ";
        s1[7] = "ZBPN";
        s1[8] = "WPJ";


        char[] chars = new char[s1.length];
        chars = s1[0].toCharArray();
        // Replacing every non-digit number
        // with a space(" ")
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i].replaceAll("[^0-9]", " "); // regular expression
        }
        // Replace all the consecutive white
        // spaces with a single space
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr1[i].replaceAll(" +", " ");
        }
        // loop for passing values to movement parameters

        for (int i = 0; i < arr1.length; i++) {
            Scanner sc = new Scanner(arr1[i]);
            size = sc.nextInt();
            from = sc.nextInt();
            to = sc.nextInt();
            for (int j = 0; j < size; j++) {
                movPart = s1[from - 1].substring(s1[from - 1].length() - 1);
                s1[from - 1] = s1[from - 1].substring(0, s1[from - 1].length() - 1);
                s1[to - 1] = s1[to - 1] + movPart;

                System.out.println(movPart);
                System.out.println(s1[from - 1]);
                System.out.println(s1[to - 1]);
            }

            System.out.println("=======================================");
            for (String stacks : s1) {
                System.out.println(stacks);
            }
            System.out.println("=======================================");
        }
    }
}