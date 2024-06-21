import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        int[][] forest = new int[99][99];
        int j = 0;
        
        while (line != null && j < 99) {
            for (int i = 0; i < 99; i++) {
                int number = Character.getNumericValue(line.charAt(i));
                forest[j][i] = number;
            }
            line = reader.readLine();
            j++;
        }
        reader.close();

        int maxScenicValue = 0;
        
        for (int i = 0; i < 99; i++) {
            for (int g = 0; g < 99; g++) {
                int scenic = isItFree(i, g, forest);
                if (scenic > maxScenicValue) {
                    maxScenicValue = scenic;
                }
            }
        }

        System.out.println(maxScenicValue);
    }

    private static int isItFree(int i, int g, int[][] forest) {
        int number = forest[i][g];

        
        int one = checkUp(number, i, g, forest);
        int two = checkDown(number, i, g, forest);
        int three = checkLeft(number, i, g, forest);
        int four = checkRight(number, i, g, forest);

        return one * two * three * four;
    }

    private static int checkRight(int number, int i, int g, int[][] forest) {
        int count = 0;
        for (int x = g + 1; x < 99; x++) {
            if (forest[i][x] < number) {
                count++;
            } else {
                count++;
                return count;
            }
        }
        return count;
    }

    private static int checkLeft(int number, int i, int g, int[][] forest) {
        int count = 0;
        for (int x = g - 1; x >= 0; x--) {
            if (forest[i][x] < number) {
                count++;
            } else {
                count++;
                return count;
            }
        }
        return count;
    }

    private static int checkDown(int number, int i, int g, int[][] forest) {
        int count = 0;
        for (int x = i + 1; x < 99; x++) {
            if (forest[x][g] < number) {
                count++;
            } else {
                count++;
                return count;
            }
        }
        return count;
    }

    private static int checkUp(int number, int i, int g, int[][] forest) {
        int count = 0;
        for (int x = i - 1; x >= 0; x--) {
            if (forest[x][g] < number) {
                count++;
            } else {
                count++;
                return count;
            }
        }
        return count;
    }
}