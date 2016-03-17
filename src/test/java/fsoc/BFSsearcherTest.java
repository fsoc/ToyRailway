package fsoc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.LinkedList;

public class BFSsearcherTest extends TestCase {
  public BFSsearcherTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(BFSsearcherTest.class);
  }

  public void testPathGetterTiny() {
//    LinkedList<Connection> connections = new LinkedList<Connection>();
//
//    SwitchPoint p1 = new SwitchPoint(1, Gate.A);
//    SwitchPoint p2 = new SwitchPoint(1, Gate.B);
//    connections.add(new Connection(p2, p1));
//    connections.add(new Connection(p1, p2));
//
//    LinkedList<Integer> paths = BFSsearcher.getPaths(connections, p1);
//    assertEquals(1, (int) paths.size());
//    assertEquals(1, (int) paths.getFirst());
  }
}
