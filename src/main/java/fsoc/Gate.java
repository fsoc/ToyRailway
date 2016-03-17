package fsoc;

public enum Gate {
  A(0), B(1), C(2);

  private final int value;

  private Gate(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
};
