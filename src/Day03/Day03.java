package Day03;

import java.io.*;
import java.util.Scanner;

public class Day03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/Day03/supplies.txt"));
            int priority = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String sameItem = "";
                String firstCompartment = line.substring(0, line.length() / 2);
                String secondCompartment = line.substring(line.length() / 2);
                sameItem = findSameItems(firstCompartment, secondCompartment);
                priority += getLetterPriority(sameItem);
            }
            System.out.println("part1: " + priority);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //part 2
        try {
            Scanner scanner = new Scanner(new File("src/Day03/supplies.txt"));
            int priority = 0;
            while (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                String secondLine = scanner.nextLine();
                String thirdLine = scanner.nextLine();
                String sameItem = findSameItems(thirdLine, findSameItems(firstLine, secondLine));
                priority += getLetterPriority(sameItem);
            }
            System.out.println("part2: " + priority);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Lowercase item types a through z have priorities 1 through 26.
    // Uppercase item types A through Z have priorities 27 through 52.
    private static int getLetterPriority(String letter) {
        int priority = letter.codePointAt(0);
        if (priority >= 65 && priority <= 90) {
            priority -= 64 - 26;
        } else {
            priority -= 96;
        }
        return priority;
    }

    // Find the item type that appears in both compartments of each rucksack
    private static String findSameItems(String first, String second) {
        String sameItem = "";
        for (int i = 0; i < first.length(); i++) {
            String firstChar = String.valueOf(first.charAt(i));
            for (int j = 0; j < second.length(); j++) {
                String secondChar = String.valueOf(second.charAt(j));
                if (firstChar.equals(secondChar)) {
                    sameItem += firstChar;
                }
            }
        }
        return sameItem;
    }
}
