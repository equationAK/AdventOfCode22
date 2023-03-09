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
        String data = readFileAsString("/Users/aris/Desktop/testday2.txt");
        String[] arr = data.split("\n");
        int matchscore = 0;
        int optionScore = 0;
        int matchPoint = 0;
        int point = 0;

        for (String s : arr) {

            switch (s) {
                case "A Y":
                case "C Z":
                case "B X":
                    matchPoint = 1;
                    break;
                case "C X":
                case "B Y":
                case "A Z":
                    matchPoint = 2;
                    break;
                case "A X":
                case "C Y":
                case "B Z":
                    matchPoint = 3;
                    break;
            }
            optionScore += matchPoint;
        }

        for (String s1 : arr) {
            switch (s1) {
                case "A X":
                case "B X":
                case "C X":
                    point = 0;
                    break;
                case "A Y":
                case "B Y":
                case "C Y":
                    point = 3;
                    break;
                case "A Z":
                case "B Z":
                case "C Z":
                    point = 6;
                    break;
                }
                matchscore += point;
            }
        System.out.println(matchscore);
        System.out.println(optionScore);
        System.out.println(matchscore+optionScore);
    }
}
