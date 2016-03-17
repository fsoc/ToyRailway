package fsoc;

public class SwitchPoint {
  private int trainSwitchPoint;
  private Gate gate;

  /**
   * A specific point on a switch.
   *
   * @param trainSwitchPoint the id of the switch
   * @param gate the gate A, B or C that this point is on
   */
  public SwitchPoint(int trainSwitchPoint, Gate gate) {
    this.trainSwitchPoint = trainSwitchPoint;
    this.gate = gate;
  }

  public Gate getGate() {
    return gate;
  }

  public int getSwitchPoint() {
    return trainSwitchPoint;
  }

  public boolean equals(SwitchPoint p) {
    if(trainSwitchPoint == p.trainSwitchPoint &&
        gate == p.gate) {
      return true;
    } else {
      return false;
    }
  }

}
