package aoc;

import aoc.utils.FileHelper;

public class Day07 {

  private static final System.Logger LOGGER = System.getLogger(Day07.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day07.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
