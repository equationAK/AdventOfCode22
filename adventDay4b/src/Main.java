import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("/Users/aris/Desktop/testday4a.txt");
        String[] arr = data.split("\n");
        int counter = 0;

        for (String s : arr) {
            String[] sList = s.split(",");
            String[] blist1 = sList[0].split("-");
            String[] blist2 = sList[1].split("-");
            int a1 = Integer.parseInt(blist1[0]);
            int a2 = Integer.parseInt(blist1[1]);
            int b1 = Integer.parseInt(blist2[0]);
            int b2 = Integer.parseInt(blist2[1]);

            boolean flag = false;
            if((b1 >= a1 && b1 <= a2) || (a1 >= b1 && a1 <= b2)) {
                counter++;
                flag = true;
            }
            System.out.println(flag);
        }
        System.out.println(counter);
    }
}