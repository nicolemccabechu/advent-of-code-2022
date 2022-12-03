package Day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Day02 {

    // 0 if you lost, 3 if the round was a draw, and 6 if you won
    private static final Map<String, Integer> rulesPart1 = Map.of(
            "A X", 3,
            "A Y", 6,
            "A Z", 0,
            "B X", 0,
            "B Y", 3,
            "B Z", 6,
            "C X", 6,
            "C Y", 0,
            "C Z", 3
    );

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("src/Day02/strategy.txt"));

        String line = bf.readLine();

        int scorePart1 = 0;

        while (line != null) {
            scorePart1 += getResultPart1(line);
            line = bf.readLine();
        }

        bf.close();
        System.out.println("The total score of part one is: " + scorePart1);
    }

    private static int getResultPart1(final String s) {
        return getPointsShapeSelected(s.charAt(2)) + rulesPart1.get(s);
    }

    // 1 for Rock, 2 for Paper, and 3 for Scissors
    private static int getPointsShapeSelected(final char s) {
        switch(s){
            case 'X':
                return 1;
            case 'Y':
                return 2;
            case 'Z':
                return 3;
            default:
                return 0;
        }
    }
}
