package aoc;

import aoc.utils.FileHelper;

public class Day06 {

  private static final System.Logger LOGGER = System.getLogger(Day06.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day06.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
