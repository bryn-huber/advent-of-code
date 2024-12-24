package aoc;

import java.awt.Point;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

import aoc.utils.Day;
import aoc.utils.Direction;
import aoc.utils.FileHelper;

public class Day06 {

  private static final System.Logger LOGGER = System.getLogger(Day06.class.getName());
  private static final Day day = new Day();

  public static void main(String[] args) {

    Path filePath = Paths.get("src/main/resources/day06_data.txt");
    List<String> input = FileHelper.readLinesInFile(filePath);

    LOGGER.log(System.Logger.Level.INFO, input);

    day.setName("Guard Gallivant");
    day.setPart1(part1(input));
    day.setPart2(part2(input));

    day.printParts();

  }
  
  // guard ^ starting pos
  // guard X setps taken
  // guard # obstructions
  
  public static int part1(List<String> input) {
    char[][] map = getMap(input);
    Point start = getStart(input);
    return getPatrolPath(start, map).size();
  }

  public static int part2(List<String> input) {

    return 0;
  }

  private static char[][] getMap(List<String> input) {
    return input.stream()
            .map(String::toCharArray)
            .toArray(char[][]::new);
  }

  private static Point getStart(List<String> input){
    return input.stream()
            .map(line -> new Point(line.indexOf('^'), input.indexOf(line)))
            .filter(point -> point.x != -1)
            .findFirst()
            .orElseThrow(null);
  }

  private static HashSet<Point> getPatrolPath(Point Start, char[][] map){
    HashSet<Point> path = new HashSet<>();
    path.add(Start);
    Point currentPossition = Start;
    Direction direction = Direction.NORTH;
    boolean offTheMap = false;
    while (!offTheMap) {
      Point nextPoint = Direction.getPoint(direction, currentPossition);
      try {
          if (map[nextPoint.y][nextPoint.x] == '#') {
            direction = Direction.rotate90(direction, true);
          } else {
            path.add(nextPoint);
            currentPossition = nextPoint;
          }
      } catch (ArrayIndexOutOfBoundsException e) {
        offTheMap = true;
      }
    }
    return path;
  }
}
