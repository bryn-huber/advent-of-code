package aoc;

import aoc.utils.FileHelper;

public class Day10 {

  private static final System.Logger LOGGER = System.getLogger(Day10.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day10.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
