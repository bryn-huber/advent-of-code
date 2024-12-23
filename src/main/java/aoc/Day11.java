package aoc;

import aoc.utils.FileHelper;

public class Day11 {

  private static final System.Logger LOGGER = System.getLogger(Day11.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day11.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
