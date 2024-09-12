public class Ex04_If문_논리값_조건 {
 public static void main(String[] args) {
  boolean isKorean = true;

  if(isKorean == true){
    System.out.println("한국사람입니다----(1)");
  }
  if(isKorean == false){
    System.out.println("한국사람이 아닙니다----(2)");
  }
  if(isKorean != true){
    System.out.println("한국사람이 아닙니다----(3)");
  }

  if(isKorean != false){
    System.out.println("한국사람입니다----(4)");
  }
  if(isKorean){
    System.out.println("한국사람입니다----(5)");
  }
  if(isKorean){
    System.out.println("한국사람입니다----(6)");
  }
 } 
}
