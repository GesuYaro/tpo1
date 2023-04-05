package shagiev.dobryagin.functions;

import org.junit.jupiter.api.Test;
import shagiev.dobryagin.functions.Dijkstra.SearchResult;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {

  private static final Map<Integer, Map<Integer, Integer>> graph = Map.of(
    0, Map.of(3, 6, 4, 9),
    1, Map.of(3, 3, 6, 1),
    2, Map.of(4, 9, 6, 3),
    3, Map.of(0, 6, 1, 3, 7, 3),
    4, Map.of(0, 9, 2, 9),
    5, Map.of(7, 7),
    6, Map.of(1, 1, 2, 3, 7, 9),
    7, Map.of(3, 3, 5, 7, 6, 9)
  );

  private static final Map<Integer, Map<Integer, Integer>> threeComponentsGraph = Map.of(
    -1, Map.of(-2, 2),
    -2, Map.of(-1, 2),
    1, Map.of(2, 3),
    2, Map.of(1, 3),
    0, Map.of()
  );

  @Test
  void search() {
    var expected = new SearchResult(List.of(0, 3, 1, 6, 2), 13);

    var actual = Dijkstra.search(graph, 0, 2);

    assertEquals(expected, actual);
  }

  @Test
  void search_noWay() {
    var expected = new SearchResult(emptyList(), 0);

    var actual = Dijkstra.search(threeComponentsGraph, -1, 1);

    assertEquals(expected, actual);
  }

  @Test
  void search_noWay_isolatedNode() {
    var expected = new SearchResult(emptyList(), 0);

    var actual = Dijkstra.search(threeComponentsGraph, 0, 1);

    assertEquals(expected, actual);
  }

  @Test
  void search_noWay_nonexistentNodes() {
    var expected = new SearchResult(emptyList(), 0);

    var actual = Dijkstra.search(threeComponentsGraph, 100, 101);

    assertEquals(expected, actual);
  }
}