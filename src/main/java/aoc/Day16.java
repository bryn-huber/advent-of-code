package aoc;

import aoc.utils.FileHelper;

public class Day16 {

  private static final System.Logger LOGGER = System.getLogger(Day16.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day16.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
