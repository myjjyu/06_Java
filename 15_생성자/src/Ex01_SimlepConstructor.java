class MyBook {
  String tiile;
  int pages;
  String author;

  MyBook() {
    System.out.println("------ 생성자가 실행되었습니다 . --------");
    tiile = "자바 교과서";
    pages = 400;
    author = "자바 강사";
  }
}

public class Ex01_SimlepConstructor {
public static void main(String[] args) {
  MyBook myBook = new MyBook();

  System.out.println(myBook.tiile);
  System.out.println(myBook.pages);
  System.out.println(myBook.author);
}
}