package aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import aoc.utils.Day;
import aoc.utils.FileHelper;

public class Day01 {

  private static final System.Logger LOGGER = System.getLogger(Day01.class.getName());
  private static final Day day = new Day();

  public static void main(String[] args) {

    String version = System.getProperty("java.version");
    LOGGER.log(System.Logger.Level.INFO, "Java version: {0}", version);

    String file = FileHelper.readFile(Day01.class.getSimpleName());

    day.setName("Historian Hysteria");

    ArrayList<Integer> numbers1 = new ArrayList<>();
    ArrayList<Integer> numbers2 = new ArrayList<>();

    String[] lines = Objects.requireNonNull(file).split("\n");
    for (String line : lines) {
      if (!line.trim().isEmpty()) {
        LOGGER.log(System.Logger.Level.INFO, line);
        String[] parts = line.split("\\s+");
        numbers1.add(Integer.parseInt(parts[0]));
        LOGGER.log(System.Logger.Level.INFO, (parts[0]));
        numbers2.add(Integer.parseInt(parts[1]));
        LOGGER.log(System.Logger.Level.INFO, (parts[1]));
      }
    }

    Collections.sort(numbers1);
    Collections.sort(numbers2);

    int sum = 0;

    for (int i = 0; i < numbers1.size(); i++) {
      int diff = 0;
      if (numbers1.get(i) > numbers2.get(i)) {
        diff = numbers1.get(i) - numbers2.get(i);
        LOGGER.log(System.Logger.Level.INFO, numbers1.get(i) + " is bigger than " + numbers2.get(i));
      } else if (numbers1.get(i) < numbers2.get(i)) {
        diff = numbers2.get(i) - numbers1.get(i);
        LOGGER.log(System.Logger.Level.INFO, numbers2.get(i) + " is bigger than " + numbers1.get(i));
      } else {
        LOGGER.log(System.Logger.Level.INFO, numbers1.get(i) + " is equal to " + numbers2.get(i));
      }
      LOGGER.log(System.Logger.Level.INFO,"Difference between " + numbers2.get(i) + " and " + numbers1.get(i) + " is: " + diff);
      sum += diff;
      LOGGER.log(System.Logger.Level.INFO, "diff: {0}", diff);
    }
    LOGGER.log(System.Logger.Level.INFO, "sum: {0}", sum);

    int similar = 0;

    for (Integer number : numbers1) {
      for (Integer number2 : numbers2) {
        int occurrences = 0;
        if (number.equals(number2)) {
          occurrences++;
        }
        similar += number*occurrences;
      }
    }
    LOGGER.log(System.Logger.Level.INFO, "similar: {0}", similar);
  }

}
