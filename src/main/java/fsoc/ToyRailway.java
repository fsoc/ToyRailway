/**
 * https://spotify.kattis.com/problems/railway
 */

package fsoc;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;

public class ToyRailway  {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    io.println(BFSsearch(System.in));
    io.flush();
    io.close();
  }

  public static String BFSsearch(InputStream in) {
    Connection[][] trainSwitches = graphCreator(in);
    return BFSsearcher.search(trainSwitches);
  }

  /**
   * Create a Graph containing all switches in an array, where every
   * element is an array with 0 to 3 connections to other switches
   */
  public static Connection[][] graphCreator(InputStream in) {
    Kattio io = new Kattio(in, System.out);

    // Read the first line denoting "switches connections"

    int switches = io.getInt();
    int connections = io.getInt();

    // Yes, we hardcode for 3 gates...
    Connection[][] trainSwitches = new Connection[switches][3];

    // Read the rest of lines containing the actual connections
    while (io.hasMoreTokens()) {
      String from = io.getWord();
      int trainSwitch1 = Integer.parseInt(from.substring(0, from.length() - 1));
      String gate1 = from.substring(from.length() - 1);

      String to = io.getWord();
      int trainSwitch2 = Integer.parseInt(to.substring(0, to.length() - 1));
      String gate2 = to.substring(to.length() - 1);
      addConnection(trainSwitch1, trainSwitch2, gate1, gate2, trainSwitches);
    }

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
