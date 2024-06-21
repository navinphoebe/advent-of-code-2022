import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
       var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        int total = 0;
        int vov = 0;
        while(line != null) {
            
            char opp = line.charAt(0);
            char succeed = line.charAt(2);
            if (succeed == 'X'){
                vov = 0;
            } else if (succeed == 'Y'){
                vov = 3;
            } else if (succeed == 'Z'){
                vov = 6;
            }
            if ((opp == 'A' && vov == 3)||(opp == 'B' && vov == 0)||(opp == 'C'&& vov == 6)) {
            total += (vov+1);
            } else if ((opp == 'A' && vov == 0)||(opp == 'B' && vov == 6)||(opp == 'C'&& vov == 3)){
                total += (vov+3);
            } else if ((opp == 'A' && vov == 6)||(opp == 'B' && vov == 3)||(opp == 'C'&& vov == 0)){
                total += (vov + 2);
            }
            line = reader.readLine();
        }
        reader.close();
        System.out.println(total);
    }
}
