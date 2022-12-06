package Day04;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Day04 {
    public static void main(String[] args) throws IOException {
        int part1sum = 0;
        int part2sum = 0;

        Scanner scanner = new Scanner(new File("src/Day04/assignments.txt"));
        while (scanner.hasNext()) {
            String elfRangeSplit[] = scanner.nextLine().split(",");
            String firstRange[] = elfRangeSplit[0].split("-");
            String secondRange[] = elfRangeSplit[1].split("-");
            int a1 = Integer.parseInt(firstRange[0]);
            int a2 = Integer.parseInt(firstRange[1]);
            int b1 = Integer.parseInt(secondRange[0]);
            int b2 = Integer.parseInt(secondRange[1]);

            //part 1
            if ((b1 >= a1 && b2 <= a2) || (a1 >= b1 && a2 <= b2))
                part1sum++;

            //part 2
            //if sum of widths > max-min, they overlap
            if ((max(a2, b2) - min(a1, b1)) <= ((a2 - a1) + (b2 - b1))) {
                part2sum++;
            }
        }
        System.out.println("Part1: " + part1sum);
        System.out.println("Part2: " + part2sum);
    }
}