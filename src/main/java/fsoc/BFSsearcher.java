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
  public static String search(Connection[][] switches) {
    queue.add(startingPoint.getSwitchPoint());

    while (!queue.isEmpty()) {
      //TODO: queue needs to contain connections instead of switchPoints
      //TODO: getPaths
      //TODO: circleDetection for when to: 1A
      //TODO: Keep track of the path-string recursivly and print when circle is found
      //TODO: enqueue them

    }

    return "B";
  }

  /**
   * Get paths for this switch given where we came from and its
   * connections to other switches.
   * If you arrive from a A point then you can exit the switch from B,C
   * otherwise only throught an A gate.
   * @param connections An array with up to three connections from this switch
   * @param currentGate The point we currently reside at (came through)
   */
  public static LinkedList<Connection> getPaths(Connection[] connections, Gate currentGate) {
    LinkedList<Connection> paths = new LinkedList<Connection>();

    if (currentGate == Gate.A) {
      // Exit from B & C (not A, because that will be going backwards)
      paths = addUnvisited(connections[1], paths);
      paths = addUnvisited(connections[2], paths);
    } else {
      // Exit from A
      paths = addUnvisited(connections[0], paths);
    }
    return paths;
  }

  private static LinkedList<Connection> addUnvisited(Connection conn, LinkedList<Connection> paths) {
    if (conn != null && !conn.visited()) {
      conn.visit();
      paths.add(conn);
    }

    return paths;
  }
}
