package aoc;

import aoc.utils.FileHelper;

public class Day22 {

  private static final System.Logger LOGGER = System.getLogger(Day22.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day22.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
