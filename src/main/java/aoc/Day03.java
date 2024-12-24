package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.utils.Day;
import aoc.utils.FileHelper;

public class Day03 {

  private static final System.Logger LOGGER = System.getLogger(Day03.class.getName());
  private static final Day day = new Day();

  public static void main(String[] args) {

    String version = System.getProperty("java.version");
    LOGGER.log(System.Logger.Level.INFO, "Java version: {0}", version);

    String inputData = FileHelper.readFile(Day03.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

    day.setName("Mull It Over");

    // split by mul pattern
    String pattern = "mul\\((\\d+),(\\d+)\\)";

    List<String> matches = getAllMatches(inputData, pattern);
    int sum = 0;
    for (String match : matches) {
      String[] parts = match.replaceAll("[^\\d,]", "").split(",");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      sum += a * b;
    }
    LOGGER.log(System.Logger.Level.INFO, "Sum: {0}", sum);
  }

  public static List<String> getAllMatches(String input, String regex) {
    List<String> matches = new ArrayList<>();
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      matches.add(matcher.group());
    }
    return matches;
  }

}
