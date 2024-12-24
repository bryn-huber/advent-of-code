package aoc;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.Objects;

import aoc.utils.Day;
import aoc.utils.FileHelper;

public class Day02 {

  private static final System.Logger LOGGER = System.getLogger(Day02.class.getName());
  private static final Day day = new Day();

  public static void main(String[] args) {

    String version = System.getProperty("java.version");
    LOGGER.log(System.Logger.Level.INFO, "Java version: {0}", version);

    String inputData = FileHelper.readFile(Day02.class.getSimpleName());
    // LOGGER.log(System.Logger.Level.INFO, inputData);

    day.setName("Red-Nosed Reports");

    // create a list of each row of the input data
    ArrayList<String> reports = new ArrayList<>();
    String[] lines = Objects.requireNonNull(inputData).split("\n");
    for (String line : lines) {
      if (!line.trim().isEmpty()) {
        // LOGGER.log(System.Logger.Level.INFO, line);
        reports.add(line);
      }
    }

    int unSafeReports = 0;

    // Loop over each row of the input data
    for (String report : reports) {
      int badLevel = 0;

      // create an array of String from the row numbers
      String[] parts = report.split("\\s+");

      // Create an array of integers from the array of Strings for the row
      int[] numbers = new int[parts.length];
      for (int i = 0; i < parts.length; i++) {
        numbers[i] = Integer.parseInt(parts[i]);
      }

      // check if the array has a matching pair
      if(checkNumbersForMatchingPair(numbers)) {
        unSafeReports = unSafeReports + 1;
       continue; // Break to the next iteration of the for loop
      }

      // check order of numbers is as expected
      if (isAscending(numbers)) {
        LOGGER.log(System.Logger.Level.INFO, "The numbers are ascending safely in order.");
      } else if (isDescending(numbers)) {
        LOGGER.log(System.Logger.Level.INFO, "The numbers are descending safely in order.");
      } else {
        unSafeReports = unSafeReports + 1;
      }
    }

    LOGGER.log(System.Logger.Level.INFO, "unSafeReports = {0}", unSafeReports);

    int safeReports = reports.size() - unSafeReports;
    LOGGER.log(System.Logger.Level.INFO, "Safe Reports = {0}", safeReports);
  }

  public static boolean isAscending(int[] numbers) {
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i + 1] <= numbers[i] || numbers[i + 1] > numbers[i] + 3) {
        return false;
      }
    }
    return true;
  }

  public static boolean isDescending(int[] numbers) {
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i + 1] >= numbers[i] || numbers[i + 1] < (numbers[i] - 3)) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkNumbersForMatchingPair(int[] numbers) {
    for (int i = 0; i < numbers.length - 1; i++) {
      if (Objects.equals(numbers[i], numbers[i + 1])) {
        LOGGER.log(System.Logger.Level.INFO, "i ({0}) == i+1 ({1})", numbers[i], numbers[i + 1]);
        return TRUE;
      } else {
        LOGGER.log(System.Logger.Level.INFO, "i ({0}) != i+1 ({1})", numbers[i], numbers[i + 1]);
      }
    }
    return FALSE;
  }

}
