package fsoc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.LinkedList;
import java.util.Scanner;

public class ToyRailwayTest extends TestCase {
  public ToyRailwayTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(ToyRailwayTest.class);
  }

  public void testGraphCreation() {
    //TODO: read from file:
    Scanner scanner = new Scanner("2 1\n1B 2A");
    LinkedList<Connection>[] switches = ToyRailway.graphCreator(scanner);

    LinkedList<Connection>[] correctAnswer = new LinkedList[2];
    correctAnswer[0] = new LinkedList<Connection>();
    correctAnswer[1] = new LinkedList<Connection>();

    correctAnswer[0].add(new Connection(
          new Point(1, Gate.B),
          new Point(2, Gate.A)));
    correctAnswer[1].add(new Connection(
          new Point(2, Gate.A),
          new Point(1, Gate.B)));

    assertTrue(switches[0].getFirst().equals(correctAnswer[0].getFirst()));
    assertTrue(switches[1].getFirst().equals(correctAnswer[1].getFirst()));
  }
}
