package aoc;

import aoc.utils.FileHelper;

public class Day18 {

  private static final System.Logger LOGGER = System.getLogger(Day18.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day18.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
