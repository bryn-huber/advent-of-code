package aoc;

import aoc.utils.FileHelper;

public class Day15 {

  private static final System.Logger LOGGER = System.getLogger(Day15.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day15.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
