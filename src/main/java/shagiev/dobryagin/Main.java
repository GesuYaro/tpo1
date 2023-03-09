package shagiev.dobryagin;

import shagiev.dobryagin.functions.ArctgFunction;
import shagiev.dobryagin.functions.Dijkstra;

import java.util.Map;

public class Main {
  public static void main(String[] args) {
    var arctgFunction = new ArctgFunction();
    double res = arctgFunction.calculate(1, 10);
    System.out.println(res);

    Map<Integer, Map<Integer, Integer>> ways = Map.of(
      0, Map.of(3, 6, 4, 9),
      1, Map.of(3, 3, 6, 1),
      2, Map.of(4, 9, 6, 3),
      3, Map.of(0, 6, 1, 3, 7, 3),
      4, Map.of(0, 9, 2, 9),
      5, Map.of(7, 7),
      6, Map.of(1, 1, 2, 3, 7, 9),
      7, Map.of(3, 3, 5, 7, 6, 9)
    );

    System.out.println(Dijkstra.search(ways, 0, 7));
  }
}