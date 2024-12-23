package aoc;

import aoc.utils.FileHelper;

public class Day12 {

  private static final System.Logger LOGGER = System.getLogger(Day12.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day12.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
