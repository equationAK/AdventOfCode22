import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("/Users/aris/Desktop/testday3.txt");
        String[] arr = data.split("\n");
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 3 == 0) {
                String s1 = arr[i];
                String s2 = arr[i + 1];
                String s3 = arr[i + 2];

                Set<Character> set1 = new HashSet<Character>();
                Set<Character> set2 = new HashSet<Character>();
                Set<Character> set3 = new HashSet<Character>();

                for (char c : s1.toCharArray()) {
                    set1.add(c);
                }
                for (char c : s2.toCharArray()) {
                    set2.add(c);
                }
                for (char c : s3.toCharArray()) {
                    set3.add(c);
                }

                // Stores the intersection of set1, set2 and set3 inside set1
                set1.retainAll(set2);
                set3.retainAll(set1);
                set2.retainAll(set3);

                for (char c : set2) {
                    int charValue = c;
                    if (charValue >= 97) {
                        counter += (charValue - 96);
                    } else {
                        counter += (charValue - 38);
                    }
                    System.out.println(c + " = " + charValue);
                }
            }
        }
        System.out.println("Final number is:" + counter);
    }
}