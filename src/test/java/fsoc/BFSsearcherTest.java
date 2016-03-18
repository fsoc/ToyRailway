package fsoc;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

public class BFSsearcherTest {
  private Connection[] tiny;

  @Before
  public void initialize() {
    Connection[] connections = new Connection[3];

    SwitchPoint p1 = new SwitchPoint(1, Gate.A);
    SwitchPoint p2 = new SwitchPoint(1, Gate.B);

    connections[0] = new Connection(p1, p2);
    connections[1] = new Connection(p2, p1);


    tiny = connections;
  }

  @Test
  public void testPathGetterTinyFromA() {
    LinkedList<Connection> paths = BFSsearcher.getPaths(tiny, new SwitchPoint(1, Gate.A));

    LinkedList<Connection> correctAns = new LinkedList<Connection>();
    correctAns.add(tiny[1]);

    assertEquals(correctAns, paths);
  }

  @Test
  public void testPathGetterTinyFromB() {
    LinkedList<Connection> paths = BFSsearcher.getPaths(tiny, new SwitchPoint(1, Gate.B));

    LinkedList<Connection> correctAns = new LinkedList<Connection>();
    correctAns.add(tiny[0]);

    assertEquals(correctAns, paths);
  }

  @Test
  public void testPathGetterTinyFromC() {
    LinkedList<Connection> paths = BFSsearcher.getPaths(tiny, new SwitchPoint(1, Gate.C));

    LinkedList<Connection> correctAns = new LinkedList<Connection>();
    correctAns.add(tiny[0]);

    assertEquals(correctAns, paths);
  }

}
