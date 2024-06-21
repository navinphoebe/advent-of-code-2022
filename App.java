import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        int value = 0;
        char firstmatch;
        char secondmatch;
        char thirdmatch;
        int priority;
        int reset;
        String abcs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while(line != null) {
        String first = line;
        String second = reader.readLine();
        String third = reader.readLine();
        reset = 0;
        line = reader.readLine();
        for (int i = 0; i < first.length(); i++){
        for (int j = 0; j < second.length(); j++) {
            for (int k = 0; k < third.length(); k++) {
                firstmatch = first.charAt(i);
                secondmatch = second.charAt(j);
                thirdmatch = third.charAt(k);
                
                if (firstmatch == secondmatch && secondmatch == thirdmatch && reset == 0) {
                    priority = abcs.indexOf(secondmatch) + 1;
                    value += priority;
                    reset = 1;
                }
            }
        }
        }
        }
    
        reader.close();
        System.out.println(value);
    }
}