import com.megaitacademy.packageex.impl.MainChar;
import com.megaitacademy.packageex.impl.Monster;

public class App{
  public static void main(String[] args) {
    
    Monster m = new Monster("골램", 500, 30, 200);
    MainChar j = new MainChar("기사", 1200, 120, 320);

m.walk();
m.run();
m.jump();

j.walk();
j.run();
j.jump();

m.attack();
j.defense();
j.attack();
m.evasion();
m.attack();
j.evasion();

j.pickUpItem();
j.talkNpc();
  }
}