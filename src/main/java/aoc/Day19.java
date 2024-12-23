package aoc;

import aoc.utils.FileHelper;

public class Day19 {

  private static final System.Logger LOGGER = System.getLogger(Day19.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day19.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
