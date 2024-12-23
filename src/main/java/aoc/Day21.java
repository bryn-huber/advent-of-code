package aoc;

import aoc.utils.FileHelper;

public class Day21 {

  private static final System.Logger LOGGER = System.getLogger(Day21.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day21.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
