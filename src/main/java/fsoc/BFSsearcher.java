package fsoc;
import java.util.LinkedList;
import java.util.Iterator;

public class BFSsearcher {
  /**
   * Do a BFS search for the shortest loop returning to the 1A switch point
   * or show that it is impossible by an exhaustive search.
   *
   * The walk is a way of keeping track of the current path when arriving at a
   * circle in our train ride through the switches.
   *
   * @param switches a datastructure with all switches and their connections
   * @return the gate selections needed to take in order to arrive at 1A again
   */
  public static String search(Connection[][] switches) {
    // The queues consists of walks through our train models of walks through our train model
    LinkedList<LinkedList<Connection>> queue = new LinkedList<LinkedList<Connection>>();

    // Populate our queue with an empty walk from the connections of switch 1, gate A
    populateQueue(queue, switches[0], Gate.A, null);

    while (!queue.isEmpty()) {
      LinkedList<Connection> walk = queue.remove();

      // Start from the end of our walk of connections
      Connection current = walk.getLast();

      SwitchPoint from = current.getFrom();
      SwitchPoint to = current.getTo();

      // If we made a circle and are going back to switch 1, gate A
      if (to.getSwitchPoint() == 1 && to.getGate() == Gate.A) {

        Iterator<Connection> it = walk.iterator();
        while (it.hasNext()) {
          Connection c = it.next();
          from = c.getFrom();
          to = c.getTo();

          System.out.println("walk: from: " + from.getSwitchPoint() + " " + from.getGate() +" to:" + to.getSwitchPoint() + " " + to.getGate());
        }
        return "B";
      }

      // Otherwise follow the connections to destination and send our current walk
      populateQueue(queue, switches[to.getSwitchPoint() - 1], to.getGate(), walk);
    }

    return "Impossible";
  }

  /**
   * Add different possible paths by getting possible paths for this connection
   * and its gate, and adding every one of them to a new possible path on the
   * queue.
   * @param queue the queue of walks
   * @param connections the current connections from this switch
   * @param currentGate the gate we are arriving from
   * @param walk the current walk in our graph, a new walk is generated if this param is null
   */
  private static void populateQueue(LinkedList<LinkedList<Connection>> queue,
      Connection[] connections,
      Gate currentGate,
      LinkedList<Connection> walk) {

    LinkedList<Connection> possiblePaths = getPaths(connections, currentGate);
    LinkedList<Connection> newWalk;

    // Get the possible paths
    Iterator<Connection> it = possiblePaths.iterator();

    while (it.hasNext()) {
      // Add this path to our walk and add it to the queue.
      if (walk == null) {
        newWalk = new LinkedList<Connection>();
      } else {
        newWalk = new LinkedList<Connection>(walk);
      }
      newWalk.add(it.next());
      queue.add(newWalk);
    }

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
