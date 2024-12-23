package aoc;

import aoc.utils.FileHelper;

public class Day17 {

  private static final System.Logger LOGGER = System.getLogger(Day17.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day17.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
