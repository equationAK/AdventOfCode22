import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



public class Main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }


    public static void main(String[] args) throws Exception {
        String data = readFileAsString("/Users/aris/Desktop/testDay7.txt");
        ArrayList<String> arrayList = new ArrayList<>(List.of(data.split("\\n")));

        DirectoryEntry rootDirectory = new DirectoryEntry(null, "/");
        DirectoryEntry currentDirectory = rootDirectory;

        List<DirectoryEntry> allDirectories = new ArrayList<>();
        for (String s : arrayList) {
            String[] linearr = s.split(" ");
            if ("$".equals(linearr[0])) {
                if ("cd".equals(linearr[1])) {
                    if ("/".equals(linearr[2])) {
                        currentDirectory = rootDirectory;
                    } else if ("..".equals(linearr[2])) {
                        currentDirectory = currentDirectory.getParent();
                    } else {
                        currentDirectory = currentDirectory.getDirectory(linearr[2]);
                    }
                }
            } else if ("dir".equals(linearr[0])) {
                DirectoryEntry de = new DirectoryEntry(currentDirectory, linearr[1]);
                currentDirectory.addFile(de);
                allDirectories.add(de);
            } else {
                currentDirectory.addFile(new FileEntry(linearr[1], Long.parseLong(linearr[0])));
            }
        }


        long count = 0;
        long sizeOfRoot = rootDirectory.getSize();
        long spaceLeft = 70000000 - sizeOfRoot;
        long spaceToRemove = 30000000 - spaceLeft;

        List<DirectoryEntry> dirToDelete = new ArrayList<>();

        for (DirectoryEntry de : allDirectories) {
            if (de.getSize() > spaceToRemove) {
                dirToDelete.add(de);
            }
        }
        dirToDelete.add(rootDirectory);

        dirToDelete.sort((a,b) -> (int) (a.getSize() - b.getSize()));

        System.out.println(dirToDelete.get(0).getSize());
    }
}