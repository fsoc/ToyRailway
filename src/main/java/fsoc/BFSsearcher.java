package fsoc;
import java.util.LinkedList;
import java.util.Iterator;

public class BFSsearcher {
  /**
   * Do a BFS search for the shortest loop returning to the 1A switch point
   * or show that it is impossible by an exhaustive search.
   *
   * @param switches a data structure with all switches and their connections
   * @return the gate selections needed to take in order to arrive at 1A again
   */
  public static String search(Connection[][] switches) {
    // The queues consists of walks through our train models of walks through our train model
    LinkedList<Connection> queue = new LinkedList<Connection>();

    // Populate our queue with connections from switch 0, gate A
    queue.addAll(getPaths(switches[0], Gate.A, 0, Gate.A));

    while (!queue.isEmpty()) {
      Connection current = queue.remove();

      SwitchPoint from = current.getFrom();
      SwitchPoint to = current.getTo();

      // If we made a circle and are going back to switch 0, gate A
      if (to.getSwitchPoint() == 0 && to.getGate() == Gate.A) {

        return printGates(switches, from.getSwitchPoint(), from.getGate());
      }

      // Otherwise follow the connections to destination and send where we came from 
      queue.addAll(getPaths(switches[to.getSwitchPoint()], to.getGate(),
          from.getSwitchPoint(), from.getGate()));
    }

    // If the queue is empty but Switch 0, gate A is not reached, then it must be impossible
    return "Impossible";
  }

  /**
   * Output a string of N characters,
   * each being either B or C and giving the state of switch 0,1,...,N, respectively.
   * Default to B.
   * @param switches the datastructure with switches
   * @param startSwitch the switch to start backtracking from
   * @param startGate the gate of that switch to start backtracking from
   */
  private static String printGates(Connection[][] switches, int startSwitch, Gate startGate) {
    boolean[] shouldBeC = new boolean[switches.length];

    backtrack(shouldBeC, switches, startSwitch, startGate);

    String ans = "";
    for (int i = 0; i < switches.length; i++) {
      if (shouldBeC[i]) {
        ans += "C";
      } else {
        ans += "B";
      }
    }
    return ans;
  }

  // Backtrack our path by following ancestors
  private static void backtrack(boolean[] shouldBeC, Connection[][] switches,
      int ancestorSwitch, Gate ancestorGate) {

    while (ancestorSwitch != 0 || ancestorGate != Gate.A) {
      if (ancestorGate == Gate.C) {
        shouldBeC[ancestorSwitch] = true;
      }

      Connection current = switches[ancestorSwitch][ancestorGate.getValue()];
      ancestorSwitch = current.getAncestorSwitch();
      ancestorGate = current.getAncestorGate();
    }
  }

  /**
   * Get paths for this switch given where we came from and its
   * connections to other switches.
   * If you arrive from a A point then you can exit the switch from B,C
   * otherwise only throught an A gate.
   * @param connections An array with up to three connections from this switch
   * @param currentGate The point we currently reside at (came through)
   * @param ancestorSwitch The switch we came from
   * @param ancestorGate The gate we came from
   */
  public static LinkedList<Connection> getPaths(Connection[] connections, Gate currentGate,
      int ancestorSwitch, Gate ancestorGate) {
    LinkedList<Connection> paths = new LinkedList<Connection>();

    if (currentGate == Gate.A) {
      // Exit from B & C (not A, because that will be going backwards)
      paths = addUnvisited(connections[1], paths, ancestorSwitch, ancestorGate);
      paths = addUnvisited(connections[2], paths, ancestorSwitch, ancestorGate);
    } else {
      // Exit from A
      paths = addUnvisited(connections[0], paths, ancestorSwitch, ancestorGate);
    }
    return paths;
  }

  private static LinkedList<Connection> addUnvisited(Connection conn, LinkedList<Connection> paths,
      int ancestorSwitch, Gate ancestorGate) {
    if (conn != null && !conn.visited()) {
      conn.visit(ancestorSwitch, ancestorGate);
      paths.add(conn);
    }

    return paths;
  }
}
