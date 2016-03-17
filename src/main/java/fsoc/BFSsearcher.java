package fsoc;
import java.util.LinkedList;

public class BFSsearcher {
  private static final SwitchPoint startingPoint = new SwitchPoint(1, Gate.A);
  private static LinkedList<Integer> queue = new LinkedList<Integer>();

  /**
   * Do a BFS search for the shortest loop returning to the 1A switch point
   * or show that it is impossible by an exhaustive search.
   *
   * @param switches a datastructure with all switches and their connections
   * @return the gate selections needed to take in order to arrive at 1A again
   */
  public static String search(LinkedList<Connection>[] switches) {
    queue.add(startingPoint.getSwitchPoint());

    while (!queue.isEmpty()) {
      //TODO: getPaths
      //TODO: mark them as visited
      //TODO: enqueue them

    }

    return "B";
  }

  /**
   * If you arrive from a A point then you can exit the switch from B,C
   * otherwise only throught an A gate.
   */
  public static void getPaths(LinkedList<Connection> connections,
      SwitchPoint currentPoint) {

//    ListIterator<Collection> iterator = connections.iterator();
//
//    while (iterator.hasNext()) {
//      Connection c = iterator.next();
//
//      if (currentPoint.getGate() == Gate.A) {
//        // Exit from B & C (not A, because that will be going backwards)
//        if (c.getFrom().getGate() != Gate.A) {
//          paths.add(c);
//        }
//      }
//
//    }



  }

}
