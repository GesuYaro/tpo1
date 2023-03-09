package shagiev.dobryagin.functions;

import java.util.*;

public class Dijkstra {
  public static List<Integer> search(Map<Integer, Map<Integer, Integer>> ways, int start, int finish) {
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

    if(queue.isEmpty()) return Collections.emptyList();

    var wayFromStartToFinish = new LinkedList<Integer>();
    var currentNode = finish;
    wayFromStartToFinish.add(finish);
    while (currentNode != start) {
      currentNode = parentNodes.get(currentNode);
      wayFromStartToFinish.add(currentNode);
    }
    Collections.reverse(wayFromStartToFinish);

    return wayFromStartToFinish;
  }

  private static final Comparator<Map.Entry<Integer, Integer>> comparatorForQueue = (o1, o2) -> o1.getValue().compareTo(o2.getValue()) != 0
    ? o1.getValue().compareTo(o2.getValue())
    : o1.getKey().compareTo(o2.getKey());
}