package aoc.utils;

public class Day {

    private Object part1;
    private Object part2;
    
    public void setPart1(int part1) {
        this.part1 = part1;
    }
    
    public void setPart2(int part2) {
            this.part2 = part2;
    }

    public void printParts() {
        if (part1 != null && part2 != null) {
            System.out.println("Part 1: " + part1);
            System.out.println("Part 2: " + part2);
        } else if (part1 != null) {
            System.out.println("Part 1: " + part1);
        }
    }

}
