package aoc;

import java.awt.Point;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import aoc.utils.Day;
import aoc.utils.FileHelper;
import aoc.utils.GridHelper;

public class Day08 {

  private static final System.Logger LOGGER = System.getLogger(Day08.class.getName());
  private static final Day day = new Day();
  private static final GridHelper gridHelper = new GridHelper();
  
    public static void main(String[] args) {
  
      Path filePath = Paths.get("src/main/resources/day08_data.txt");
      List<String> input = FileHelper.readLinesInFile(filePath);
  
      LOGGER.log(System.Logger.Level.INFO, input);
  
      day.setName("Resonant Collinearity");
      day.setPart1(part1(input));
      day.setPart2(part2(input));

      day.printParts();

  }

  // get a grid
  // grid size
  // map of antennas
  // set of all the points
  // loop over frequencies

  public static int part1(List<String> input) {
    var grid = GridHelper.getCharGrid(input);
    int gridSize = grid.length;
    Map<Character, List<Point>> antennas = getAntennas(grid, gridSize);
    Set<Point> allPoints = new HashSet<>();
    for (var frequencies: antennas.entrySet()) {
      allPoints.addAll(getAntinodes(frequencies.getValue(), gridSize, 1));
    }
    return allPoints.size();
  }

  public static int part2(List<String> input) {

    return 0;
  }

  private static Map<Character, List<Point>> getAntennas(char[][] grid, int gridSize) {
    var antennas = new HashMap<Character, List<Point>>();
    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridSize; j++) {
            char c = grid[i][j];
            if (c != '.') {
                antennas.computeIfAbsent(c, k -> new ArrayList<>()).add(new Point(i, j));
            }
        }
    }
    return antennas;
}

private static Set<Point> getAntinodes(List<Point> antennas, int gridSize, int maxDistance) {
    var antinodes = new HashSet<Point>();
    for (int i = 0; i < antennas.size() - 1; i++) {
        for (int j = i + 1; j < antennas.size(); j++) {
            Point p1 = antennas.get(i);
            Point p2 = antennas.get(j);
            if (!p1.equals(p2)) {
                Point diff = new Point(p2.x - p1.x, p2.y - p1.y);
                for (int k = 1; k <= maxDistance; k++) {
                    addAntinode(antinodes, new Point(p1.x - k * diff.x, p1.y - k * diff.y), gridSize);
                    addAntinode(antinodes, new Point(p2.x + k * diff.x, p2.y + k * diff.y), gridSize);
                }
            }
        }
    }
    return antinodes;
}

private static void addAntinode(Set<Point> antinodes, Point antinode,  int gridSize) {
    if (GridHelper.isValidPoint(antinode, gridSize)) {
        antinodes.add(antinode);
    }
}
  
}
