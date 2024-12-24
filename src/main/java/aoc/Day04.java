package aoc;

import java.awt.Point;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Predicate;

import aoc.utils.Day;
import aoc.utils.Direction;
import aoc.utils.FileHelper;

public class Day04 {

  private static final System.Logger LOGGER = System.getLogger(Day04.class.getName());
  private static final Day day = new Day();

  public static void main(String[] args) {

    String version = System.getProperty("java.version");
    LOGGER.log(System.Logger.Level.INFO, "Java version: {0}", version);

    Path filePath = Paths.get("src/main/resources/day04_data.txt");
    List<String> input = FileHelper.readLinesInFile(filePath);

    day.setName("Ceres Search");
    part1(input);
    part2(input);

  }

  public static int part1(List<String> input) {
    var grid = getCharGrid(input);
    int cnt = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 'X') {
          cnt += checkDirectionXmas(grid, i, j, 0, 1);   // Horizontal right
          cnt += checkDirectionXmas(grid, i, j, 0, -1);  // Horizontal left
          cnt += checkDirectionXmas(grid, i, j, 1, 0);   // Vertical down
          cnt += checkDirectionXmas(grid, i, j, -1, 0);  // Vertical up
          cnt += checkDirectionXmas(grid, i, j, 1, 1);   // Diagonal down-right
          cnt += checkDirectionXmas(grid, i, j, -1, -1); // Diagonal up-left
          cnt += checkDirectionXmas(grid, i, j, 1, -1);  // Diagonal down-left
          cnt += checkDirectionXmas(grid, i, j, -1, 1);  // Diagonal up-right
        }
      }
    }
    LOGGER.log(System.Logger.Level.INFO, "Part 1: {0}", cnt);
    return cnt;
  }

  public static int part2(List<String> input) {
    var grid = getCharGrid(input);
    int cnt = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 'A') {
          cnt += checkDiagonal(grid, i, j);
        }
      }
    }
    LOGGER.log(System.Logger.Level.INFO, "Part 2: {0}", cnt);
    return cnt;
  }

  private static int checkDirectionXmas(char[][] grid, int i, int j, int di, int dj) {
    try {
      return (grid[i + di][j + dj] == 'M' && grid[i + 2 * di][j + 2 * dj] == 'A' && grid[i + 3 * di][j + 3 * dj] == 'S') ? 1 : 0;
    } catch (ArrayIndexOutOfBoundsException e) {
      return 0;
    }
  }

  private static int checkDiagonal(char[][] grid, int i, int j) {
    try {
      var diagonal1 = "" + grid[i + 1][j - 1] + grid[i - 1][j + 1];
      var diagonal2 = "" + grid[i - 1][j - 1] + grid[i + 1][j + 1];
      return (diagonal1.equals("MS") || diagonal1.equals("SM")) && (diagonal2.equals("MS") || diagonal2.equals("SM")) ? 1 : 0;
    } catch (ArrayIndexOutOfBoundsException e) {
      return 0;
    }
  }

  public static int[][] getIntGrid(List<String> input) {
    return input.stream()
        .map(s -> s.chars().map(Character::getNumericValue).toArray())
        .toArray(int[][]::new);
  }

  public static char[][] getCharGrid(List<String> input) {
    return input.stream()
        .map(String::toCharArray)
        .toArray(char[][]::new);
  }

  public static boolean isValidPoint(Point point, int[][] grid) {
    return point.x >= 0 && point.x < grid[0].length && point.y >= 0 && point.y < grid.length;
  }

  public static boolean isValidPoint(Point point, char[][] grid) {
    return point.x >= 0 && point.x < grid[0].length && point.y >= 0 && point.y < grid.length;
  }

  public static boolean isValidPoint(Point antinode, int gridSize) {
    return antinode.x >= 0 && antinode.x < gridSize && antinode.y >= 0 && antinode.y < gridSize;
  }

  public static Point findChar(char[][] grid, char c) {
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[0].length; x++) {
        if (grid[y][x] == c) {
          return new Point(x, y);
        }
      }
    }
    return new Point(-1, -1);
  }

  /**
   * Find the shortest path from start to end in a grid using BFS.
   *
   * @param grid the grid
   * @param start  the starting point
   * @param end    the ending point
   * @param isPassable a predicate that returns true if a point is passable, for example, if the value is not a wall: c -> c != '#'
   * @return the shortest path as a list of points or an empty list if there is no path
   */
  public static List<Point> findShortestPath(char[][] grid, Point start, Point end, Predicate<Character> isPassable) {
    Map<Point, Point> parentMap = new HashMap<>();
    Queue<Point> queue = new LinkedList<>(List.of(start));
    Set<Point> visited = new HashSet<>(List.of(start));

    while (!queue.isEmpty()) {
      Point current = queue.poll();
      if (current.equals(end)) {
        List<Point> path = new ArrayList<>();
        for (Point at = end; at != null; at = parentMap.get(at)) {
          path.add(at);
        }
        Collections.reverse(path);
        return path;
      }
      for (Direction direction : Direction.values()) {
        Point newPoint = new Point(Direction.getPoint(direction, current));
        if (isValidPoint(newPoint, grid) && !visited.contains(newPoint) && isPassable.test(grid[newPoint.y][newPoint.x])) {
          queue.add(newPoint);
          visited.add(newPoint);
          parentMap.put(newPoint, current);
        }
      }
    }
    return Collections.emptyList();
  }
}

