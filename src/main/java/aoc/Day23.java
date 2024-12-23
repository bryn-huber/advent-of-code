package aoc;

import aoc.utils.FileHelper;

public class Day23 {

  private static final System.Logger LOGGER = System.getLogger(Day23.class.getName());

  public static void main(String[] args) {

    String inputData = FileHelper.readFile(Day23.class.getSimpleName());

    LOGGER.log(System.Logger.Level.INFO, inputData);

  }
  
}
