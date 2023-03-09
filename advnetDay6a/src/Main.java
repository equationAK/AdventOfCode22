import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("/Users/aris/Desktop/testDay6a.txt");
        char[] bufferedString = data.toCharArray();
        int counter = 3;
        char forth;
        char third;
        char second;
        char first;


        for(int i = 3; i < bufferedString.length; i++) {
            forth = Character.valueOf(bufferedString[i]);
            third = Character.valueOf(bufferedString[i-1]);
            second = Character.valueOf(bufferedString[i-2]);
            first = Character.valueOf(bufferedString[i-3]);
            counter++;
            if (forth != third && forth != second && forth != first && third != second && third != first && second != first) {
                System.out.println("=============");
                System.out.print(first);
                System.out.print(second);
                System.out.print(third);
                System.out.println(forth);
                System.out.println("=============");
                System.out.println(counter);
                System.out.println("=============");
                break;
            }
        }
    }
}