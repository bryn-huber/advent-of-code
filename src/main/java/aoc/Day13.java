package aoc;

import aoc.utils.FileHelper;

public class Day13 {

  private static final System.Logger LOGGER = System.getLogger(Day13.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day13.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
