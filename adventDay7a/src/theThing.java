public class theThing {
    private String name;
    private String parent;
    private int size;
    private boolean isFile;

    theThing(String name, String parent, int size) {
        this.name = name;
        this.parent = parent;
        this.size = size;
    }
    theThing(String name, String parent) {
        this.name = name;
        this.parent = parent;
    }

    theThing(String s) {
        isFile = false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public String getParent(String name) {
            return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean isFile) {
        this.isFile = isFile;
    }

}