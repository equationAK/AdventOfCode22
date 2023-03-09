public class FileEntry {
    private String name;
    private long size = 0;


    public FileEntry(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

}