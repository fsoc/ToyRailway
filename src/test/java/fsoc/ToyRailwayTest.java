package fsoc;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class ToyRailwayTest {
  @Test
  public void testGraphCreation() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("examples/sample3.in"));

    Connection[][] trainSwitches = ToyRailway.graphCreator(scanner);

    Connection[][] correctAnswer = {
      {
        null,
        new Connection(
            new SwitchPoint(1, Gate.B),
            new SwitchPoint(2, Gate.A)),
        null
      }, {
        new Connection(
            new SwitchPoint(2, Gate.A),
            new SwitchPoint(1, Gate.B)),
        null,
        null
      }
    };

    assertTrue(Arrays.deepEquals(trainSwitches, correctAnswer));
  }

  @Test
  public void testBFSsearchSmall() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("examples/sample4.in"));
    assertEquals("B", ToyRailway.BFSsearch(scanner));
  }

  @Test
  public void testBFSsearchImposs() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("examples/sample2.in"));
    assertEquals("Impossible", ToyRailway.BFSsearch(scanner));
  }

}
