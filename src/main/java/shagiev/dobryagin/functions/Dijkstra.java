package shagiev.dobryagin.functions;

import java.util.*;

public class Dijkstra {
  public static class SearchResult {
    public final List<Integer> nodes;
    public final int weight;

    public SearchResult(List<Integer> nodes, int weight) {
      this.nodes = nodes;
      this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
      if(this == obj) return true;
      if(obj == null || obj.getClass() != this.getClass()) return false;
      SearchResult searchResult = (SearchResult) obj;
      return this.nodes.equals(searchResult.nodes) && this.weight == searchResult.weight;
    }
  }

  public static SearchResult search(Map<Integer, Map<Integer, Integer>> ways, int start, int finish) {
    var queue = new TreeSet<>(comparatorForQueue);
    var distances = new HashMap<Integer, Integer>();
    var parentNodes = new HashMap<Integer, Integer>();
    distances.put(start, 0);
    queue.add(new AbstractMap.SimpleEntry<>(start, 0));

    while (!queue.isEmpty() && queue.first().getKey() != finish) {
      var firstEntry = queue.first();
      var from = firstEntry.getKey();
      var dist = firstEntry.getValue();
      queue.remove(firstEntry);

      if(!ways.containsKey(from)) continue;
      for (var toEntry : ways.get(from).entrySet()) {
        var to = toEntry.getKey();
        var distDiff = toEntry.getValue();
        if (distances.containsKey(to) && dist + distDiff >= distances.get(to))
          continue;

        distances.put(to, dist + distDiff);
        parentNodes.put(to, from);
        queue.add(new AbstractMap.SimpleEntry<>(to, dist + distDiff));
      }
    }

    if(queue.isEmpty()) return new SearchResult(Collections.emptyList(), 0);

    var wayFromStartToFinish = new LinkedList<Integer>();
    var currentNode = finish;
    wayFromStartToFinish.add(finish);
    int resultWayWeight = 0;

    while (currentNode != start) {
      var prevNode = parentNodes.get(currentNode);
      resultWayWeight += ways.get(prevNode).get(currentNode);
      currentNode = prevNode;
      wayFromStartToFinish.add(currentNode);
    }
    Collections.reverse(wayFromStartToFinish);

    return new SearchResult(wayFromStartToFinish, resultWayWeight);
  }

  private static final Comparator<Map.Entry<Integer, Integer>> comparatorForQueue = (o1, o2) -> o1.getValue().compareTo(o2.getValue()) != 0
    ? o1.getValue().compareTo(o2.getValue())
    : o1.getKey().compareTo(o2.getKey());
}