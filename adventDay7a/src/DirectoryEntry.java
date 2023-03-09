import java.util.*;

public class DirectoryEntry extends FileEntry {

    private DirectoryEntry parent;
    private Map<String, FileEntry> files = new HashMap();

    public DirectoryEntry (DirectoryEntry parent, String name) {
        super(name, 0);
        this.parent = parent;
    }

    public Collection<FileEntry> getFiles() {
        return files.values();
    }

    public void addFile (FileEntry fe) {
        files.put(fe.getName(), fe);
    }

    public long getSize() {
        long count = 0;
        for (FileEntry fe : files.values()) {
            count += fe.getSize();
        }
        return count;
    }

    public DirectoryEntry getParent() {
        return parent;
    }

    public DirectoryEntry getDirectory(String name) {
        return (DirectoryEntry) files.get(name);
    }

}
