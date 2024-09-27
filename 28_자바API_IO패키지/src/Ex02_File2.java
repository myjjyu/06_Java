
import java.io.File;

public class Ex02_File2 {
  public static void main(String[] args) {
    File f2 = new File("a/b/c/ target");
    System.out.println("isFile:" + f2.isFile());
    System.out.println("isDirectory:" + f2.isDirectory());
    System.out.println("isHidden:" + f2.isHidden());
    System.out.println("절대경로:" + f2.getAbsolutePath());
    System.out.println("존재여부:" + f2.exists());


    // 땅꿀파기
    f2.mkdirs();

    System.out.println(f2.getName());

    System.out.println(f2.getParent());

   System.out.println("--------------");
  }
}
