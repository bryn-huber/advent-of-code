package aoc;

import aoc.utils.FileHelper;

public class Day20 {

  private static final System.Logger LOGGER = System.getLogger(Day20.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day20.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
