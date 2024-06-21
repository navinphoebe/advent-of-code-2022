import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class App {


public static int[] decifer(String str){
    String[] hehe = str.split(" ");
    int[] orders = {Integer.parseInt(hehe[1]), Integer.parseInt(hehe[3]), Integer.parseInt(hehe[5])};
    return orders;
} 

public static Stack<Character> reverse(Stack<Character> omosh){
    Stack<Character> copy = omosh;
    Stack<Character> banana = new Stack<Character>();
    while (!copy.isEmpty()){
        banana.add(copy.peek());
        copy.pop();
    }
    return banana;
}
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        Stack<Character>[] columns = new Stack[9];

        for (int i = 0; i < 9; i++) {
            columns[i] = new Stack<>();
        }

        while (line != null && line.contains("[")) {
            for (int i = 0; i < 9; i++) {
                if (line.charAt(1 + i * 4) != ' '){
                columns[i].add(line.charAt(1 + i * 4));
            }
            }
            line = reader.readLine();
        }
       for (int i = 0; i < 9; i++) {
        columns[i] = reverse(columns[i]);
       }

        while(line != null) {
        if (line.startsWith("move")) {
        int[] numbers = decifer(line);
        int howmany = numbers[0];
        int fromwhere = numbers[1]-1;
        int towhere = numbers[2]-1;
        Stack<Character> change = new Stack<Character>();
        for (int i = 0; i < howmany; i++) {
                char item = columns[fromwhere].pop();
                change.add(item);
               
        }
        for (int i = 0; i< howmany; i++){
            char bagel = change.pop();
            columns[towhere].push(bagel);
        }
    }
        line = reader.readLine();
}
        reader.close();
        StringBuilder output = new StringBuilder();
        for (Stack<Character> column : columns) {
            output.append(column.peek());
        }
        System.out.println("The output is " + output.toString());
    }
}

