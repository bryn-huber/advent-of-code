package aoc;

import aoc.utils.FileHelper;

public class Day09 {

  private static final System.Logger LOGGER = System.getLogger(Day09.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day09.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
