import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        int counter = 0;
        boolean found = false;
        while(!found){
            for (int i = 0; i<line.length()-14; i++){
            String thingy = line.substring(i, i+14);
            boolean dibs = false;
            for (int j = 0; j<14; j++){
                for(int k = j + 1; k < 14; k++){
                    if (thingy.charAt(k)==thingy.charAt(j)){
                        dibs = true;
                        break;
                    }
                }
                if (dibs){
                    break;
                }
            }
            if (!dibs) {
                found = true;
                break;
            }
            counter++;
        } 
    }  
        reader.close();
        System.out.println(counter+14);
    }
}
