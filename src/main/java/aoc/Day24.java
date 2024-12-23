package aoc;

import aoc.utils.FileHelper;

public class Day24 {

  private static final System.Logger LOGGER = System.getLogger(Day24.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day24.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
