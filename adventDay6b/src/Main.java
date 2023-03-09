import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static boolean is_Unique_str(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == chars[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("/Users/aris/Desktop/testDay6a.txt");
        String split = new String();
        final int size = 14;
        int counter = 13;

        for (int i = 0; i < data.length() - size; i++) {
            split = data.substring(i, size + i);
            counter++;
            if (is_Unique_str(split)) {
                System.out.println("=================================");
                System.out.println("The marker starts at :" + i);
                System.out.println(split);
                System.out.println("=================================");
                System.out.println("Total characters processed :" + counter);
                System.out.println("=================================");
                break;
            }
        }
    }
}
