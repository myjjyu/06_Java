public class Appstep2 {
  public static void main(String[] args) throws Exception {
    
    zilot z = new zilot("질럿1호", 150, 130, 100);
    z.move("저그멀티");
    z.attack("저그멀티");
    System.out.println("------");

    Dragun d = new Dragun("드라군1호", 200, 150, 100);
    d.move("저그멀티");
    d.attack("저그멀티");
    System.out.println("---------");


    Protoss p1 = new zilot("질럿1호", 150, 120, 100);
    Protoss p2 = new Dragun("드라군1호", 200, 150, 100);

    p1.move("저그 멀티");
    p1.attack("저그 멀티");
    p2.move("저그 멀티");
    p2.attack("저그 멀티");

  }
}
