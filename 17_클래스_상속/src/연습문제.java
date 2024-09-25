class TV {
  // size 필드 (TV 크기)
  private int size;

  // size 필드 값을 반환하는 getter 메서드
  public int getSize() {
      return this.size;
  }

  // size 필드 값을 설정하는 setter 메서드
  public void setSize(int size) {
      this.size = size;
  }
}

// ColorTV 클래스 (TV를 상속)
class ColorTV extends TV {
  // 컬러 수를 저장할 필드
  private int colorCount;

  // colorCount 필드 값을 설정하는 메서드
  public void setColorCount(int colorCount) {
      this.colorCount = colorCount;
  }

  // TV 정보 출력 메서드
  public void printInfo() {
      System.out.println(getSize() + "인치 " + colorCount + "컬러");
  }
}

// main 메서드
public class 연습문제 {
  public static void main(String[] args) {
      ColorTV mytv = new ColorTV();  // ColorTV 객체 생성
      mytv.setSize(32);              // TV 크기 설정
      mytv.setColorCount(1024);      // 컬러 수 설정
      mytv.printInfo();              // 정보 출력
  }
}
