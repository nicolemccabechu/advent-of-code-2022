import java.io.*;
import java.util.*;

public class Day01 {
    public static void main(String[] args) throws IOException {
        List<String> listOfStrings
                = new ArrayList<String>();

        BufferedReader bf = new BufferedReader(
                new FileReader("src/input.txt"));

        String line = bf.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        bf.close();

        System.out.println(getResult(listOfStrings, false));
    }

    private static int getResult(List<String> input, boolean part1){
        final List<Integer> calories = new ArrayList<>();
        int currentTotal = 0;
        for(int i = 0; i < input.size(); i++){
            final String line = input.get(i);
            if(line.isEmpty()){
                calories.add(currentTotal);
                currentTotal = 0;
            } else {
                currentTotal += Integer.parseInt(line);
            }
        }
        Collections.sort(calories, Comparator.reverseOrder());
        return calories.stream().mapToInt(Integer::intValue).limit(part1 ? 1 : 3).sum();
    }
}
