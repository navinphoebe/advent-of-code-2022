public class Directory {

    public int sizeOfFiles;
    public int dirContaining;
    public int dirNum;
    public String name;


    public Directory (String name, int dirContaining, int dirNum){
        this.dirContaining = dirContaining;
        this.dirNum = dirNum;
        this.name = name;
        this.sizeOfFiles = 0;
    }


    public void addFiles(int size){
        this.sizeOfFiles += size;
    }
}
