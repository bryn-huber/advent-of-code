package aoc;

public class Day01 {

  private static final System.Logger LOGGER = System.getLogger(Day01.class.getName());

  public static void main(String[] args) {

    String version = System.getProperty("java.version");
    LOGGER.log(System.Logger.Level.INFO, "Java version: {0}", version);


  }

}
