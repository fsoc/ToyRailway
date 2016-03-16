package fsoc;

public class Connection {
  private Point from;
  private Point to;

  public Connection(Point from, Point to) {
    this.from = from;
    this.to = to;
  }

  public Point getFrom() {
    return from;
  }

  public Point getTo() {
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
