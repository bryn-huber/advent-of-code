package aoc.utils;

import java.awt.Point;
import java.util.List;

public class GridHelper {

    public static char[][] getCharGrid(List<String> input) {
        return input.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }

    public static boolean isValidPoint(Point antinode, int gridSize) {
        return antinode.x >= 0 && antinode.x < gridSize && antinode.y >= 0 && antinode.y < gridSize;
    }
    
}
