package aoc;

import aoc.utils.FileHelper;

public class Day08 {

  private static final System.Logger LOGGER = System.getLogger(Day08.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day08.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
