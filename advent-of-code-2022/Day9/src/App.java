import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        Rope rope = new Rope();
        while(line != null) {
            String[] directions = line.split(" ");
            String where = directions[0];
            int howLong = Integer.parseInt(directions[1]);
            for (int i = 0; i < howLong; i++){
                 if (where.contains("R")){
                    rope.moveRight();
                } else if (where.contains("L")){
                    rope.moveLeft();
                } else if (where.contains("U")){
                    rope.moveUp();
                } else if (where.contains("D")){
                    rope.moveDown();
                }
            }
            line = reader.readLine();
        }
        reader.close();
        System.out.println(rope.placesTouched + 1);
        
    }

}
