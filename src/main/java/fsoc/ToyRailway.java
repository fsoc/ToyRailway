/**
 * https://spotify.kattis.com/problems/railway
 */

package fsoc;
import java.util.Scanner;

public class ToyRailway  {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\s");

    Connection[][] trainSwitches = graphCreator(scanner);
//    System.out.println(BFSsearcher.search(trainSwitches));
  }

  /**
   * Create a Graph containing all switches in an array, where every
   * element is an array with 0 to 3 connections to other switches
   */
  public static Connection[][] graphCreator(Scanner scanner) {
    // Read the first line denoting "switches connections"
    int switches = scanner.nextInt();
    int connections = scanner.nextInt();

    // Yes, we hardcode for 3 gates...
    Connection[][] trainSwitches = new Connection[switches][3];

    // Read the rest of lines containing the actual connections
    while (scanner.hasNext()) {
      String s1 = scanner.next();
      int trainSwitch1 = Integer.parseInt(s1.substring(0, s1.length() - 1));
      String gate1 = s1.substring(s1.length() - 1);
      String s2 = scanner.next();
      int trainSwitch2 = Integer.parseInt(s2.substring(0, s2.length() - 1));
      String gate2 = s2.substring(s2.length() - 1);

      addConnection(trainSwitch1, trainSwitch2, gate1, gate2, trainSwitches);

    }
    scanner.close();

    return trainSwitches;
  }

  // Add two connections for every row since our graph is bidirectional
  private static void addConnection(int trainSwitch1, int trainSwitch2,
      String gate1, String gate2,
      Connection[][] trainSwitches) {

    SwitchPoint p1 = new SwitchPoint(trainSwitch1, Gate.valueOf(gate1));
    SwitchPoint p2 = new SwitchPoint(trainSwitch2, Gate.valueOf(gate2));

    trainSwitches[trainSwitch1-1][p1.getGate().getValue()] = new Connection(p1, p2);
    trainSwitches[trainSwitch2-1][p2.getGate().getValue()] = new Connection(p2, p1);

  }

}
