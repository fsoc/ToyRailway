/**
 * https://spotify.kattis.com/problems/railway
 */

package fsoc;
import java.util.Scanner;
import java.util.LinkedList;

public class ToyRailway  {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\s");

    LinkedList<Connection>[] vertices = graphCreator(scanner);
  }

  /**
   * Create a Graph containing all SwitchPointes in an array, where every
   * switch is a LinkedList of its connections to other points on a switch
   */
  public static LinkedList<Connection>[] graphCreator(Scanner scanner) {
    // Read the first line denoting "switches connections"
    int switches = scanner.nextInt();
    int connections = scanner.nextInt();

    LinkedList<Connection>[] vertices = new LinkedList[switches];

    while (scanner.hasNext()) {
      String s1 = scanner.next();
      int connection1 = Integer.parseInt(s1.substring(0, s1.length() - 1));
      String track1 = s1.substring(s1.length() - 1);
      String s2 = scanner.next();
      int connection2 = Integer.parseInt(s2.substring(0, s2.length() - 1));
      String track2 = s2.substring(s2.length() - 1);

      addConnection(connection1, connection2, track1, track2, vertices);

    }
    scanner.close();

    return vertices;
  }

  private static void addConnection(int connection1, int connection2,
      String track1, String track2,
      LinkedList<Connection>[] vertices) {

    SwitchPoint p1 = new SwitchPoint(connection1, Gate.valueOf(track1));
    SwitchPoint p2 = new SwitchPoint(connection2, Gate.valueOf(track2));

    initiateLinkedList(connection1, vertices);
    vertices[connection1-1].add(new Connection(p1, p2));

    initiateLinkedList(connection2, vertices);
    vertices[connection2-1].add(new Connection(p2, p1));
  }

  private static void initiateLinkedList(int connection,
      LinkedList<Connection>[] vertices) {
    if (vertices[connection-1] == null) {
      // Initiate if not already initiated
      vertices[connection-1] = new LinkedList<Connection>();
    }
  }

}
