/**
 * https://spotify.kattis.com/problems/railway
 */

package fsoc;
import java.util.Scanner;

public class ToyRailway  {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\s");

    int switches = scanner.nextInt();
    int connections = scanner.nextInt();

    while (scanner.hasNext()) {
      String s1 = scanner.next();
      int connection1 = Integer.parseInt(s1.substring(0, s1.length() - 1));
      String track1 = s1.substring(s1.length() - 1);
      String s2 = scanner.next();
      int connection2 = Integer.parseInt(s2.substring(0, s2.length() - 1));
      String track2 = s2.substring(s2.length() - 1);

    }

    scanner.close();
  }
}
