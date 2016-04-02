public class Generator  {
  public static void main(String[] args) {
    int num = 30000;
    System.out.println((int)(num) + " " +(int)(num+1));
    for ( int i = 1; i< num; i++) {
      System.out.println(i+ "B " + (int)(i+1) + "A");

    }
    System.out.println((int)(num) + "B 1A" );

  }
}
