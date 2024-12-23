package aoc;

import aoc.utils.FileHelper;

public class Day05 {

  private static final System.Logger LOGGER = System.getLogger(Day05.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day05.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
