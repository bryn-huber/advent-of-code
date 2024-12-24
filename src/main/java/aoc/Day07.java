package aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import aoc.utils.Day;
import aoc.utils.FileHelper;

public class Day07 {

  private static final System.Logger LOGGER = System.getLogger(Day07.class.getName());

  public static void main(String[] args) {

    Path filePath = Paths.get("src/main/resources/day07_data.txt");
    List<String> input = FileHelper.readLinesInFile(filePath);

    Day day = new Day();

    LOGGER.log(System.Logger.Level.INFO, input);

    day.setPart1(part1(input));
    day.setPart2(part2(input));

    day.printParts();

  }
  
  // total calibration result
  // add + or multiply *
  // left == right so split by :
  // check each row to see if result can be added
  // split to map numbers 
  // check if number is bigger than target number
  // evaluate until end of numbers or target is smaller than current number

  // part two add concatenate operation
  // use of boolean
  // evaluate use extra operation to concatenate

  public static long part1(List<String> input) {
    long sumValid = 0;
    for (String line : input) {
        var parts = line.split(": ");
        long result = Long.parseLong(parts[0]);
        if (isValid(result, parts[1], false)) {
            sumValid += result;
        }
    }
    return sumValid;
}

public static long part2(List<String> input) {
  long sumValid = 0;
  for (String line : input) {
      var parts = line.split(": ");
      long result = Long.parseLong(parts[0]);
      if (isValid(result, parts[1], true)) {
          sumValid += result;
      }
  }
  return sumValid;
}

private static boolean isValid(long result, String part, boolean addConcatenate) {
    var numbers = Arrays.stream(part.split(" ")).map(Long::parseLong).toArray(Long[]::new);
    return evaluate(numbers, 0, numbers[0], result, addConcatenate);
}

private static boolean evaluate(Long[] numbers, int index, long currentResult, long target, boolean addConcatenate) {
    if (currentResult > target) {
        return false;
    }
    if (index == numbers.length - 1) {
        return currentResult == target;
    }
    if (addConcatenate) {
        return  evaluate(numbers, index + 1, currentResult + numbers[index + 1], target, true) ||
                evaluate(numbers, index + 1, currentResult * numbers[index + 1], target, true) ||
                evaluate(numbers, index + 1, Long.parseLong(currentResult + "" + numbers[index + 1]), target, true);
    } else {
        return  evaluate(numbers, index + 1, currentResult + numbers[index + 1], target, false) ||
                evaluate(numbers, index + 1, currentResult * numbers[index + 1], target, false);
    }
}
}
