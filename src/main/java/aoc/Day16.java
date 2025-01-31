package aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import aoc.utils.Day;
import aoc.utils.FileHelper;

public class Day16 {

  private static final System.Logger LOGGER = System.getLogger(Day16.class.getName());
  private static final Day day = new Day();

  public static void main(String[] args) {

    Path filePath = Paths.get("src/main/resources/day16_data.txt");
    List<String> input = FileHelper.readLinesInFile(filePath);

    LOGGER.log(System.Logger.Level.INFO, input);

    day.setName("Reindeer Maze");
    day.setPart1(part1(input));
    day.setPart2(part2(input));

    day.printParts();

  }

  public static int part1(List<String> input) {
    return 0;
  }

  public static int part2(List<String> input) {

    return 0;
  }
  
}
