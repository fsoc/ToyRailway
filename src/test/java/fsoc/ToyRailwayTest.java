package fsoc;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.lang.StringBuilder;

public class ToyRailwayTest {
  @Test
  public void testGraphCreation() throws IOException {
    InputStream file = new FileInputStream("examples/sample3.in");

    Connection[][] trainSwitches = ToyRailway.graphCreator(file);

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

    file.close();
  }

  @Test
  public void testBFSsearchSmall() throws IOException {
    InputStream file = new FileInputStream(new File("examples/sample4.in"));
    assertEquals("B", ToyRailway.BFSsearch(file));
    file.close();
  }

  @Test
  public void testBFSsearchImposs() throws IOException {
    executeTextFiles("examples/sample2.in", "examples/sample2.ans");
  }

  @Test
  public void testBFSsearchExample() throws IOException {
    executeTextFiles("examples/sample1.in", "examples/sample1.ans");
  }

  public void executeTextFiles(String indata, String answer) throws IOException {
    InputStream input = new FileInputStream(indata);
    InputStream answerStream = new FileInputStream(answer);
    String answerString = streamToString(answerStream);

    assertEquals(answerString, ToyRailway.BFSsearch(input));

    input.close();
    answerStream.close();
  }

  static String streamToString(java.io.InputStream is) throws IOException {
    StringBuilder builder = new StringBuilder();
    int ch;
    while ((ch = is.read()) != -1){
      if (ch != '\n')
        builder.append((char)ch);
    }
    return builder.toString();
  }

}
