import java.io.BufferedReader;
import java.io.FileReader;

public class App {

    public static Directory[] listOfDir = new Directory[201];
    public static int currentDir = 0;
    public static int howManyDir = 0;

    public static void addFileSize(int num, int current) {
        listOfDir[current].addFiles(num);
        if (listOfDir[current].dirContaining == -1) {
            return;
        } else {
            addFileSize(num, listOfDir[current].dirContaining);
        }
    }

    private static void findAndChangeToFile(String string) {
        for (int i = 0; i < listOfDir.length; i++) {
            if (listOfDir[i] == null) {
            } else if (listOfDir[i].name.equals(string) && listOfDir[i].dirContaining == listOfDir[currentDir].dirNum) {
                currentDir = listOfDir[i].dirNum;
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        listOfDir[0] = new Directory("/", -1, 0);
        var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        while (line != null) {
            if (line.contains("$")) {
                if (line.contains("ls")) {
                } else if (line.contains("..")) {
                    currentDir = listOfDir[currentDir].dirContaining;
                    if (currentDir == -1) {
                        currentDir = 0;
                    }
                } else if (line.contains("/")) {
                    currentDir = 0;
                } else {
                    String[] file = line.split(" ");
                    findAndChangeToFile(file[2]);
                }
            } else if (line.contains("dir")) {
                String[] file = line.split(" ");
                howManyDir += 1;
                listOfDir[howManyDir] = new Directory(file[1], currentDir, howManyDir);
            } else {
                String[] file = line.split(" ");
                int num = Integer.parseInt(file[0]);
                addFileSize(num, currentDir);
            }
            line = reader.readLine();
        }
        reader.close();
        int needToDelete = 70000000 - listOfDir[0].sizeOfFiles;
        int deleteAmount = 30000000 - needToDelete;
        int bestValue = 70000000;
        System.out.println(deleteAmount);
        for (int i = 0; i < listOfDir.length; i++) {
            if (listOfDir[i] != null) {
                if (listOfDir[i].sizeOfFiles < bestValue && listOfDir[i].sizeOfFiles >= deleteAmount) {
                    bestValue = listOfDir[i].sizeOfFiles;
                }
            }
        }
        for (int i = 0; i < listOfDir.length; i++) {
            if (listOfDir[i] != null) {
                System.out.println(listOfDir[i].sizeOfFiles);
            }
        }
        System.out.println(howManyDir);
        System.out.println(bestValue);
    }
}
