package fsoc;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.util.Arrays;

public class ToyRailwayTest {
  @Test
  public void testGraphCreation() {
    //TODO: read from file:
    Scanner scanner = new Scanner("2 1\n1B 2A");
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

}
