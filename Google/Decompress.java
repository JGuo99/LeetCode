import java.util.Stack;

public class Decompress {
    /*
        https://techdevguide.withgoogle.com/resources/former-interview-question-compression-and-decompression
        Steps:
            - If it's letter --> append to result string
            - If it's digit --> get substring of the number
            - Check for number of nested strings
            - Finally, Build the result String
     */
    public static String decompress(String input) {
//        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int numStart = 0;

        StringBuilder result = new StringBuilder();
        int subStart = 0;

        int i = 0;
        while (i < input.length()) {
            if (Character.isLetter(input.charAt(i))) {
                result.append(input.charAt(i));
                i++;
            } else {
                // Get the Number
                numStart = i;
                while (Character.isDigit(input.charAt(i))) {
                    i++;
                }
                num = Integer.parseInt(input.substring(numStart, i));
                i++;
                // Extract Nested String
                int nested = 1;
                subStart = i;
                while (nested > 0) {
                    if (input.charAt(i) == '[')
                        nested++;
                    else if (input.charAt(i) == ']')
                        nested--;
                    i++;
                }
                // Build the final result
                String sub = decompress(input.substring(subStart, i-1));
                for (int j = 0; j < num; j++) {
                    result.append(sub);
                }
            }
        }
        return result.toString();
    }
}
