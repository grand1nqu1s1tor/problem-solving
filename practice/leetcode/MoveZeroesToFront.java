public class MoveZeroesToFront {

    public static String moveZeroes(String input) {

        StringBuilder nonZero = new StringBuilder();

        input.chars().filter(ch -> ch != '0').forEach(ch -> nonZero.append((char) ch));
        //IntStream.range(0, input.length() - nonZero.length()).forEach(nonZero.append('0'));
        int numOfZeroes = input.length() - nonZero.length();
        for (int i = 0; i < numOfZeroes; i++) {
            nonZero.insert(0, "0");
        }
        return nonZero.toString();
    }

    public static void main(String[] args) {
        String input = "10230405"; // Sample test case
        String result = moveZeroes(input);
        System.out.println("Transformed String: " + result);
    }
}
