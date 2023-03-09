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
            if(a2 - a1 >= b2 - b1) {
                if (a1 - b1 <= 0 && a2 - b2 >= 0) {
                    counter++;
                }
            } else if(b2 - b1 >= a2 - a1) {
                    if (b2 - a2 >= 0 && b1 - a1 <= 0) {
                        counter++;
                        flag = true;
                    }
                }
            }
        System.out.println(counter);
    }
}