package aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.Day;
import aoc.utils.FileHelper;

public class Day05 {

  private static final System.Logger LOGGER = System.getLogger(Day05.class.getName());
  private static final Day day = new Day();

  public static void main(String[] args) {

    Path filePath = Paths.get("src/main/resources/day05_data.txt");
    List<String> input = FileHelper.readLinesInFile(filePath);

    LOGGER.log(System.Logger.Level.INFO, input);

    day.setName("Print Queue");
    day.setPart1(part1(input));
    day.setPart2(part2(input));

    day.printParts();

  }

  public static int part1(List<String> input) {
    Map<Integer, List<Integer>> rules = parseRules(input);
    List<List<Integer>> updates = parseUpdates(input);
    return updates.stream()
            .filter(update -> isValid(rules, update))
            .mapToInt(update -> update.get(update.size() / 2))
            .sum();
  }

  public static int part2(List<String> input) {
    Map<Integer, List<Integer>> rules = parseRules(input);
    List<List<Integer>> updates = parseUpdates(input);
    return updates.stream()
            .filter(update -> !isValid(rules, update))
            .mapToInt(update -> orderUpdate(rules, update).get(update.size() / 2))
            .sum();
  }

  private static List<Integer> orderUpdate(Map<Integer, List<Integer>> rules, List<Integer> update) {
      int[] fixed = new int[update.size()];
      for (int page : update) {
          int fixedIndex = 0;
          for (var entry : rules.entrySet()) {
              if (entry.getValue().contains(page) && update.contains(entry.getKey())) {
                  fixedIndex++;
              }
          }
          fixed[fixedIndex] = page;
      }
      return Arrays.stream(fixed).boxed().toList();
  }

  private static boolean isValid(Map<Integer, List<Integer>> rules, List<Integer> update) {
      for (int i = 0; i < update.size(); i++) {
          var key = update.get(i);
          if (!rules.containsKey(key)) {
              return i == update.size() - 1;
          }
          for (int page : update.subList(i + 1, update.size())) {
              if (!rules.get(key).contains(page)) {
                  return false;
              }
          }
      }
      return true;
  }

  private static List<List<Integer>> parseUpdates(List<String> input) {
      List<List<Integer>> updates = new ArrayList<>();
      boolean rules = true;
      for (String line : input) {
          if (line.isEmpty()) {
              rules = false;
          } else if (!rules) {
              updates.add(Arrays.stream(line.split(","))
                      .map(Integer::parseInt)
                      .toList());
          }
      }
      return updates;
    }

   private static Map<Integer, List<Integer>> parseRules(List<String> input) {
      Map<Integer, List<Integer>> rules = new HashMap<>();
      for (String line : input) {
          if (line.isEmpty()) {
              break;
          }
          String[] parts = line.split("\\|");
          rules.computeIfAbsent(Integer.valueOf(parts[0]), k -> new ArrayList<>()).add(Integer.valueOf(parts[1]));
      }
      return rules;
    }
  
}
