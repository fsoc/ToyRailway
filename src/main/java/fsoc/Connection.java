package fsoc;

public class Connection {
  private SwitchPoint from;
  private SwitchPoint to;
  private boolean visited;

  /**
   * A connection between two switch points.
   *
   * @param from Origin
   * @param to Destination
   */
  public Connection(SwitchPoint from, SwitchPoint to) {
    this.from = from;
    this.to = to;
    this.visited = false;
  }

  public SwitchPoint getFrom() {
    return from;
  }

  public SwitchPoint getTo() {
    return to;
  }

  public boolean equals(Connection conn) {
    if (from.equals(conn.from) &&
        from.equals(conn.from)) {
      return true;
    } else {
      return false;
    }
  }
}
