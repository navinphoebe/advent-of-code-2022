import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        int second = 0;
        int banana = 0;
        int first = 0;
        int third = 0;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                int value = Integer.parseInt(line);
                banana += value;
            } else {
                if (banana > first) {
                    third = second;
                    second = first;
                    first = banana;
                    
                    
                } else if (banana > second && banana < first) {
                    third = second;
                    second = banana;
                    
                } else if (banana > third && banana < second){
                    third = banana;
                }
                banana = 0;
            }
        }

       
        
        

        reader.close();
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    
    }
}
