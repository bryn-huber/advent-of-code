package aoc;

import aoc.utils.FileHelper;

public class Day04 {

  private static final System.Logger LOGGER = System.getLogger(Day04.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day04.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
