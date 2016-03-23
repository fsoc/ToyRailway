package fsoc;
import java.util.LinkedList;
import java.util.Iterator;

public class BFSsearcher {
  private static final SwitchPoint startingPoint = new SwitchPoint(1, Gate.A);
  private static LinkedList<LinkedList<Connection>> queue;

  /**
   * Do a BFS search for the shortest loop returning to the 1A switch point
   * or show that it is impossible by an exhaustive search.
   *
   * @param switches a datastructure with all switches and their connections
   * @return the gate selections needed to take in order to arrive at 1A again
   */
  public static String search(Connection[][] switches) {
    queue = new LinkedList<LinkedList<Connection>>();

    LinkedList<Connection> possiblePaths = getPaths(switches[0], Gate.A);

    Iterator<Connection> it = possiblePaths.iterator();
    while (it.hasNext()) {
      LinkedList<Connection> newPath = new LinkedList<Connection>();
      newPath.add(it.next());
      queue.add(newPath);
    }

    while (!queue.isEmpty()) {
      LinkedList<Connection> path = queue.remove();

      Connection current = path.getLast();

      SwitchPoint from = current.getFrom();
      SwitchPoint to = current.getTo();

      System.out.println("current: from: " + from.getSwitchPoint() + " " + from.getGate() +" to:" + to.getSwitchPoint() + " " + to.getGate());

      if (to.getSwitchPoint() == 1 && to.getGate() == Gate.A) {

        it = path.iterator();
        while (it.hasNext()) {
          Connection c = it.next();
          from = c.getFrom();
          to = c.getTo();

          System.out.println("path: from: " + from.getSwitchPoint() + " " + from.getGate() +" to:" + to.getSwitchPoint() + " " + to.getGate());
        }
        return "B";
      }

      possiblePaths = getPaths(switches[to.getSwitchPoint() - 1], to.getGate());

      it = possiblePaths.iterator();
      while (it.hasNext()) {
        LinkedList<Connection> newPath = new LinkedList<Connection>(path);
        newPath.add(it.next());
        queue.add(newPath);
      }

    }

    return "Impossible";
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
