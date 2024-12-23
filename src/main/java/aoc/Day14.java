package aoc;

import aoc.utils.FileHelper;

public class Day14 {

  private static final System.Logger LOGGER = System.getLogger(Day14.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day14.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}