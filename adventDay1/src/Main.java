import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {

        String path = "the path of file that contains the data";
        String data = readFileAsString(path);
        String[] arr = data.split("\n\n");
        int tmp = 0;
        int[] intArr = new int[6000];
        final String msg1 = "The elf having the biggest amount of calories is: ";
        final String msg2 = "The 3 top elves are having together a total amount of ";

        for (int i = 0; i < arr.length; i++) {
            String string = arr[i];
            Integer sum = Arrays.stream(string.split("\n"))
                    .filter((s) -> s.matches("\\d+"))
                    .mapToInt(Integer::valueOf)
                    .sum();
            intArr[i] = sum;
            if (sum >= tmp) {
                tmp = sum;
            }
        }
        Arrays.sort(intArr);
        int reverseSum = intArr[intArr.length - 1] + intArr[intArr.length - 2] + intArr[intArr.length - 3];

        System.out.println(msg1 + tmp);
        System.out.println(msg2 + reverseSum + " calories");
    }
}
