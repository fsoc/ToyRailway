package fsoc;

public class Point {
  private int trainSwitch;
  private Gate gate;
  
  public Point(int trainSwitch, Gate gate) {
    this.trainSwitch = trainSwitch;
    this.gate = gate;
  }
  
  public Gate getGate() {
    return gate;
  }
  
  public int getSwitch() {
    return trainSwitch;
  }
  
  public boolean equals(Point p) {
    if(trainSwitch == p.trainSwitch &&
       gate == p.gate) {
      return true;
    } else {
      return false;
    }
  }

}
