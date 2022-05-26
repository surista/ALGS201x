import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;


class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;

    public static void main(String[] args) {

    }
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        Boolean success = true;
        int errorPosition = 1;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position + 1));
            }

            if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.isEmpty()) {
                    System.out.println(position + 1);
                    success = false;
                    break;
                } else if (!opening_brackets_stack.peek().Match(next)) {
                    System.out.println(position + 1);
                    success = false;
                    break;
                } else {
                    opening_brackets_stack.pop();
                }
            }
        }
        if (success && !opening_brackets_stack.isEmpty()) {
            System.out.println(opening_brackets_stack.peek().position);
            success = false;
        }

        else if (success) {
            System.out.println("Success");
        }
    }
}