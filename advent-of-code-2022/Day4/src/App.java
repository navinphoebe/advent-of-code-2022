import java.io.BufferedReader;
import java.io.FileReader;

public class App {

public static int[] StringToIntArray(String str){
    String[] thingy = str.split("-");
    int[] banana = {Integer.parseInt(thingy[0]),Integer.parseInt(thingy[1])};
    return banana;
}
    public static void main(String[] args) throws Exception {
          var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        int value = 0;
        while(line != null) {
            int reset = 0;
            String[] book = line.split(",");
            String first = book[0];
            String second = book[1];
            int[] apple = StringToIntArray(first);
            int[] orange = StringToIntArray(second);
            int a = apple[0];
            int b = orange[0];
            int c = apple[1];
            int d = orange[1];
            for (int i = a; i<=c; i++){
                for (int j = b; j<=d; j++){
                    if (i==j&&reset==0){
                        value += 1;
                        reset = 1;
                    }
                }
            }
            line = reader.readLine();
        }
        reader.close();
        System.out.println(value);
    }
}
