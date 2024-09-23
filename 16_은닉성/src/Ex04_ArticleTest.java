public class Ex04_ArticleTest {
  public static void main(String[] args) {
    Article article =new Article(1, "테스트 게시물",
    "JavaBeans를 테스트 합니다." , "자바학생", "2024-09-23");

    System.out.println(article.getSeq());
    System.out.println(article.getSubject());
    System.out.println(article.getContent());
    System.out.println(article.getWriter());
    System.out.println(article.getRegDate());
  }
}
