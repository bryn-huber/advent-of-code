package aoc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

  public static void main(String[] args) {
    // TODO: add test code here
  }


  public static String readFile(String day) {
    Path filePath = Paths.get("src/main/resources/"+day.toLowerCase()+"_data.txt");
    try {
      return Files.readString(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
