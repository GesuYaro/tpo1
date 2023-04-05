package shagiev.dobryagin.functions;

import org.junit.jupiter.api.Test;
import shagiev.dobryagin.functions.Dijkstra.SearchResult;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    var expectedTraversal = List.of(
      new AbstractMap.SimpleEntry<>(0, List.of(3, 4)),
      new AbstractMap.SimpleEntry<>(3, List.of(0, 7, 1)),
      new AbstractMap.SimpleEntry<>(1, List.of(6, 3)),
      new AbstractMap.SimpleEntry<>(4, List.of(2, 0)),
      new AbstractMap.SimpleEntry<>(7, List.of(3, 5, 6)),
      new AbstractMap.SimpleEntry<>(6, List.of(7, 1, 2))
    );

    var expected = new SearchResult(List.of(0, 3, 1, 6, 2), 13, expectedTraversal);

    var actual = Dijkstra.search(graph, 0, 2);

    assertNotNull(actual.traversal);
    assertEquals(expected, actual);
    checkTraversals(expectedTraversal, actual.traversal);
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

  private void checkTraversals(
    List<? extends Map.Entry<Integer, List<Integer>>> expected,
    List<? extends Map.Entry<Integer, List<Integer>>> actual
  ) {
    assertEquals(expected.size(), actual.size());

    for (int i = 0; i < expected.size(); i++) {
      var stageFromExpected = expected.get(i);
      var stageFromActual = actual.get(i);
      assertEquals(stageFromExpected.getKey(), stageFromActual.getKey());
      assertEquals(new HashSet<>(stageFromExpected.getValue()), new HashSet<>(stageFromActual.getValue()));
    }
  }
}